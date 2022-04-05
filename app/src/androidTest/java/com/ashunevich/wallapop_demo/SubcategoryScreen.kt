package com.ashunevich.wallapop_demo

import androidx.test.uiautomator.UiScrollable
import androidx.test.uiautomator.UiSelector
import com.kaspersky.components.kautomator.screen.UiScreen

const val OTHER = 14

fun subcategoryScreen(func: SubcategoryRobot.() -> Unit) =
    SubcategoryRobot("com.wallapop").apply { func() }

class SubcategoryRobot(override val packageName: String) : UiScreen<SubcategoryRobot>() {

    val typeOfSubcategory = UiScrollable(UiSelector().resourceId(TestHelper.viewId("suggestionList")))

}