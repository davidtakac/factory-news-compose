package hr.dtakac.factorynews.model.repository

import hr.dtakac.factorynews.model.database.ArticleDatabaseModel

sealed interface ArticleRepositoryModel

data class Success(
    val articles: List<ArticleDatabaseModel>
) : ArticleRepositoryModel

data class Error(
    val throwable: Throwable?
) : ArticleRepositoryModel