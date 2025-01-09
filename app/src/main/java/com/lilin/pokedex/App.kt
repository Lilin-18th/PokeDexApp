package com.lilin.pokedex

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.lilin.pokedex.screens.FirstScreen
import com.lilin.pokedex.screens.SecondScreen
import kotlinx.serialization.Serializable

@Composable
fun App() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = SampleAppRoute.FirstScreen
    ) {
        composable<SampleAppRoute.FirstScreen> {
            FirstScreen(
                onClick = {
                    navController.navigate(SampleAppRoute.SecondScreen)
                }
            )
        }
        composable<SampleAppRoute.SecondScreen> {
            SecondScreen(
                onClickBack = {
                    navController.popBackStack()
                }
            )
        }
    }
}

object SampleAppRoute {
    @Serializable
    data object FirstScreen

    @Serializable
    data object SecondScreen
}
