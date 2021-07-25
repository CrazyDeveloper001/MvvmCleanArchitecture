package com.io.mvvmclean.di

import com.io.mvvmclean.data.repository.FirstRepositoryImpl
import com.io.mvvmclean.data.source.network.NetworkApi
import com.io.mvvmclean.domain.repository.FirstRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import dagger.hilt.components.SingletonComponent
import javax.inject.Inject
import javax.inject.Singleton


@InstallIn(ViewModelComponent::class)
@Module
object RepositoryModule {

    @ViewModelScoped
    @Provides
    fun provideFirstRepository(networkApi: NetworkApi): FirstRepository {
        return FirstRepositoryImpl(networkApi)
    }
}