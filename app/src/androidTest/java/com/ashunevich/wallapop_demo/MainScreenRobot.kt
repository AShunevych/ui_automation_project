package com.ashunevich.wallapop_demo

import com.kaspersky.components.kautomator.component.common.views.UiView
import com.kaspersky.components.kautomator.screen.UiScreen

fun mainScreen(func: MainScreenRobot.() -> Unit) = MainScreenRobot("com.wallapop").apply { func() }

class MainScreenRobot(override val packageName: String) : UiScreen<MainScreenRobot>() {

    val uploadButton = UiView {
        withIndex(2) { withId(this@MainScreenRobot.packageName, "upload")
        withContentDescription("Upload")}
    }//TODO automator can't find?

    fun verify(){
        idleFor(5000)
        uploadButton.isDisplayed()
    }

    fun moveToUploadScreen(){
        uploadButton.click()
    }
}