package com.ashunevich.wallapop_demo

import androidx.test.uiautomator.UiScrollable
import androidx.test.uiautomator.UiSelector
import com.kaspersky.components.kautomator.component.text.UiButton
import com.kaspersky.components.kautomator.screen.UiScreen

fun filterSubCategory(func: FilterSubCategoryScreen.() -> Unit) =
    FilterSubCategoryScreen("com.wallapop").apply { func() }

class FilterSubCategoryScreen(override val packageName: String) : UiScreen<FilterSubCategoryScreen>() {

    val itemFilters  = UiScrollable(UiSelector().resourceId(TestHelper.viewId("list")))

    val applyButton = UiButton { withId(this@FilterSubCategoryScreen.packageName, "apply") }

}