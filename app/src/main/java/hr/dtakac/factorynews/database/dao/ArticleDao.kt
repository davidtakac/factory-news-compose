package hr.dtakac.factorynews.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import hr.dtakac.factorynews.model.database.ArticleDatabaseModel

@Dao
interface ArticleDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertOrReplaceAll(articles: List<ArticleDatabaseModel>)

    @Query("SELECT * FROM ArticleDatabaseModel")
    suspend fun getAll(): List<ArticleDatabaseModel>
}