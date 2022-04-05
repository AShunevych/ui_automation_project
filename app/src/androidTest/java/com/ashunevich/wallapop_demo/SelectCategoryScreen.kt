package com.ashunevich.wallapop_demo

import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.uiautomator.BySelector
import androidx.test.uiautomator.UiScrollable
import androidx.test.uiautomator.UiSelector
import com.kaspersky.components.kautomator.component.bottomnav.UiBottomNavigationView
import com.kaspersky.components.kautomator.component.common.builders.UiViewSelector
import com.kaspersky.components.kautomator.component.common.views.UiView
import com.kaspersky.components.kautomator.component.text.UiButton
import com.kaspersky.components.kautomator.component.text.UiTextView
import com.kaspersky.components.kautomator.screen.UiScreen
import io.github.kakaocup.kakao.recycler.KRecyclerView

fun selectCategoryScreen(func: SelectCategoryRobot.() -> Unit) =
    SelectCategoryRobot("com.wallapop").apply { func() }

class SelectCategoryRobot(override val packageName: String) : UiScreen<SelectCategoryRobot>() {

    val categoryList = UiScrollable(UiSelector().resourceId(TestHelper.viewId("suggestionList")))

}