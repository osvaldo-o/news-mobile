package osvaldo.app.news.mobile.ui.screen.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import osvaldo.app.news.mobile.ui.viewmodel.NewsEvent
import osvaldo.app.news.mobile.ui.viewmodel.NewsState
import osvaldo.app.news.mobile.ui.viewmodel.UiState

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    uiState: UiState,
    onEvent: (NewsEvent) -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Noticias del Mundo") },
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
           SearchView(
               searchValue = uiState.search,
               onValueChange = { onEvent(NewsEvent.OnChangeSearch(it)) },
               search = { onEvent(NewsEvent.SearchNews) }
           )
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