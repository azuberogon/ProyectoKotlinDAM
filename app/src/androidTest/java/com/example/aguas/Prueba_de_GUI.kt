package com.example.aguas


import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityEspressoTest {

    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun testButtonClickNavigation() {
        // Verifica que el botón está en pantalla y haz clic en él
        onView(withId(R.id.btnSiguiente)).check(matches(isDisplayed())).perform(click())

        // Verifica que la nueva actividad se muestra
        onView(withId(R.id.registroLayout)).check(matches(isDisplayed()))
    }

    @Test
    fun testButtonRegistrarNavigation() {
        // Verifica que el botón está en pantalla y haz clic en él
        onView(withId(R.id.btnRegistrar)).check(matches(isDisplayed())).perform(click())

        // Verifica que la actividad de registro se muestra
        onView(withId(R.id.registroLayout)).check(matches(isDisplayed()))
    }
}
