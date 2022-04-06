package com.ashunevich.wallapop_demo

import androidx.test.uiautomator.UiScrollable
import androidx.test.uiautomator.UiSelector
import com.kaspersky.components.kautomator.component.bottomnav.UiBottomNavigationView
import com.kaspersky.components.kautomator.screen.UiScreen

fun mainScreen(func: MainScreenRobot.() -> Unit) = MainScreenRobot("com.wallapop").apply { func() }

class MainScreenRobot(override val packageName: String) : UiScreen<MainScreenRobot>() {

    val bottomNavigationUploadView =
        UiBottomNavigationView { withId(this@MainScreenRobot.packageName, "upload") }

    val itemFilters  = UiScrollable(UiSelector().resourceId(TestHelper.viewId("recyclerView")))
}