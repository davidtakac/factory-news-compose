package hr.dtakac.factorynews.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import hr.dtakac.factorynews.repository.ArticleRepository
import hr.dtakac.factorynews.repository.DefaultArticleRepository

@Module
@InstallIn(ViewModelComponent::class)
abstract class RepositoryModule {
    @Binds
    @ViewModelScoped
    abstract fun provideArticleRepository(default: DefaultArticleRepository): ArticleRepository
}