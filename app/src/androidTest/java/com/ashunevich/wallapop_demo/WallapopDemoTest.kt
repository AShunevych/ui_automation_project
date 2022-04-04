package com.ashunevich.wallapop_demo

import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class WallapopDemoTest {

    val validEmail = "stihia7@yahoo.com"
    val validPass = "Pass12345"

    /**
     * Move app shortcut to main screen
     */

    @Before
    fun setup(){
       runApp {
           startApp()
       }

    }

    @Test
    fun testUploadAndFindItem(){
        Thread.sleep(5000)
        loginRobot{
            startApp(andSkip = false)

            Thread.sleep(2000)

            signIn(login = validEmail,
                password = validPass)
            Thread.sleep(2000)
        }
        tutorialRobot{
            //TODO pass/skip tutorial with valid account
        }
        mainScreen {
            //TODO move to UPLOAD screen
        }
    }

    @Test
    fun testUserWithoutLoginInExperience(){
        Thread.sleep(5000)
        loginRobot {
            startApp(true)
        }
        mainScreen {
//            verify()
            idleFor(5000)
           //TODO move to UPLOAD screen
        }

    }

}