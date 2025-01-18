package com.lilin.pokedex.data

import com.lilin.pokedex.data.model.PokemonContent

interface PokeApiRepository {
    suspend fun getPokemon(): PokemonContent.PokemonList
    suspend fun getPokemonDetail(name: String): PokemonContent.PokemonDetail
}