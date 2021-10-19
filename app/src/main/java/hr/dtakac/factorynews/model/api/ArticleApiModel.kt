package hr.dtakac.factorynews.model.api

import com.google.gson.annotations.SerializedName

data class ArticleApiModel(
    @SerializedName("author")
    val author: String,
    @SerializedName("title")
    val title: String,
    @SerializedName("description")
    val description: String,
    @SerializedName("url")
    val url: String,
    @SerializedName("urlToImage")
    val imageUrl: String,
    @SerializedName("publishedAt")
    val publishedAt: String?
)