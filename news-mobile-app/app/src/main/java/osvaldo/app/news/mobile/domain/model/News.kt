package osvaldo.app.news.mobile.domain.model

data class News(
    val nameSource: String,
    val author: String,
    val title: String,
    val description: String,
    val url: String,
    val urlToImage: String,
    val publishedAt: String
)
