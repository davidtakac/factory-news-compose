package hr.dtakac.factorynews

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import dagger.hilt.android.AndroidEntryPoint
import hr.dtakac.factorynews.model.ui.ArticleCell
import hr.dtakac.factorynews.viewmodel.ArticleListViewModel

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val viewModel: ArticleListViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Screen()
        }
    }

    @Preview
    @Composable
    fun Screen() {
        Articles(articleCells = viewModel.articleCells)
    }

    @Composable
    fun Articles(articleCells: List<ArticleCell>) {
        LazyColumn {
            articleCells.forEach {
                item {
                    Text(text = it.title)
                }
            }
        }
    }
}