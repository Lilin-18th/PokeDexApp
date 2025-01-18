package com.lilin.pokedex.screens

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import com.lilin.pokedex.MainViewModel
import com.lilin.pokedex.screens.component.RotateAnimation
import com.lilin.pokedex.ui.theme.PokeDexTopIntent
import com.lilin.pokedex.ui.theme.PokeDexTopState

@Composable
fun PokeDexTopScreen(
    onClick: () -> Unit,
    viewModel: MainViewModel,
    modifier: Modifier = Modifier,
) {
    val state by viewModel.state.collectAsState()

    LaunchedEffect(viewModel) {
        viewModel.handleIntent(PokeDexTopIntent.LoadPokemonList)
    }

    PokeDexTopScreen(
        onClick = onClick,
        state = state,
    )
}

@Composable
private fun PokeDexTopScreen(
    onClick: () -> Unit,
    state: PokeDexTopState,
    modifier: Modifier = Modifier,
) {
    Scaffold {
        when {
            state.loading -> {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(it),
                    contentAlignment = Alignment.Center
                ) {
                    RotateAnimation()
                }
            }

            else -> {
                LazyColumn(
                    modifier = modifier.padding(it),
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    items(state.pokemonList) { item ->
                        Text(
                            text = item.name,
                            modifier = Modifier.clickable {
                                onClick()
                            }
                        )
                    }
                }
            }
        }
    }
}

//@Composable
//internal fun FirstScreenTestView() {
//    PokeDexTopScreen(
//        onClick = {}
//    )
//}
//
//@Preview
//@Composable
//fun FirstScreenPreview() {
//    PokeDexTopScreen(
//        onClick = {}
//    )
//}
