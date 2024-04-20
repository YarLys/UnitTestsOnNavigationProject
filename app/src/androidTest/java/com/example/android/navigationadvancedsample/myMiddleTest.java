package com.example.android.navigationadvancedsample;

import static androidx.test.espresso.Espresso.*;
import static androidx.test.espresso.action.ViewActions.*;
import static androidx.test.espresso.assertion.ViewAssertions.*;
import static androidx.test.espresso.matcher.ViewMatchers.*;

import android.content.Intent;

import androidx.test.espresso.Espresso;
import androidx.test.espresso.action.ViewActions;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;

public class myMiddleTest {

    @Rule
    public ActivityTestRule<MainActivity> rule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void checkIntent() {
        Intent intent = new Intent();
        intent.putExtra("EXTRA", "TestText");

        rule.launchActivity(intent);

        onView(withId(R.id.about_btn))
                .perform(click());

        onView(withId(R.id.about_tv))
                .check(matches(withText("TestText")));
    }
}

