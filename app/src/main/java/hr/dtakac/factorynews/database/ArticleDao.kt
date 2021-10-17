package hr.dtakac.factorynews.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import hr.dtakac.factorynews.model.database.Article

@Dao
interface ArticleDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertOrReplaceAll(articles: List<Article>)

    @Query("SELECT * FROM Article")
    suspend fun getAll(): List<Article>
}