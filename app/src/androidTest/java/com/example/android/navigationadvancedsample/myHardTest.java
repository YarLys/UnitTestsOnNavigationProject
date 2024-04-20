package com.example.android.navigationadvancedsample;

import android.content.Intent;
import android.net.Uri;

import static androidx.test.espresso.Espresso.*;
import static androidx.test.espresso.action.ViewActions.*;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.*;

import static org.hamcrest.Matchers.allOf;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
import androidx.test.espresso.Espresso;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.rule.ActivityTestRule;


import org.junit.Rule;
import org.junit.Test;

public class myHardTest {
    private String url;

    @Rule
    public InstantTaskExecutorRule instantTaskExecutorRule;
    @Rule
    public ActivityTestRule activityTestRule;

    public myHardTest() {
        this.url = "http://www.example.com/";
        this.instantTaskExecutorRule = new InstantTaskExecutorRule();
        this.activityTestRule = new ActivityTestRule(MainActivity.class) {
            @Override
            protected Intent getActivityIntent() {
                return new Intent("android.intent.action.View", Uri.parse(url));
            }
        };
    }

    @Test
    public void allTests() {
        onView(allOf(withText(R.string.title_list), isDescendantOfA(withId(R.id.action_bar))))
                .check(matches(isDisplayed()));
    }
}