package hr.dtakac.factorynews.repository

import hr.dtakac.factorynews.model.repository.ArticleModel

interface ArticleRepository {
    suspend fun getArticles(): ArticleModel
}