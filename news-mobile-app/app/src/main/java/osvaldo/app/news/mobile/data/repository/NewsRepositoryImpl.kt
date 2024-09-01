package osvaldo.app.news.mobile.data.repository

import osvaldo.app.news.mobile.data.datasource.remote.NewsService
import osvaldo.app.news.mobile.domain.mappers.toNews
import osvaldo.app.news.mobile.domain.model.News
import osvaldo.app.news.mobile.domain.repository.NewsRepository

class NewsRepositoryImpl(private val newsService: NewsService) : NewsRepository {
    override suspend fun getEverything(search: String): List<News> =
        newsService.getEverything(search = search).articles.toNews()
}