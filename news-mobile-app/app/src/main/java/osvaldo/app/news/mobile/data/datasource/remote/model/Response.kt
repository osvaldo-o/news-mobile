package osvaldo.app.news.mobile.data.datasource.remote.model

import kotlinx.serialization.Serializable

@Serializable
data class Response(
    val status: String,
    val article: List<NewsApi>
)
