package com.ashunevich.wallapop_demo

import com.kaspersky.components.kautomator.component.common.views.UiView
import com.kaspersky.components.kautomator.component.text.UiButton
import com.kaspersky.components.kautomator.component.text.UiTextView
import com.kaspersky.components.kautomator.screen.UiScreen

fun filterSetupScreen(func: FilterSetupScreen.() -> Unit) =
    FilterSetupScreen("com.wallapop").apply { func() }


class FilterSetupScreen(override val packageName: String) : UiScreen<FilterSetupScreen>() {

    val rootView = UiView { withId(this@FilterSetupScreen.packageName, "rootView") }

    val applyFiltersButton = UiView { withId(this@FilterSetupScreen.packageName, "button") }

    val priceFrom = UiTextView{withId(this@FilterSetupScreen.packageName, "priceFrom") }

    val priceTo = UiTextView{withId(this@FilterSetupScreen.packageName, "priceTo") }

    val resetAllFilter = UiButton { withId(this@FilterSetupScreen.packageName, "resetButton") }

    val priceTittle = UiTextView{withId(this@FilterSetupScreen.packageName, "priceTitle") }

}