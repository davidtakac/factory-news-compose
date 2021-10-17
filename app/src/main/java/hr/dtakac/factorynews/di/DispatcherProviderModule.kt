package hr.dtakac.factorynews.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import hr.dtakac.factorynews.dispatcher.DefaultDispatcherProvider
import hr.dtakac.factorynews.dispatcher.DispatcherProvider
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class DispatcherProviderModule {
    @Binds
    @Singleton
    abstract fun bindDispatcherProvider(default: DefaultDispatcherProvider): DispatcherProvider
}