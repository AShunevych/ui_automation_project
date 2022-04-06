package com.ashunevich.wallapop_demo

import com.kaspersky.components.kautomator.component.common.views.UiView
import com.kaspersky.components.kautomator.component.scroll.UiScrollView
import com.kaspersky.components.kautomator.component.text.UiTextView
import com.kaspersky.components.kautomator.screen.UiScreen


fun itemDescription(func: ItemDescriptionScreen.() -> Unit) =
    ItemDescriptionScreen("com.wallapop").apply { func() }

class ItemDescriptionScreen(override val packageName: String) : UiScreen<ItemDescriptionScreen>() {

    val mainScrollView = UiScrollView {
        withId(this@ItemDescriptionScreen.packageName, "content")
    }

    val textCashValue = UiTextView{
        withId(this@ItemDescriptionScreen.packageName,"text_cash_value")
    }

    val date = UiTextView{
        withId(this@ItemDescriptionScreen.packageName,"modified")
    }

    val backToFilterScreen = UiView{
        withContentDescription("Navigate up")
    }
}