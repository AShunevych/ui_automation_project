package com.ashunevich.wallapop_demo

import androidx.test.uiautomator.UiScrollable
import androidx.test.uiautomator.UiSelector
import com.kaspersky.components.kautomator.component.common.views.UiView
import com.kaspersky.components.kautomator.component.edit.UiEditText
import com.kaspersky.components.kautomator.component.scroll.UiScrollView
import com.kaspersky.components.kautomator.screen.UiScreen

fun itemDetailsScreen(func: ItemDetailsRobot.() -> Unit) =
    ItemDetailsRobot("com.wallapop").apply { func() }

class ItemDetailsRobot(override val packageName: String) : UiScreen<MainScreenRobot>() {

    val itemImagesList = UiScrollable(UiSelector().resourceId(TestHelper.viewId("container")))

    val itemImageView = UiView {
        withId(this@ItemDetailsRobot.packageName, "image1")
    }

    val titleEditText = UiEditText {
        withText("Title*")
    }

    val descriptionEditText = UiEditText {
        withText("Description*")
    }

    val typeOfClothingView = UiView {
        withId(this@ItemDetailsRobot.packageName, "extraInfoFieldObjectType")
    }

    val brandView = UiEditText {
        withId(this@ItemDetailsRobot.packageName, "extraInfoFieldBrand")
    }

    val subcategoryView = UiEditText {
        withId(this@ItemDetailsRobot.packageName, "extraInfoSection")
    }

    val itemConditionView = UiView {
        withId(this@ItemDetailsRobot.packageName, "conditionsSection")
    }

    val priceEditText = UiEditText {
        withText("Price*")
    }

    val continueButtonView = UiView {
        withId(this@ItemDetailsRobot.packageName, "button_action")
    }
}