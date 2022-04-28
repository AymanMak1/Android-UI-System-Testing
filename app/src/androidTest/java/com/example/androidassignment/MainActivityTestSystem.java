package com.example.androidassignment;


import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import androidx.test.espresso.ViewInteraction;
import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;
import androidx.test.runner.AndroidJUnit4;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class MainActivityTestSystem {

    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void mainActivityTestSystem() {
        ViewInteraction stringInput = onView(withId(R.id.firstInput));
        ViewInteraction indexInput = onView(withId(R.id.indexInput));
        ViewInteraction ctaBtn = onView(withId(R.id.cta));
        ViewInteraction output = onView(withId(R.id.output));

        stringInput.perform(replaceText("Ayman"), closeSoftKeyboard());
        indexInput.perform(replaceText("a"), closeSoftKeyboard());
        ctaBtn.perform(click());
        output.check(matches(withText("The given index is not a number")));

        indexInput.perform(replaceText("8"), closeSoftKeyboard());
        ctaBtn.perform(click());
        output.check(matches(withText("The index parameter has to be less than the length of the string.")));

        indexInput.perform(replaceText("3"), closeSoftKeyboard());
        ctaBtn.perform(click());
        output.check(matches(withText("The suffix is man")));
    }

    private static Matcher<View> childAtPosition(
            final Matcher<View> parentMatcher, final int position) {

        return new TypeSafeMatcher<View>() {
            @Override
            public void describeTo(Description description) {
                description.appendText("Child at position " + position + " in parent ");
                parentMatcher.describeTo(description);
            }

            @Override
            public boolean matchesSafely(View view) {
                ViewParent parent = view.getParent();
                return parent instanceof ViewGroup && parentMatcher.matches(parent)
                        && view.equals(((ViewGroup) parent).getChildAt(position));
            }
        };
    }
}
