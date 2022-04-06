package com.ashunevich.wallapop_demo

import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.platform.app.InstrumentationRegistry.getInstrumentation
import androidx.test.uiautomator.UiDevice
import androidx.test.uiautomator.UiSelector

fun appService(func: AppRunRobot.() -> Unit) = AppRunRobot().apply { func() }

class AppRunRobot {

    val device = UiDevice.getInstance(getInstrumentation())


    val allAppsButton = device.findObject(
        UiSelector().description("Wallapop")
    )

    fun startApp() {
        allAppsButton.clickAndWaitForNewWindow()
    }

    fun stopApp(){
        repeat(2){
            UiDevice.getInstance(InstrumentationRegistry.getInstrumentation()).pressBack()
        }
    }
}