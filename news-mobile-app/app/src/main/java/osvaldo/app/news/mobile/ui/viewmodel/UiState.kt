package osvaldo.app.news.mobile.ui.viewmodel

data class UiState(
    val news: NewsState = NewsState.Loading,
    val search: String = "",
)