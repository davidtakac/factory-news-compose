package hr.dtakac.factorynews.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import hr.dtakac.factorynews.dispatcher.DefaultDispatcherProvider
import hr.dtakac.factorynews.dispatcher.DispatcherProvider

@Module
@InstallIn(SingletonComponent::class)
abstract class DispatcherProviderModule {
    @Binds
    abstract fun bindDispatcherProvider(default: DefaultDispatcherProvider): DispatcherProvider
}