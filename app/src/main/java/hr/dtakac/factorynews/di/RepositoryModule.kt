package hr.dtakac.factorynews.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import hr.dtakac.factorynews.repository.ArticleRepository
import hr.dtakac.factorynews.repository.DefaultArticleRepository

@Module
@InstallIn(ViewModelComponent::class)
abstract class RepositoryModule {
    @Binds
    abstract fun bindArticleRepository(default: DefaultArticleRepository): ArticleRepository
}