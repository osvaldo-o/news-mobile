package osvaldo.app.news.mobile.domain.repository

import osvaldo.app.news.mobile.domain.model.News

interface NewsRepository {

    suspend fun getEverything(search: String, language: String, sortBy: String): List<News>

}