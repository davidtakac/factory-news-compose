package hr.dtakac.factorynews.database

import androidx.room.Database
import androidx.room.RoomDatabase
import hr.dtakac.factorynews.model.database.Article
import hr.dtakac.factorynews.model.database.UpdateTimestamp

@Database(
    entities = [
        Article::class,
        UpdateTimestamp::class
    ],
    version = 1
)
abstract class FactoryNewsDatabase : RoomDatabase() {
    abstract fun articleDao(): ArticleDao
    abstract fun updateTimestampDao(): UpdateTimestampDao
}