package com.ashunevich.wallapop_demo

import com.kaspersky.components.kautomator.component.bottomnav.UiBottomNavigationView
import com.kaspersky.components.kautomator.component.common.views.UiView
import com.kaspersky.components.kautomator.screen.UiScreen

fun mainScreen(func: MainScreenRobot.() -> Unit) = MainScreenRobot("com.wallapop").apply { func() }

class MainScreenRobot(override val packageName: String) : UiScreen<MainScreenRobot>() {

    val bottomNavigationUploadView =
        UiBottomNavigationView { withId(this@MainScreenRobot.packageName, "upload") }

}