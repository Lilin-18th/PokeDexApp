package com.lilin.pokedex.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

sealed class PokemonContent {

    @Serializable
    data class PokemonList(
        val count: Long,
        val next: String?,
        val previous: String?,
        val results: List<Pokemon>,
    ) : PokemonContent()

    @Serializable
    data class Pokemon(
        val name: String,
        val url: String,
    )

    @Serializable
    data class PokemonDetail(
        val name: String,
        @SerialName("base_experience")
        val baseExperience: Long,
        val height: Long,
        @SerialName("is_default")
        val isDefault: Boolean,
        val order: Long,
        val weight: Long,
        @SerialName("location_area_encounters")
        val locationAreaEncounters: String,
    ) : PokemonContent()
}
