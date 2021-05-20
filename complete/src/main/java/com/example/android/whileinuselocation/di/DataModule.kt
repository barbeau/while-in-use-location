package com.example.android.whileinuselocation.di

import android.content.Context
import com.example.android.whileinuselocation.data.db.LocationDao
import com.example.android.whileinuselocation.data.db.LocationDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * Configuration for DI on the repository and Room database using Hilt
 */
@Module
@InstallIn(SingletonComponent::class)
object DataModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): LocationDatabase =
            LocationDatabase.create(context)

    @Provides
    fun provideDao(database: LocationDatabase): LocationDao {
        return database.locationDao()
    }
}