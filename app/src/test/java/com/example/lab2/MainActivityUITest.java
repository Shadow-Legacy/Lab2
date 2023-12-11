package com.example.lab2;

import androidx.test.espresso.Espresso;
import androidx.test.espresso.action.ViewActions;
import androidx.test.espresso.assertion.ViewAssertions;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.rule.ActivityTestRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class MainActivityUITest {

    @Rule
    public ActivityTestRule<MainActivity> activityRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void testCountButtonClicked_displaysResult() {
        // Perform actions with Espresso
        Espresso.onView(ViewMatchers.withId(R.id.editTextText)).perform(ViewActions.typeText("Hello, World!"));
        Espresso.onView(ViewMatchers.withId(R.id.spinner)).perform(ViewActions.click());
        Espresso.onData(ViewMatchers.hasToString("Characters")).perform(ViewActions.click());
        Espresso.onView(ViewMatchers.withId(R.id.button)).perform(ViewActions.click());

        // Check if the resultTextView displays the correct result
        Espresso.onView(ViewMatchers.withId(R.id.textView)).check(ViewAssertions.matches(ViewMatchers.withText("Result: 13")));
    }
}
