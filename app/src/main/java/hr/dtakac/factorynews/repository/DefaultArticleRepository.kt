package hr.dtakac.factorynews.repository

import hr.dtakac.factorynews.api.ApiService
import hr.dtakac.factorynews.model.repository.ArticleModel
import javax.inject.Inject

class DefaultArticleRepository @Inject constructor(
    private val apiService: ApiService
) : ArticleRepository {
    override fun getArticles(): ArticleModel {
        TODO("Caching logic")
    }
}