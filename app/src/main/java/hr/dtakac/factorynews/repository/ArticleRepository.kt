package hr.dtakac.factorynews.repository

import hr.dtakac.factorynews.model.repository.ArticleRepositoryModel

interface ArticleRepository {
    suspend fun getArticles(): ArticleRepositoryModel
}