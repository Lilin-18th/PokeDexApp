package com.lilin.pokedex.domain

import com.lilin.pokedex.data.PokeApiRepository
import com.lilin.pokedex.data.model.PokemonContent
import com.lilin.pokedex.domain.model.PokemonDetail
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class GetPokeDataUseCaseImpl @Inject constructor(
    private val pokeApiRepository: PokeApiRepository,
) : GetPokeDataUseCase {
    override suspend fun getPokemonList(): List<PokemonDetail> = withContext(Dispatchers.IO) {
        pokeApiRepository.let { repository ->
            repository.getPokemon().results.map { pokemon ->
                repository.getPokemonDetail(pokemon.name).let {
                    PokemonDetail(
                        name = it.name,
                        baseExperience = it.baseExperience,
                        height = it.height,
                        isDefault = it.isDefault,
                        order = it.order,
                        weight = it.weight,
                        locationAreaEncounters = it.locationAreaEncounters
                    )
                }
            }
        }
    }

    override suspend fun getPokemonDetail(): PokemonContent.Pokemon {
        TODO("Not yet implemented")
    }
}