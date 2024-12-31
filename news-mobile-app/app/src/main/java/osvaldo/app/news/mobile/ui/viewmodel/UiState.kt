package osvaldo.app.news.mobile.ui.viewmodel

import osvaldo.app.news.mobile.domain.model.News

data class UiState(
    val newsState: NewsState = NewsState.Loading,
    val newsDetail: News? = null,
    val search: String = "Alien",
    val isFilterActivated: Boolean = false,
    val language: String = "es",
    val sortBy: String = "popularity",
)