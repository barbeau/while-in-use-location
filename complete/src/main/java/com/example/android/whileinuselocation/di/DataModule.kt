package com.example.android.whileinuselocation.di

import android.content.Context
import com.example.android.whileinuselocation.LocationApplication
import com.example.android.whileinuselocation.data.SharedLocationManager
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * Configuration for DI on the repository and shared location manager
 */
@Module
@InstallIn(SingletonComponent::class)
object DataModule {

    @Provides
    @Singleton
    fun provideSharedLocationManager(
        @ApplicationContext context: Context
    ): SharedLocationManager =
        SharedLocationManager(context, (context.applicationContext as LocationApplication).applicationScope)
}