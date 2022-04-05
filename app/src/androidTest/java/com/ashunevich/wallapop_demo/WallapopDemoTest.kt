package com.ashunevich.wallapop_demo

import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import org.junit.Test
import org.junit.runner.RunWith

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
    fun testUploadAndFindItem(){
        Thread.sleep(5000)
        before() {
            runApp {
                startApp()
            }
        }.after {

        }.run {
            step("01 Star the App") {
                loginScreen{
                    startApp(andSkip = false)
                }
            }
            step("02 Tap on Sing up... and enter Email with Password") {
                loginScreen{
                    signIn(login = validEmailArtem,
                        password = validPassArtem)
                }
            }
            step("03 Tap on Upload button") {
                mainScreen {
                    bottomNavigationUploadView.click()
                    Thread.sleep(2000)
                }
            }
//            step("Main Screen") {
//                mainScreen {
//                    //TODO move to UPLOAD screen
//                }
//            }
        }
    }

    @Test
    fun testUserWithoutLoginInExperience(){
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