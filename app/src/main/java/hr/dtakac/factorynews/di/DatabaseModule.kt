package hr.dtakac.factorynews.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import hr.dtakac.factorynews.database.dao.ArticleDao
import hr.dtakac.factorynews.database.FactoryNewsDatabase
import hr.dtakac.factorynews.database.dao.UpdateTimestampDao
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {
    @Provides
    @Singleton
    fun provideArticleDao(database: FactoryNewsDatabase): ArticleDao {
        return database.articleDao()
    }

    @Provides
    @Singleton
    fun provideUpdateTimestampDao(database: FactoryNewsDatabase): UpdateTimestampDao {
        return database.updateTimestampDao()
    }

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext applicationContext: Context): FactoryNewsDatabase {
        return Room.databaseBuilder(
            applicationContext,
            FactoryNewsDatabase::class.java, "factory_news_database"
        ).build()
    }
}