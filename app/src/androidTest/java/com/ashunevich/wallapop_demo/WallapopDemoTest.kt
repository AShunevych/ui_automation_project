package com.ashunevich.wallapop_demo

import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import org.junit.Test
import org.junit.runner.RunWith
import java.lang.Exception

@RunWith(AndroidJUnit4ClassRunner::class)
class WallapopDemoTest : TestCase() {

    val validEmail = "stihia7@yahoo.com"
    val validPass = "Pass12345"

    val validEmailArtem = "artiom2002@ukr.net"
    val validPassArtem = "Kleker99999"

    /**
     * Move app shortcut to main screen
     */

    @Test
    fun testUploadAndFindItem() {
        Thread.sleep(5000)
        before() {
            runApp {
                startApp()
            }
        }.after {

        }.run {
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
            step("Tap on Upload button") {
                mainScreen {
                    bottomNavigationUploadView.click()
                }
            }
            step("Select Category") {
                selectCategoryScreen {
                    categoryList.getChild(TestHelper.getRowItem(3, "rootView")).click()
                }
            }
            step("Enter Item details") {
                itemDetailsScreen {
                    titleEditText.click()
                    titleEditText.replaceText("Glasses")
                    descriptionEditText.click()
                    descriptionEditText.replaceText("Glasses")
                }
            }
            step("Try chooce a brand") {
                itemDetailsScreen {
                    try {
                        brandView.click()
                    } catch (e: Exception) {

                    }
                }
            }
            step("Choose Subcategory") {
                itemDetailsScreen {
                    subcategoryView.click()
                }
                subcategoryScreen {
                    typeOfSubcategory.getChild(TestHelper.getRowItem(OTHER, "rootView")).click()
                }
            }
            step("Choose Item condition") {
                itemDetailsScreen {
                    itemConditionView.click()
                }
                itemConditionScreen {
                    itemConditionList.getChild(TestHelper.getRowItem(AS_GOOD_AS_NEW, "rootView")).click()
                }
            }
            step("Set Price") {
                itemDetailsScreen {
                    priceEditText.click()
                    priceEditText.replaceText("10")
                }
            }
            step("Set Item image") {
                itemDetailsScreen {
                    itemImageView.click()
                }
            }

        }
    }

    @Test
    fun testUserWithoutLoginInExperience() {
        Thread.sleep(5000)
        loginScreen {
            startApp(true)
        }
        mainScreen {
//            verify()
            idleFor(5000)
            //TODO move to UPLOAD screen
        }

    }

}