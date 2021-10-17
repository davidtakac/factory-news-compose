package hr.dtakac.factorynews

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import dagger.hilt.android.AndroidEntryPoint
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
        Text(text = "Hello compose!")
    }
}