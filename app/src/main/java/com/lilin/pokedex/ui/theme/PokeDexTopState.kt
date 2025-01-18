package com.lilin.pokedex.ui.theme

import com.lilin.pokedex.domain.model.PokemonDetail

data class PokeDexTopState(
    val loading: Boolean = false,
    val pokemonList: List<PokemonDetail> = emptyList(),
    val error: String = "",
)