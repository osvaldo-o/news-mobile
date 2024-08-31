package osvaldo.app.news.mobile.data.datasource.remote.model

import kotlinx.serialization.Serializable

@Serializable
data class NewsApi(
    val source: Source,
    val author: String?,
    val title: String?,
    val description: String?,
    val url: String?,
    val urlToImage: String?,
    val publishedAt: String?
)

@Serializable
data class Source(
    val name: String?
)
