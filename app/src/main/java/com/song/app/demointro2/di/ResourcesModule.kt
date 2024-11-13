package com.song.app.demointro2.di

import android.content.Context
import com.song.app.demointro2.util.provider.ResourcesProvider
import com.song.app.demointro2.util.provider.ResourcesProviderImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ResourcesModule {

    @Singleton
    @Provides
    fun provideResourcesProvider(@ApplicationContext context: Context): ResourcesProvider =
        ResourcesProviderImpl(context)

}
