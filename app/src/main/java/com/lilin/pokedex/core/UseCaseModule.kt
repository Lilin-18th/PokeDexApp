package com.lilin.pokedex.core

import com.lilin.pokedex.data.PokeApiRepository
import com.lilin.pokedex.domain.GetPokeDataUseCaseImpl
import com.lilin.pokedex.domain.GetPokeDataUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    @Provides
    @Singleton
    fun provideUseCase(repository: PokeApiRepository): GetPokeDataUseCase {
        return GetPokeDataUseCaseImpl(repository)
    }
}