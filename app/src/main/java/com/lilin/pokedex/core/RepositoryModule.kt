package com.lilin.pokedex.core

import com.lilin.pokedex.data.PokeApiRepository
import com.lilin.pokedex.data.PokeApiRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.ktor.client.HttpClient
import io.ktor.client.engine.cio.CIO
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideRepository(client: HttpClient): PokeApiRepository {
        return PokeApiRepositoryImpl(client)
    }
}