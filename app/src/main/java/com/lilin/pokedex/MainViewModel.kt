package com.lilin.pokedex

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lilin.pokedex.domain.GetPokeDataUseCase
import com.lilin.pokedex.ui.theme.PokeDexTopIntent
import com.lilin.pokedex.ui.theme.PokeDexTopState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getPokeDataUseCase: GetPokeDataUseCase,
) : ViewModel() {
    private val _state = MutableStateFlow(PokeDexTopState())
    val state: StateFlow<PokeDexTopState> = _state

    fun handleIntent(intent: PokeDexTopIntent) {
        viewModelScope.launch {
            when (intent) {
                is PokeDexTopIntent.LoadPokemonList -> getPokemonList()
                is PokeDexTopIntent.RetryGetPokemonList -> getPokemonList()
                is PokeDexTopIntent.GetPokemonDetail -> {}
            }
        }
    }

    private suspend fun getPokemonList() {
        _state.value = _state.value.copy(
            loading = true,
            error = "",
        )
        runCatching {
            getPokeDataUseCase.getPokemonList()
        }.onSuccess {
            _state.value = PokeDexTopState(
                loading = false,
                pokemonList = it,
            )
        }.onFailure {
            _state.value = _state.value.copy(
                loading = false,
                error = it.message ?: "Unknown error",
            )
        }
    }
}