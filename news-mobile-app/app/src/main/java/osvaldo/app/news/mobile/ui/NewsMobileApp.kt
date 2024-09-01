package osvaldo.app.news.mobile.ui

import androidx.compose.runtime.Composable
import osvaldo.app.news.mobile.ui.screen.detail.DetailScreen
import osvaldo.app.news.mobile.ui.screen.home.HomeScreen
import osvaldo.app.news.mobile.ui.viewmodel.NewsEvent
import osvaldo.app.news.mobile.ui.viewmodel.UiState

@Composable
fun NewMobileApp(
    uiState: UiState,
    onEvent: (NewsEvent) -> Unit
) {
    if (uiState.newsDetail == null) {
        HomeScreen(
            uiState = uiState,
            onEvent = onEvent
        )
    } else {
        DetailScreen(
            news = uiState.newsDetail,
            onEvent = onEvent
        )
    }
}