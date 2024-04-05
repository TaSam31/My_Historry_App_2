package com.example.myhistorryapp2

import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityInstrumentedTest {

    @Test
    fun testResultDisplayed() {
        // Start the MainActivity
        val activityScenario = ActivityScenario.launch(MainActivity::class.java)

        // Input age into the EditText
        Espresso.onView(ViewMatchers.withId(R.id.enterage)).perform(ViewActions.typeText("50"), ViewActions.closeSoftKeyboard())

        // Click on the Result button
        Espresso.onView(withId(R.id.resultbtn)).perform(ViewActions.click())

        // Check if the result TextView is displayed
        Espresso.onView(withId(R.id.textResult)).check(matches(isDisplayed()))

        // Check if the correct result text is displayed
        Espresso.onView(withId(R.id.textResult)).check(matches(withText("You are around the same age as Julius Caesar was a Roman general and statesman who played a critical role in the events that led to the demise of the Roman Republic and the rise of the Roman Empire.")))

        // Close the activity
        activityScenario.close()
    }

    @Test
    fun testClearButton() {
        // Start the MainActivity
        val activityScenario = ActivityScenario.launch(MainActivity::class.java)

        // Input age into the EditText
        Espresso.onView(ViewMatchers.withId(R.id.enterage)).perform(ViewActions.typeText("50"), ViewActions.closeSoftKeyboard())

        // Click on the Result button
        Espresso.onView(withId(R.id.resultbtn)).perform(ViewActions.click())

        // Check if the result TextView is displayed
        Espresso.onView(withId(R.id.textResult)).check(matches(isDisplayed()))

        // Click on the Clear button
        Espresso.onView(withId(R.id.clearbtn)).perform(ViewActions.click())

        // Check if the EditText is cleared
        Espresso.onView(withId(R.id.enterage)).check(matches(withText("")))

        // Check if the result TextView is cleared
        Espresso.onView(withId(R.id.textResult)).check(matches(withText("")))

        // Close the activity
        activityScenario.close()
    }
}
