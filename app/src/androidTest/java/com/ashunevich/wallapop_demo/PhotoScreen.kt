package com.ashunevich.wallapop_demo

import androidx.test.uiautomator.UiScrollable
import androidx.test.uiautomator.UiSelector
import com.kaspersky.components.kautomator.component.bottomnav.UiBottomNavigationView
import com.kaspersky.components.kautomator.component.common.views.UiView
import com.kaspersky.components.kautomator.component.text.UiButton
import com.kaspersky.components.kautomator.screen.UiScreen

fun photoScreen(func: PhotoScreenRobot.() -> Unit) = PhotoScreenRobot("com.wallapop").apply { func() }

class PhotoScreenRobot(override val packageName: String) : UiScreen<PhotoScreenRobot>() {

    val shotButtonView = UiButton {
        withId(this@PhotoScreenRobot.packageName, "cameraShutter")
    }

    val acceptImagesTakenView = UiView {
        withId(this@PhotoScreenRobot.packageName, "acceptImagesTaken")
    }

    val imageView = UiView {
        withId(this@PhotoScreenRobot.packageName, "image")
    }

}