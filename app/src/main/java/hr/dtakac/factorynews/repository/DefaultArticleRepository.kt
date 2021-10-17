package hr.dtakac.factorynews.repository

import hr.dtakac.factorynews.API_KEY
import hr.dtakac.factorynews.STALE_DATA_THRESHOLD
import hr.dtakac.factorynews.api.ApiService
import hr.dtakac.factorynews.dispatcher.DispatcherProvider
import hr.dtakac.factorynews.database.dao.ArticleDao
import hr.dtakac.factorynews.database.dao.UpdateTimestampDao
import hr.dtakac.factorynews.model.database.Article
import hr.dtakac.factorynews.model.repository.ArticleModel
import hr.dtakac.factorynews.model.repository.Error
import hr.dtakac.factorynews.model.repository.Success
import kotlinx.coroutines.withContext
import java.time.ZonedDateTime
import java.time.temporal.ChronoUnit
import javax.inject.Inject

class DefaultArticleRepository @Inject constructor(
    private val apiService: ApiService,
    private val articleDao: ArticleDao,
    private val updateTimestampDao: UpdateTimestampDao,
    private val dispatcherProvider: DispatcherProvider
) : ArticleRepository {
    override suspend fun getArticles(): ArticleModel {
        if (isCachedDataStale()) {
            try {
                updateDatabase()
            } catch (e: Throwable) {
                return Error(e)
            }
        }
        return try {
            Success(articleDao.getAll())
        } catch (e: Throwable) {
            Error(e)
        }
    }

    private suspend fun updateDatabase() {
        val response = apiService.getArticles(
            source = "bbc-news",
            sortBy = "top",
            apiKey = API_KEY
        )
        val articleEntities = withContext(dispatcherProvider.computation) {
            response.articles
                .map {
                    Article(
                        author = it.author,
                        title = it.title,
                        description = it.description,
                        url = it.url,
                        imageUrl = it.imageUrl,
                        publishedAt = it.publishedAt
                    )
                }
        }
        articleDao.insertOrReplaceAll(articleEntities)
        updateTimestampDao.insertOrUpdate(ZonedDateTime.now())
    }

    private suspend fun isCachedDataStale(): Boolean {
        val lastUpdate = withContext(dispatcherProvider.io) {
            updateTimestampDao.get()
        }
        return when (lastUpdate) {
            null -> true
            else -> {
                ChronoUnit.MINUTES.between(
                    lastUpdate, ZonedDateTime.now()
                ) > STALE_DATA_THRESHOLD
            }
        }
    }
}