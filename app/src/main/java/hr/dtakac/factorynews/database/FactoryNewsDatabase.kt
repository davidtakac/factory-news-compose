package hr.dtakac.factorynews.database

import androidx.room.Database
import androidx.room.RoomDatabase
import hr.dtakac.factorynews.database.dao.ArticleDao
import hr.dtakac.factorynews.database.dao.UpdateTimestampDao
import hr.dtakac.factorynews.model.database.ArticleDatabaseModel
import hr.dtakac.factorynews.model.database.UpdateTimestamp

@Database(
    entities = [
        ArticleDatabaseModel::class,
        UpdateTimestamp::class
    ],
    version = 1
)
abstract class FactoryNewsDatabase : RoomDatabase() {
    abstract fun articleDao(): ArticleDao
    abstract fun updateTimestampDao(): UpdateTimestampDao
}