package osvaldo.app.news.mobile.ui.viewmodel

import osvaldo.app.news.mobile.domain.model.News

sealed interface NewsEvent {
    data class OnNewsDetail(val news: News?): NewsEvent
    data class OnChangeSearch(val search: String): NewsEvent
    data object SearchNews: NewsEvent
    data object OnFilterActivated: NewsEvent
    data class OnChangeLanguage(val language: String): NewsEvent
    data class OnChangeSortBy(val sortBy: String): NewsEvent
}