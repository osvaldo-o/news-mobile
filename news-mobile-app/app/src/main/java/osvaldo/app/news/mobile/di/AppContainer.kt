package osvaldo.app.news.mobile.di

import osvaldo.app.news.mobile.domain.repository.NewsRepository

interface AppContainer {
    val newsRepository: NewsRepository
}