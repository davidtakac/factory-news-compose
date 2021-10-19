package hr.dtakac.factorynews.model.api

import com.google.gson.annotations.SerializedName

data class Articles(
    @SerializedName("status")
    val status: String,
    @SerializedName("soruce")
    val source: String,
    @SerializedName("sortBy")
    val sortBy: String,
    @SerializedName("articles")
    val articles: List<ArticleApiModel>
)