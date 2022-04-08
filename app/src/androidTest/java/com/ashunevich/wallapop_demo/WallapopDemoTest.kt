package com.ashunevich.wallapop_demo

import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.uiautomator.UiDevice
import com.kaspersky.components.kautomator.component.text.UiButton
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import org.junit.After
import org.junit.Test
import org.junit.runner.RunWith
import java.lang.Exception

@RunWith(AndroidJUnit4ClassRunner::class)
class WallapopDemoTest : TestCase() {

    val validEmail = "stihia7@yahoo.com"
    val validPass = "Pass12345"

    val validEmailArtem = "artiom2002@ukr.net"
    val validPassArtem = "Kleker99999"

    @After
    fun after() {
        TestHelper.closeTheApp()
    }

    /**
     * Move app shortcut to main screen
     */
//
//    @Test
//    fun testUploadAndFindItem() {
//        Thread.sleep(5000)
//        before() {
//            appService {
//                startApp()
//            }
//        }.after {
//
//        }.run {
//            step("Star the App") {
//                loginScreen {
//                    startApp(andSkip = false)
//                }
//            }
//            step("Tap on Sing up... and enter Email with Password") {
//                loginScreen {
//                    signIn(
//                        login = validEmailArtem,
//                        password = validPassArtem
//                    )
//                }
//            }
//            step("Tap on Upload button") {
//                mainScreen {
//                    bottomNavigationUploadView.click()
//                }
//            }
//            step("Select Category") {
//                selectCategoryScreen {
//                    categoryList.getChild(TestHelper.getRowItem(3, "rootView")).click()
//                }
//            }
//            step("Enter Item details") {
//                itemDetailsScreen {
//                    titleEditText.click()
//                    titleEditText.replaceText("Glasses")
//                    descriptionEditText.click()
//                    descriptionEditText.replaceText("Glasses")
//                }
//            }
//            step("Try chooce a brand") {
//                itemDetailsScreen {
//                    try {
//                        brandView.click()
//                    } catch (e: Exception) {
//
//                    }
//                }
//            }
//            step("Choose Subcategory") {
//                itemDetailsScreen {
//                    subcategoryView.click()
//                }
//                subcategoryScreen {
//                    typeOfSubcategory.getChild(TestHelper.getRowItem(OTHER, "rootView")).click()
//                }
//            }
//            step("Choose Item condition") {
//                itemDetailsScreen {
//                    itemConditionView.click()
//                }
//                itemConditionScreen {
//                    itemConditionList.getChild(TestHelper.getRowItem(AS_GOOD_AS_NEW, "rootView"))
//                        .click()
//                }
//            }
//            step("Set Price") {
//                itemDetailsScreen {
//                    priceEditText.click()
//                    priceEditText.replaceText("10")
//                    TestHelper.closeKeyboard()
//                }
//            }
//            step("Tap on set Item image") {
//                itemDetailsScreen {
//                    itemImageView.click()
//                }
//            }
//            step("Take a photo and set Image") {
//                photoScreen {
//                    shotButtonView.click()
//                    imageView.isDisplayed()
//                    acceptImagesTakenView.click()
//                }
//            }
//            step("Tap on Continue") {
//                itemDetailsScreen {
//                    continueButtonView.click()
//                }
//            }
//
//            step("Tap on Continue") {
//                itemDetailsScreen {
//                    continueButtonView.click()
//                }
//            }
//
//            step("Tap on Continue") {
//                itemDetailsScreen {
//                    continueButtonView.click()
//                }
//            }
//
//            step("Verify that item is listed") {
//                itemListedScreen {
//                    gotItButtonView.click()
//                    originalTitleView.isDisplayed()
//                }
//            }
//        }
//    }

    @Test
    fun testUserFilterInteraction() {
        val minimumPrice = 0
        val maximumPrice = 5

        Thread.sleep(5000)
        before {
            appService {
                startApp()
            }
        }.after {
        }.run {
            step("Star the App") {
                loginScreen {
                    startApp(andSkip = true)
                }
            }
            step("Go to filter screen") {
                mainScreen {
                    Thread.sleep(5000)
                    itemFilters.getChild(TestHelper.getRowItem(1, "categoryIcon")).click()
                    Thread.sleep(2000)
                }
            }
            step("Select date filter") {

                filterScreen {
                    Thread.sleep(2000)
                    filterCounter {
                        hasText("1")
                        click()
                    }
                }

                filterSetupScreen {
                    Thread.sleep(5000)
                    rootView {
                        click()
                    }

                    filterSubCategory {
                        Thread.sleep(2000)
                        itemFilters.getChild(TestHelper.getRowItem(0, "name")).click()
                        idleFor(2000)
                        applyButton {
                            hasText("See products listed 24 hours ago")
                            click()
                        }
                    }

                    applyFiltersButton {
                        click()
                    }

                }
            }

            step("Select price filter") {
                filterScreen {
                    Thread.sleep(5000)
                    filterCounter {
                        hasText("2")
                    }

                    priceFilter {
                        click()
                    }

                    Thread.sleep(5000)
                    priceSelector {
                        selectMinimumPrice(price = minimumPrice)
                        selectMaximumPrice(price = maximumPrice)

                        applyPriceFilter {
                            click()
                        }
                    }
                }
            }
        }

    }
}