package hr.dtakac.factorynews

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import dagger.hilt.android.AndroidEntryPoint
import hr.dtakac.factorynews.model.ui.ArticleUiModel
import hr.dtakac.factorynews.theme.AppTheme
import hr.dtakac.factorynews.viewmodel.ArticleListViewModel

private const val TAG = "MainActivity"

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val viewModel: ArticleListViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppTheme {
                Articles(data = viewModel.articleCells)
            }
        }
    }

    @Composable
    fun Articles(data: List<ArticleUiModel>) {
        LazyColumn(
            modifier = Modifier.background(
                color = MaterialTheme.colors.background
            )
        ) {
            data.forEachIndexed { idx, it ->
                item {
                    ArticleCell(
                        data = it,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(
                                start = 16.dp,
                                end = 16.dp,
                                top = if (idx == 0) 16.dp else 8.dp,
                                bottom = if (idx == data.lastIndex) 16.dp else 0.dp
                            ),
                        onClick = { Log.d(TAG, "Articles: ${it.title}") }
                    )
                }
            }
        }
    }

    @Composable
    fun ArticleCell(
        data: ArticleUiModel,
        modifier: Modifier = Modifier,
        onClick: () -> Unit = {}
    ) {
        Surface(
            modifier = modifier,
            shape = MaterialTheme.shapes.large,
            color = MaterialTheme.colors.surface,
            contentColor = MaterialTheme.colors.onSurface,
            elevation = 4.dp
        ) {
            Row(
                modifier = Modifier
                    .clickable { onClick.invoke() }
                    .padding(12.dp)
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
}