package osvaldo.app.news.mobile

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.collectAsState
import androidx.lifecycle.viewmodel.compose.viewModel
import osvaldo.app.news.mobile.core.theme.NewsmobileTheme
import osvaldo.app.news.mobile.ui.NewMobileApp
import osvaldo.app.news.mobile.ui.viewmodel.NewsViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NewsmobileTheme {
                val viewModel: NewsViewModel = viewModel(factory = NewsViewModel.Factory)
                val uiState = viewModel.uiState.collectAsState().value
                NewMobileApp(
                    uiState = uiState,
                    onEvent = viewModel::onEvent
                )
            }
        }
    }
}