package com.example.aguas


import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.pressBack
import androidx.test.espresso.action.ViewActions.replaceText
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

   /* @Test
    fun testButtonClickNavigation() {
        // Verifica que el botón está en pantalla y haz clic en él
        onView(withId(R.id.btnSiguiente)).check(matches(isDisplayed())).perform(click())

        // Verifica que la nueva actividad se muestra
        onView(withId(R.id.registroLayout)).check(matches(isDisplayed()))
    }*/

    @Test
    fun testButtonRegistrarNavigation() {
        // Reemplaza el texto en el EditText de nombre de usuario y contraseña
        onView(withId(R.id.btnSiguiente)).check(matches(isDisplayed())).perform(click())
        onView(withId(R.id.editTxtNombreUsuario)).perform(replaceText("root"))
        onView(withId(R.id.editTxtContraseña)).perform(replaceText("root"))

        // Verifica que el botón está en pantalla y haz clic en él
        onView(withId(R.id.btnSiguiente)).check(matches(isDisplayed())).perform(click())

        // Verifica que la actividad de registro se muestra
        onView(withId(R.id.menuLayout)).check(matches(isDisplayed()))
    }

    @Test
    fun testButtonRegistrarNavigationV2() {
        // Reemplaza el texto en el EditText de nombre de usuario y contraseña
        // Verifica que la actividad principal se muestra
        onView(withId(R.id.mainLayout)).check(matches(isDisplayed()))

        // Verifica que el botón "Siguiente" está en pantalla y haz clic en él
        onView(withId(R.id.btnSiguiente)).check(matches(isDisplayed())).perform(click())

        // Verifica que se muestra el mensaje de error "Nombre de usuario o contraseña incorrectos"
        //onView(withText("Nombre de usuario o contraseña incorrectos")).check(matches(isDisplayed()))

        // Reemplaza el texto en el EditText de nombre de usuario y contraseña
        onView(withId(R.id.editTxtNombreUsuario)).perform(replaceText("root"))
        onView(withId(R.id.editTxtContraseña)).perform(replaceText("root"))

        // Verifica que el botón "Siguiente" está en pantalla y haz clic en él
        onView(withId(R.id.btnSiguiente)).check(matches(isDisplayed())).perform(click())

        // Verifica que la actividad de menú se muestra
        onView(withId(R.id.menuLayout)).check(matches(isDisplayed()))

      /*  // Vuelve a la actividad principal
        pressBack()

        // Verifica que la actividad principal se muestra
        onView(withId(R.id.mainLayout)).check(matches(isDisplayed()))

        // Verifica que el botón "Registrar" está en pantalla y haz clic en él
        onView(withId(R.id.btnRegistrar)).check(matches(isDisplayed())).perform(click())

        // Vuelve a la actividad principal
        pressBack()

        // Verifica que la actividad de registro se muestra
        onView(withId(R.id.registroLayout)).check(matches(isDisplayed()))*/
    }
}

