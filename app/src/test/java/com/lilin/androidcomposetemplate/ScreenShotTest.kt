package com.lilin.androidcomposetemplate

import androidx.activity.ComponentActivity
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.github.takahirom.roborazzi.RobolectricDeviceQualifiers
import com.lilin.androidcomposetemplate.screens.FirstScreenTestView
import com.lilin.androidcomposetemplate.screens.SecondScreenTestView
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.annotation.Config
import org.robolectric.annotation.GraphicsMode

@RunWith(AndroidJUnit4::class)
@GraphicsMode(GraphicsMode.Mode.NATIVE)
@Config(qualifiers = RobolectricDeviceQualifiers.Pixel7Pro)
class ScreenShotTest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<ComponentActivity>()

    @Test
    fun firstScreenShot() {
        composeTestRule.captureDevice(
            screenName = "first_screen",
        ) {
            FirstScreenTestView()
        }
    }

    @Test
    fun secondScreenShot() {
        composeTestRule.captureDevice(
            screenName = "second_screen",
        ) {
            SecondScreenTestView()
        }
    }
}
