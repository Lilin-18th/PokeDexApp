package com.lilin.androidcomposetemplate

import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.test.junit4.AndroidComposeTestRule
import androidx.compose.ui.test.onRoot
import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.github.takahirom.roborazzi.captureRoboImage

fun <A : ComponentActivity> AndroidComposeTestRule<ActivityScenarioRule<A>, A>.captureDevice(
    screenName: String,
    content: @Composable () -> Unit,
) {
    activity.setContent {
        content()
    }
    onRoot()
        .captureRoboImage(filePath = "build/outputs/roborazzi/$screenName.png")
}
