package com.example.lab2;

import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private EditText editText;
    private Spinner spinner;
    private Button countButton;
    private TextView resultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initializing GUI elements
        editText = findViewById(R.id.editTextText);
        spinner = findViewById(R.id.spinner);
        countButton = findViewById(R.id.button);
        resultTextView = findViewById(R.id.textView);

        // Populate the spinner with choices
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this,
                R.array.count_options,
                android.R.layout.simple_spinner_item
        );
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        // Set a listener for the spinner
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                // Do nothing here for now
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // Do nothing here for now
            }
        });

        // Set a click listener for the countButton
        countButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get the selected option from the spinner
                String selectedOption = spinner.getSelectedItem().toString();

                // Get the entered text from the editText
                String enteredText = editText.getText().toString().trim();

                // Validate if the entered text is not empty
                if (enteredText.isEmpty()) {
                    // Show a warning using Toast
                    Toast.makeText(MainActivity.this, R.string.warning_empty_text, Toast.LENGTH_SHORT).show();
                    return;
                }

                // Perform counting based on the selected option
                int count;
                if (selectedOption.equals(getString(R.string.words))) {
                    count = Functionality.countWords(enteredText);
                } else {
                    count = Functionality.countCharacters(enteredText);
                }

                // Display the result in the resultTextView
                resultTextView.setText(getString(R.string.result, count));
            }
        });
    }
}