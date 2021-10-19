package hr.dtakac.factorynews.model.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class ArticleDatabaseModel(
    @PrimaryKey
    val url: String,
    val author: String,
    val title: String,
    val description: String,
    val imageUrl: String,
    val publishedAt: String?
)