package com.example.android.navigationadvancedsample;

import static androidx.test.espresso.Espresso.*;
import static androidx.test.espresso.action.ViewActions.*;
import static androidx.test.espresso.assertion.ViewAssertions.*;
import static androidx.test.espresso.matcher.ViewMatchers.*;

import androidx.test.espresso.Espresso;
import androidx.test.espresso.action.ViewActions;
import androidx.test.ext.junit.rules.ActivityScenarioRule;

import org.junit.Rule;
import org.junit.Test;

public class middleTest {

    @Rule
    public ActivityScenarioRule<MainActivity> activityScenarioRule =
            new ActivityScenarioRule<MainActivity>(MainActivity.class);

    @Test
    public void checkTextRegister() {
        onView(withId(R.id.form))
                .perform(click());
        onView(withHint("Name"))
                .perform(typeText("123"), ViewActions.closeSoftKeyboard());
        onView(withText(R.string.sign_up))
                .perform(click());
        //onView(withText("Done"))
          //      .check(matches(withText("Done")));
        Espresso.pressBack();
        onView(withId(R.id.username_text))
                .check(matches(withText("123")));
    }
}
