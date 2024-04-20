package com.example.android.navigationadvancedsample;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.*;
import static androidx.test.espresso.matcher.ViewMatchers.*;

import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.rules.ActivityScenarioRule;

import org.junit.Rule;
import org.junit.Test;

public class myEasyTest {
    @Rule
    public ActivityScenarioRule<MainActivity> activityScenarioRule =
            new ActivityScenarioRule<MainActivity>(MainActivity.class);

    @Test
    public void checkTextOnAvatar() {
        onView(withId(R.id.form)) // перешли на Register
                .perform(click());
        onView(withText(R.string.select_an_avatar))
                .check(matches(isDisplayed()));
    }
    @Test
    public void checkNavigation() {
        onView(withId(R.id.game_title)) // проверили Welcome!
                .check(matches(isDisplayed()));
        onView(withId(R.id.list)) // перешли на Leaderboard
                .perform(click());
        onView(withText("Person 4")) // проверили Person 4
                .check(matches(isDisplayed()));
        onView(withId(R.id.form)) // перешли на Register
                .perform(click());
        onView(withHint("Name"))
                .check(matches(isDisplayed()));
    }
    @Test
    public void checkInputText() {
        onView(withId(R.id.form))
                .perform(click());
        onView(withHint("Name"))
                .perform(typeText("MyName"),closeSoftKeyboard())
                .check(matches(withText("MyName")));
    }

}