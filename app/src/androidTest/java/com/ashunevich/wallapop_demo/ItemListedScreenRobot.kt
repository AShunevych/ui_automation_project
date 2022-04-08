package com.ashunevich.wallapop_demo

import androidx.test.uiautomator.UiScrollable
import androidx.test.uiautomator.UiSelector
import com.kaspersky.components.kautomator.component.bottomnav.UiBottomNavigationView
import com.kaspersky.components.kautomator.component.common.views.UiView
import com.kaspersky.components.kautomator.component.text.UiButton
import com.kaspersky.components.kautomator.component.text.UiTextView
import com.kaspersky.components.kautomator.screen.UiScreen

fun itemListedScreen(func: ItemListedScreenRobot.() -> Unit) = ItemListedScreenRobot("com.wallapop").apply { func() }

class ItemListedScreenRobot(override val packageName: String) : UiScreen<ItemListedScreenRobot>() {

    val gotItButtonView =
        UiView {
            withId(this@ItemListedScreenRobot.packageName, "finish")
//            withText("Got it")
        }

    val laterButtonView =
        UiButton {
            withId(this@ItemListedScreenRobot.packageName, "finish")
//            withText("Finish")
        }

    val originalTitleView =
        UiTextView {
            withId(this@ItemListedScreenRobot.packageName, "originalTitle")
            withText("Glasses")
        }

}