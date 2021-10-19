package hr.dtakac.factorynews.viewmodel

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import hr.dtakac.factorynews.dispatcher.DispatcherProvider
import hr.dtakac.factorynews.model.repository.Error
import hr.dtakac.factorynews.model.repository.Success
import hr.dtakac.factorynews.model.ui.ArticleUiModel
import hr.dtakac.factorynews.repository.ArticleRepository
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class ArticleListViewModel @Inject constructor(
    private val repository: ArticleRepository,
    private val dispatcherProvider: DispatcherProvider
) : ViewModel() {
    val articleCells = mutableStateListOf<ArticleUiModel>()
    val showError = mutableStateOf(false)

    init {
        viewModelScope.launch {
            getArticles()
        }
    }

    private suspend fun getArticles() {
        when (val response = repository.getArticles()) {
            is Success -> handleSuccess(response)
            is Error -> handleError(response)
        }
    }

    private suspend fun handleSuccess(success: Success) {
        withContext(dispatcherProvider.computation) {
            val cells = success
                .articles
                .map {
                    ArticleUiModel(
                        url = it.url,
                        title = it.title,
                        imageUrl = it.imageUrl
                    )
                }
            articleCells.clear()
            articleCells.addAll(cells)
        }
    }

    private suspend fun handleError(error: Error) {
        showError.value = true
    }
}