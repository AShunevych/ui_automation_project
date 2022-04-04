package com.ashunevich.wallapop_demo

import com.kaspersky.components.kautomator.screen.UiScreen


fun tutorialRobot(func: TutorialScreen.() -> Unit) = TutorialScreen("com.wallapop").apply { func() }

class TutorialScreen(override val packageName: String) : UiScreen<TutorialScreen>() {



}