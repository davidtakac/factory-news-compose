package hr.dtakac.factorynews.model.repository

import hr.dtakac.factorynews.model.database.Article

sealed interface ArticleModel

data class Success(
    val articles: List<Article>
) : ArticleModel

data class Error(
    val throwable: Throwable?
) : ArticleModel