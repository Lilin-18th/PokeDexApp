package com.lilin.pokedex.data

import com.lilin.pokedex.data.model.PokemonContent
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import javax.inject.Inject

class PokeApiRepositoryImpl @Inject constructor(
    private val client: HttpClient,
) : PokeApiRepository {

    override suspend fun getPokemon(): PokemonContent.PokemonList {
        return client.get("https://pokeapi.co/api/v2/pokemon").body()
    }

    override suspend fun getPokemonDetail(name: String): PokemonContent.PokemonDetail {
        return client.get("https://pokeapi.co/api/v2/pokemon/$name").body()
    }
}