package com.example.myimad_project2

import android.view.View
import android.widget.ProgressBar
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.filters.LargeTest
import org.hamcrest.Matcher
import org.hamcrest.TypeSafeMatcher
import org.junit.Rule
import org.junit.Test
import org.junit.runner.Description
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@LargeTest
class NextpageTest {

    // This rule launches the activity under test before each test method annotated with @Test
    @get:Rule
    var activityRule: ActivityScenarioRule<Nextpage> = ActivityScenarioRule(Nextpage::class.java)

    @Test
    fun testFeedButton() {
        // Find and click on the feed button
        onView(withId(R.id.buttonHungry)).perform(click())

        // Check if the hunger progress bar increases
        onView(withId(R.id.hungerProgressBar)).check(matches(withProgress(10)))
    }

    @Test
    fun testCleanButton() {
        // Find and click on the clean button
        onView(withId(R.id.buttonClean)).perform(click())

        // Check if the clean progress bar increases
        onView(withId(R.id.cleanProgressBar)).check(matches(withProgress(10)))
    }

    @Test
    fun testHappyButton() {
        // Find and click on the happy button
        onView(withId(R.id.buttonHappy)).perform(click())

        // Check if the happy progress bar increases
        onView(withId(R.id.happyProgressBar)).check(matches(withProgress(10)))
    }

    // Custom matcher for checking progress of a ProgressBar
    private fun withProgress(progress: Int): Matcher<in View>? = object : TypeSafeMatcher<View>() {
        override fun describeTo(description: org.hamcrest.Description?) {
            description?.appendText("Checking ProgressBar progress: $progress")
        }

        override fun matchesSafely(item: View?): Boolean {
            return if (item is ProgressBar) {
                item.progress == progress
            } else {
                false
            }
        }
    }
}

private fun Description?.appendText(s: String) {
    TODO("Not yet implemented")
}
