package com.ashunevich.wallapop_demo

import androidx.test.platform.app.InstrumentationRegistry.getInstrumentation
import androidx.test.uiautomator.UiDevice
import androidx.test.uiautomator.UiSelector

fun runApp(func: AppRunRobot.() -> Unit) = AppRunRobot().apply { func() }

class AppRunRobot {

    val device = UiDevice.getInstance(getInstrumentation())


    val allAppsButton = device.findObject(
        UiSelector().description("Wallapop")
    )

    fun startApp() {
        allAppsButton.clickAndWaitForNewWindow()
    }

    fun stopApp(){
        device.pressHome()
        device.pressRecentApps()

        device.swipe(1033,1346,531,1346,20)

        val clear  = device.findObject(UiSelector()
            .resourceId("com.android.systemui:id/button")
            .text("CLEAR ALL"))

        if (clear.exists())
        {
            clear.click();
        }
    }
}