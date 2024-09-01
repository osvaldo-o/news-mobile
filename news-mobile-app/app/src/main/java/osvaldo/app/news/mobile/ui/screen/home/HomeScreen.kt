package osvaldo.app.news.mobile.ui.screen.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import osvaldo.app.news.mobile.ui.viewmodel.NewsEvent
import osvaldo.app.news.mobile.ui.viewmodel.NewsState
import osvaldo.app.news.mobile.ui.viewmodel.UiState

@Composable
fun HomeScreen(
    uiState: UiState,
    onEvent: (NewsEvent) -> Unit
) {
    Scaffold { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            when(uiState.newsState) {
                NewsState.Error -> ErrorView()
                NewsState.Loading -> LoadingView()
                is NewsState.Success ->
                    NewsView(
                        news = uiState.newsState.news,
                        onNewsDetail = { onEvent(NewsEvent.OnNewsDetail(it)) }
                    )
            }
        }
    }
}

@Composable
fun CenterScreen(
    component: @Composable () -> Unit
) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        component
    }
}

@Composable
fun ErrorView() {
    CenterScreen {
        Text(text = "Sucedio un error")
    }
}

@Composable
fun LoadingView() {
    CenterScreen {
        CircularProgressIndicator()
    }
}