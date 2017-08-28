package com.rijo.chasedemoapp.ui.searchScreen;

import android.support.test.espresso.intent.rule.IntentsTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.rijo.chasedemoapp.R;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.junit.Assert.*;

/**
 * Created by rijogeorge on 8/26/17.
 */
@RunWith(AndroidJUnit4.class)
public class SearchActivityTest {

    @Rule
    public IntentsTestRule<SearchActivity> mActivityRule = new IntentsTestRule<>(SearchActivity.class);

    String stringTpoType="helloz";

    @BeforeClass
    public static void setUp() throws Exception {
        String stringTpoType="helloz";

    }

    @Test
    public void UiIsLoaded() throws Exception {
        onView(withId(R.id.searchEditText)).check(matches(isDisplayed()));
    }

    @Test
    public void resetButtonWorks() throws Exception {
        onView(withId(R.id.searchEditText)).perform(typeText(stringTpoType), closeSoftKeyboard());
        onView(withId(R.id.resetButton)).perform(click());
        onView(withId(R.id.searchEditText)).check(matches(withText("")));
    }
}