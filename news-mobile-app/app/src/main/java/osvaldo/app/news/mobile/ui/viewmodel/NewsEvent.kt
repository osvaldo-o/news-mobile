package osvaldo.app.news.mobile.ui.viewmodel

import osvaldo.app.news.mobile.domain.model.News

sealed interface NewsEvent {
    data class OnNewsDetail(val news: News?): NewsEvent
    data class OnChangeSearch(val search: String): NewsEvent
    data object SearchNews: NewsEvent
}