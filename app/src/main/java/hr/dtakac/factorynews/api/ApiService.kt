package hr.dtakac.factorynews.api

import hr.dtakac.factorynews.model.api.Articles
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("/articles")
    suspend fun getArticles(
        @Query("source") source: String,
        @Query("sortBy") sortBy: String,
        @Query("apiKey") apiKey: String
    ) : Articles
}