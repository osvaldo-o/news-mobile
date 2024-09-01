package osvaldo.app.news.mobile.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import osvaldo.app.news.mobile.NewsApplication
import osvaldo.app.news.mobile.domain.model.News
import osvaldo.app.news.mobile.domain.repository.NewsRepository
import retrofit2.HttpException

class NewsViewModel(
    private val repository: NewsRepository
) : ViewModel() {

    private val _state = MutableStateFlow(UiState())
    val uiState = _state.asStateFlow()

    init {
        getNews(search = "alien")
    }

    fun onEvent(event: NewsEvent) {
        when(event) {
            is NewsEvent.OnNewsDetail -> onNewsDetail(event.news)
            is NewsEvent.OnChangeSearch -> onChangeSearch(event.search)
            NewsEvent.SearchNews -> getNews(_state.value.search)
            NewsEvent.OnFilterActivated -> onFilterActivated()
        }
    }

    private fun onFilterActivated() {
        _state.update { it.copy(isFilterActivated = !it.isFilterActivated) }
    }

    private fun onChangeSearch(search: String) {
        _state.update { it.copy(search = search) }
    }

    private fun onNewsDetail(news: News?) {
        _state.update { it.copy(newsDetail = news) }
    }

    private fun getNews(search: String) {
        viewModelScope.launch {
            _state.update { it.copy(newsState = NewsState.Loading) }
            try {
                val news = repository.getEverything(search)
                _state.update { it.copy(newsState = NewsState.Success(news)) }
            } catch (e: Exception) {
                e.printStackTrace()
                _state.update { it.copy(newsState = NewsState.Error) }
            } catch (e: HttpException) {
                e.printStackTrace()
                _state.update { it.copy(newsState = NewsState.Error) }
            }
        }
    }

    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = (this[APPLICATION_KEY] as NewsApplication)
                NewsViewModel(repository = application.container.newsRepository)
            }
        }
    }
}