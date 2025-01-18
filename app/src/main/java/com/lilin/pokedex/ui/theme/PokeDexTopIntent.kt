package com.lilin.pokedex.ui.theme

sealed class PokeDexTopIntent {
    data object LoadPokemonList : PokeDexTopIntent()
    data object RetryGetPokemonList: PokeDexTopIntent()
    data class GetPokemonDetail(val id: String): PokeDexTopIntent()
}