package com.lilin.pokedex

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.lilin.pokedex.screens.PokeDexTopScreen
import com.lilin.pokedex.screens.SecondScreen
import kotlinx.serialization.Serializable

@Composable
fun App() {
    val navController = rememberNavController()
    val viewModel: MainViewModel = hiltViewModel()

    NavHost(
        navController = navController,
        startDestination = SampleAppRoute.PokeDexTopScreen
    ) {
        composable<SampleAppRoute.PokeDexTopScreen> {
            PokeDexTopScreen(
                onClick = {
                    navController.navigate(SampleAppRoute.PokemonDetailScreen)
                },
                viewModel = viewModel,
            )
        }
        composable<SampleAppRoute.PokemonDetailScreen> {
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
    data object PokeDexTopScreen

    @Serializable
    data object PokemonDetailScreen
}
