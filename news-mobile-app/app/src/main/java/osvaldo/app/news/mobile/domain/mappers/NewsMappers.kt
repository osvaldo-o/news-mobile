package osvaldo.app.news.mobile.domain.mappers

import osvaldo.app.news.mobile.data.datasource.remote.model.NewsApi
import osvaldo.app.news.mobile.domain.model.News
import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter

fun List<NewsApi>.toNews() =
    this.map { newsApi ->
        val publishedAt = newsApi.publishedAt?.let {
            val dateTime = ZonedDateTime.parse(it)
            val formatter = DateTimeFormatter.ofPattern("d MMMM yyyy")
            dateTime.format(formatter)
        }
        News(
            nameSource = newsApi.source.name ?: "",
            author = newsApi.author ?: "Sin author",
            title = newsApi.title ?: "Sin titulo",
            description = newsApi.description ?: "Sin descripción",
            url = newsApi.url ?: "",
            urlToImage = newsApi.urlToImage ?: "",
            publishedAt = publishedAt ?: "Sin fecha"
        )
    }