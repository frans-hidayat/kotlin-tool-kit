package com.frame.kotlintoolkit.data.auth

import com.frame.kotlintoolkit.core.di.NetworkModule
import com.frame.kotlintoolkit.data.auth.remote.api.AuthApi
import com.frame.kotlintoolkit.data.auth.repository.AuthRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AuthModule {
    @Provides
    @Singleton
    fun provideAuthRepository(dataSource: AuthRepository.Network): AuthRepository = dataSource
}