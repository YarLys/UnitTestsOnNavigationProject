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

public class easyTest {
    @Rule
    public ActivityScenarioRule<MainActivity> activityScenarioRule =
            new ActivityScenarioRule<MainActivity>(MainActivity.class);

    @Test
    public void checkTextOnGameTitle() {
        onView(withId(R.id.game_title))
                .check(matches(withText("Welcome!")));
    }
    @Test
    public void checkTextOnTitleAbout() {
        onView(withId(R.id.about_btn))
                .perform(click());
        onView(withId(R.id.about_tv))
                .check(matches(withText("About")));
    }
    @Test
    public void checkPictureOnDisplay() {
        onView(withId(R.id.title_image))
                .check(matches(isDisplayed()));
    }
    @Test
    public void changeTextRegistration() {
        onView(withId(R.id.form))
                .perform(click());
        onView(withId(R.id.username_text))
                .perform(typeText("YaroslavYaroslavYaroslavYaroslavYaroslavYaroslavYaroslavYaroslav"), closeSoftKeyboard())
                .check(matches(withText("YaroslavYaroslavYaroslavYaroslavYaroslavYaroslavYaroslavYaroslav")));
    }
}
