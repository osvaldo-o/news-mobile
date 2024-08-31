package osvaldo.app.news.mobile.domain.mappers

import osvaldo.app.news.mobile.data.datasource.remote.model.NewsApi
import osvaldo.app.news.mobile.domain.model.News

fun List<NewsApi>.toNews() =
    this.map { newsApi ->
        News(
            nameSource = newsApi.source.name ?: "",
            author = newsApi.author ?: "Sin author",
            title = newsApi.title ?: "Sin titulo",
            description = newsApi.description ?: "Sin descripción",
            url = newsApi.url ?: "",
            urlToImage = newsApi.urlToImage ?: "",
            publishedAt = newsApi.publishedAt ?: "Sin fecha"
        )
    }