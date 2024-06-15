package com.raflisalam.newsapp.di

import android.app.Application
import com.raflisalam.newsapp.data.manager.LocalUserManagerImpl
import com.raflisalam.newsapp.domain.manager.LocalUserManager
import com.raflisalam.newsapp.domain.usecase.AppEntryUseCases
import com.raflisalam.newsapp.domain.usecase.ReadAppEntry
import com.raflisalam.newsapp.domain.usecase.SaveAppEntry
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideLocalUserManager(
        application: Application
    ): LocalUserManager = LocalUserManagerImpl(application)

    @Provides
    @Singleton
    fun provideAppEntryUseCases(
        localUserManager: LocalUserManager
    ) = AppEntryUseCases(
        readAppEntry = ReadAppEntry(localUserManager),
        saveAppEntry = SaveAppEntry(localUserManager)
    )
}