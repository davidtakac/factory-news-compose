package hr.dtakac.factorynews.database

import androidx.room.Database
import androidx.room.RoomDatabase
import hr.dtakac.factorynews.model.database.Article

@Database(
    entities = [Article::class],
    version = 1
)
abstract class FactoryNewsDatabase : RoomDatabase() {
    abstract fun articleDao(): ArticleDao
}