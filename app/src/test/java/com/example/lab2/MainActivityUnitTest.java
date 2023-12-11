package com.example.lab2;

import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class MainActivityUnitTest {
    @Mock
    private EditText mockEditText;

    @Mock
    private Spinner mockSpinner;

    @Mock
    private Button mockCountButton;

    @Mock
    private TextView mockResultTextView;

    private MainActivity mainActivity;

    @Before
    public void setUp() {
        mainActivity = Mockito.spy(MainActivity.class);
        mainActivity.editText = mockEditText;
        mainActivity.spinner = mockSpinner;
        mainActivity.countButton = mockCountButton;
        mainActivity.resultTextView = mockResultTextView;
    }

    @Test
    public void testCountButtonClicked_withEmptyText_showWarningToast() {
        Mockito.when(mockEditText.getText()).thenReturn(new Editable.Factory().newEditable(""));
        mainActivity.onClick(mockCountButton);

        // Verify that a warning Toast is shown
        verify(mainActivity).showToast(any(String.class));
    }

    @Test
    public void testCountButtonClicked_withNonEmptyText_countCharacters() {
        // Mocking the selected item in the spinner
        Mockito.when(mockSpinner.getSelectedItem()).thenReturn("Characters");

        // Mocking the entered text
        Mockito.when(mockEditText.getText()).thenReturn(new Editable.Factory().newEditable("Hello, World!"));

        mainActivity.onClick(mockCountButton);

        // Verify that the resultTextView is set with the correct result
        verify(mockResultTextView).setText("Result: 13");
    }

}