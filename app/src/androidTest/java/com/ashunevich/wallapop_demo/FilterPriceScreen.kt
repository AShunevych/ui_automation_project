package com.ashunevich.wallapop_demo

import androidx.test.uiautomator.UiScrollable
import androidx.test.uiautomator.UiSelector
import com.kaspersky.components.kautomator.component.text.UiButton
import com.kaspersky.components.kautomator.screen.UiScreen

fun priceSelector(func: FilterPriceScreen.() -> Unit) =
    FilterPriceScreen("com.wallapop").apply { func() }


class FilterPriceScreen(override val packageName: String) : UiScreen<FilterPriceScreen>() {

    val minimumPriceList = UiScrollable(UiSelector().resourceId(TestHelper.viewId("leftList")))

    val maximumPriceList = UiScrollable(UiSelector().resourceId(TestHelper.viewId("rightList")))

    val applyPriceFilter = UiButton { withId(this@FilterPriceScreen.packageName, "bottomSheetButton") }

    fun selectMinimumPrice(price:Int){
        minimumPriceList.getChild(TestHelper.getRowItem(price, "name")).click()
    }

    fun selectMaximumPrice(price:Int){
        maximumPriceList.getChild(TestHelper.getRowItem(price, "name")).click()
    }



}