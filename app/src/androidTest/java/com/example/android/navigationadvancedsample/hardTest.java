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

public class hardTest {
    private String username = "Person 2";
    private String url;

    @Rule
    public InstantTaskExecutorRule instantTaskExecutorRule;
    @Rule
    public ActivityTestRule activityTestRule;

    public hardTest() {
        this.url = "http://www.example.com/user/"+username;
        this.instantTaskExecutorRule = new InstantTaskExecutorRule();
        this.activityTestRule = new ActivityTestRule(MainActivity.class) {
            @Override
            protected Intent getActivityIntent() {
                return new Intent("android.intent.action.View", Uri.parse(url));
            }
        };
    }

    public void assertProfile() {
        onView(withId(R.id.profile_user_name))
                .check(matches(withText(username)));
    }

    public void assertList() {
        onView(allOf(withText(R.string.title_list), isDescendantOfA(withId(R.id.action_bar))))
                .check(matches(isDisplayed()));
    }

    public void assertHome() {
        onView(withText(R.string.welcome))
                .check(matches(isDisplayed()));
    }

    @Test
    public void allTests() {
        assertProfile();

        Espresso.pressBack();
        assertList();

        Espresso.pressBack();
        assertHome();
    }
}
