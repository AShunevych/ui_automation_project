package com.ashunevich.wallapop_demo

import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.uiautomator.UiDevice
import com.kaspersky.components.kautomator.component.common.views.UiView
import com.kaspersky.components.kautomator.component.edit.UiEditText
import com.kaspersky.components.kautomator.component.text.UiButton
import com.kaspersky.components.kautomator.screen.UiScreen

fun loginScreen(func: LoginScreen.() -> Unit) = LoginScreen("com.wallapop").apply { func() }

class LoginScreen(override val packageName: String) : UiScreen<LoginScreen>() {

    val signUpWithEmail = UiView { withId(this@LoginScreen.packageName, "loginCTA") }
    val skip = UiButton { withId(this@LoginScreen.packageName, "close") }

    val emailView = UiView { withId(this@LoginScreen.packageName, "emailInput") }
    val emailEdit = UiEditText {
        withId(this@LoginScreen.packageName, "edit")
        withClassName("android.widget.EditText")
    }

    val passwordEdit = UiEditText {
        withIndex(1) { withId(this@LoginScreen.packageName, "edit") }
        withClassName("android.widget.EditText")
    }

    val passwordView = UiView {
        withId(this@LoginScreen.packageName, "passwordInput")
    }

    val loginButton = UiButton { withId(this@LoginScreen.packageName, "button") }

    fun startApp(andSkip: Boolean) {
        idleFor(12)
        if (andSkip) {
            skip.click()
        } else {
            signUpWithEmail.click()
        }
    }

    fun signIn(login: String, password: String) {

        emailView.click()
        emailEdit.replaceText(login)

        passwordView.click()
        passwordEdit.replaceText(password)

        UiDevice.getInstance(InstrumentationRegistry.getInstrumentation()).pressBack()

        loginButton.click()
    }
}