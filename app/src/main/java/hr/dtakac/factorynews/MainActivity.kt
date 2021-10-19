package hr.dtakac.factorynews

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import dagger.hilt.android.AndroidEntryPoint
import hr.dtakac.factorynews.model.ui.ArticleUiModel
import hr.dtakac.factorynews.viewmodel.ArticleListViewModel

private const val TAG = "MainActivity"
@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val viewModel: ArticleListViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Articles(data = viewModel.articleCells)
        }
    }

    @Composable
    fun Articles(data: List<ArticleUiModel>) {
        LazyColumn {
            data.forEach {
                item {
                    Article(
                        data = it,
                        onClick = { Log.d(TAG, "Articles: ${it.title}") }
                    )
                }
            }
        }
    }

    @Composable
    fun Article(data: ArticleUiModel, onClick: () -> Unit = {}) {
        Row(
            modifier = Modifier
                .padding(
                    start = 16.dp,
                    end = 16.dp,
                    top = 8.dp,
                    bottom = 8.dp
                )
                .clickable { onClick.invoke() }
        ) {
            Image(
                painter = rememberImagePainter(data.imageUrl),
                contentDescription = resources.getString(R.string.accessibility_article_image_description),
                modifier = Modifier.size(96.dp),
                contentScale = ContentScale.Crop
            )
            Column(
                modifier = Modifier.padding(
                    start = 8.dp,
                    top = 8.dp
                )
            ) {
                Text(text = data.title)
            }
        }
    }
}