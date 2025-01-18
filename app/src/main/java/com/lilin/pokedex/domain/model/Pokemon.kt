package com.lilin.pokedex.domain.model

data class PokemonEntity(
    val name: String,
    val url: String,
)

data class PokemonDetail(
    val name: String,
    val baseExperience: Long,
    val height: Long,
    val isDefault: Boolean,
    val order: Long,
    val weight: Long,
    val locationAreaEncounters: String,
)