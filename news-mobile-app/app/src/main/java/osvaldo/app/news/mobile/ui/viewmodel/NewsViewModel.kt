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
import osvaldo.app.news.mobile.domain.repository.NewsRepository
import retrofit2.HttpException

class NewsViewModel(
    private val repository: NewsRepository
) : ViewModel() {

    private val _state = MutableStateFlow(UiState())
    val uiState = _state.asStateFlow()

    init {
        getNews(search = "Star wars")
    }

    private fun getNews(search: String) {
        viewModelScope.launch {
            _state.update { it.copy(news = NewsState.Loading) }
            try {
                val news = repository.getEverything(search)
                _state.update { it.copy(news = NewsState.Success(news)) }
            } catch (e: Exception) {
                _state.update { it.copy(news = NewsState.Error) }
            } catch (e: HttpException) {
                _state.update { it.copy(news = NewsState.Error) }
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