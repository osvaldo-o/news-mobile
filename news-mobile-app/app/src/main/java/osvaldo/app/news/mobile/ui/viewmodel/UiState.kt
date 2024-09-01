package osvaldo.app.news.mobile.ui.viewmodel

import osvaldo.app.news.mobile.domain.model.News

data class UiState(
    val newsState: NewsState = NewsState.Loading,
    val search: String = "",
    val newsDetail: News? = null,
    val isFilterActivated: Boolean = false,
    val language: String = ""
)