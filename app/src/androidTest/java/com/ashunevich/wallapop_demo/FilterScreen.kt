package com.ashunevich.wallapop_demo

import androidx.test.uiautomator.UiScrollable
import androidx.test.uiautomator.UiSelector
import com.kaspersky.components.kautomator.component.bottomnav.UiBottomNavigationView
import com.kaspersky.components.kautomator.component.common.views.UiView
import com.kaspersky.components.kautomator.component.text.UiTextView
import com.kaspersky.components.kautomator.screen.UiScreen

fun filterScreen(func: FilterScreen.() -> Unit) =
    FilterScreen("com.wallapop").apply { func() }


class FilterScreen(override val packageName: String) : UiScreen<FilterScreen>() {

    val filterCounter  = UiTextView { withId(this@FilterScreen.packageName, "leftCounter") }

    val itemList = UiScrollable(UiSelector().resourceId(TestHelper.viewId("wallList")))

    val priceFilter = UiTextView{withText("Price")}

    val backToFilterScreen = UiView{
        withContentDescription("Navigate up")
    }
}