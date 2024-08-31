package osvaldo.app.news.mobile.ui.viewmodel

import osvaldo.app.news.mobile.domain.model.News

sealed interface NewsState {
    data class Success(val news: List<News>): NewsState
    data object Loading: NewsState
    data object Error: NewsState
}
