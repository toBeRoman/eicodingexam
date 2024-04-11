package com.tobyrodinroman.eicodingexam.di

import android.content.Context
import com.tobyrodinroman.eicodingexam.data.repository.LevelsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideLevelsRepository(@ApplicationContext context: Context): LevelsRepository {
        return LevelsRepository(context)
    }
}
