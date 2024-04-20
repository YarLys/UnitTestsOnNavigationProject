package com.example.android.navigationadvancedsample;

import android.content.Intent;
import static androidx.test.espresso.Espresso.*;
import static androidx.test.espresso.action.ViewActions.*;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.*;

import androidx.test.espresso.Espresso;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.rule.ActivityTestRule;


import org.junit.Rule;
import org.junit.Test;

public class middle2Test {
    @Rule
    public ActivityTestRule<MainActivity> rule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void demonstrateIntent() {
        Intent intent = new Intent();
        intent.putExtra("EXTRA", "Test");

        rule.launchActivity(intent);

        onView(withId(R.id.game_title))
                .check(matches(withText("Test")));
    }

    @Test
    public void useAppContext() {
        MainActivity activity = rule.getActivity();
        assert activity.getMyString().equals("MyString");
    }
}
