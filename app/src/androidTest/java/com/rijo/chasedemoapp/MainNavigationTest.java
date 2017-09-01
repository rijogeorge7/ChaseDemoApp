package com.rijo.chasedemoapp;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.espresso.contrib.RecyclerViewActions;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.rijo.chasedemoapp.ui.searchScreen.SearchActivity;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.Espresso.pressBack;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.junit.Assert.*;

/**
 * Instrumentation test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class MainNavigationTest {

    @Rule
    public ActivityTestRule<SearchActivity> mActivityRule = new ActivityTestRule<>(SearchActivity.class);

    @Test
    public void mainNavigationTest() throws Exception {
        final String artistName="tom waits";
        onView(withId(R.id.searchEditText)).check(matches(isDisplayed()));
        onView(withId(R.id.searchEditText)).perform(typeText(artistName), closeSoftKeyboard());
        onView(withId(R.id.searchButton)).check(matches(isDisplayed()));
        onView(withId(R.id.searchButton)).perform(click());
        onView(withId(R.id.searchResultView)).check(matches(isDisplayed()));
        onView(withId(R.id.searchResultView)).perform(RecyclerViewActions.actionOnItemAtPosition(1, click()));
        onView(withId(R.id.artistName)).check(matches(isDisplayed()));
        pressBack();
        onView(withId(R.id.searchResultView)).check(matches(isDisplayed()));
        pressBack();
        onView(withId(R.id.searchEditText)).check(matches(isDisplayed()));
    }

}
