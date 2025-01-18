package com.lilin.pokedex.domain

import com.lilin.pokedex.data.model.PokemonContent
import com.lilin.pokedex.domain.model.PokemonDetail

interface GetPokeDataUseCase {
    suspend fun getPokemonList(): List<PokemonDetail>
    suspend fun getPokemonDetail(): PokemonContent.Pokemon
}