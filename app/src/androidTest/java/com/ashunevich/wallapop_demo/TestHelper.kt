package com.ashunevich.wallapop_demo

import android.view.accessibility.AccessibilityWindowInfo
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.platform.app.InstrumentationRegistry.getInstrumentation
import androidx.test.uiautomator.UiDevice
import androidx.test.uiautomator.UiObject
import androidx.test.uiautomator.UiSelector
import com.kaspersky.components.kautomator.component.text.UiButton
import junit.framework.Assert.assertEquals


const val APP_PACKAGE_NAME = "com.wallapop"

object TestHelper {
    var mDevice: UiDevice = UiDevice.getInstance(getInstrumentation())
    fun byId(id: String): UiObject {
        return mDevice.findObject(
            UiSelector()
                .resourceId(APP_PACKAGE_NAME.toString() + ":id/" + id)
        )
    }

    fun viewId(id: String): String {
        return APP_PACKAGE_NAME.toString() + ":id/" + id
    }

    @Throws(Exception::class)
    fun checkActionBarTitle(title: String) {
        val tvActionBarTitle: UiObject = mDevice.findObject(
            UiSelector()
                .resourceId(APP_PACKAGE_NAME.toString() + ":id/tvActionBarTitle")
        )
        assertEquals(title.toUpperCase(), tvActionBarTitle.getText())
    }

    @Throws(Exception::class)
    fun verifyText(id: String, title: String?) {
        val tvActionBarTitle: UiObject = mDevice.findObject(
            UiSelector()
                .resourceId(APP_PACKAGE_NAME.toString() + ":id/" + id)
        )
        assertEquals(title, tvActionBarTitle.getText())
    }

    @Throws(Exception::class)
    fun clickAndWait(id: String) {
        val cancelButton: UiObject = byId(id)
        cancelButton.clickAndWaitForNewWindow()
    }

    fun resourceId(resourceId: String): String {
        return APP_PACKAGE_NAME.toString() + ":id/" + resourceId
    }

    fun getRowItem(itemIndex: Int, resourceId: String): UiSelector {
        return UiSelector()
            .resourceId(resourceId(resourceId))
            .enabled(true).instance(itemIndex)
    }

    fun isKeyboardOpened(): Boolean {
        for (window in getInstrumentation().getUiAutomation()
            .getWindows()) {
            if (window.type == AccessibilityWindowInfo.TYPE_INPUT_METHOD) {
                return true
            }
        }
        return false
    }

    fun closeKeyboard() {
        if(isKeyboardOpened()){
            UiDevice.getInstance(getInstrumentation()).pressBack()
        }
    }

    fun closeTheApp() {
        UiDevice.getInstance(InstrumentationRegistry.getInstrumentation()).pressRecentApps()
        UiButton {
            withText("Close all")
        }.click()
    }
}