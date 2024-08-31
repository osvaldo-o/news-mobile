package osvaldo.app.news.mobile.di

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import osvaldo.app.news.mobile.data.datasource.remote.NewsService
import retrofit2.Retrofit

class AppContainerImpl : AppContainer {

    private val baseUrl = "https://newsapi.org/v2/"

    private val retrofit = Retrofit.Builder()
        .addConverterFactory(Json { ignoreUnknownKeys = true }.asConverterFactory("application/json".toMediaType()))
        .baseUrl(baseUrl)
        .build()

    private val retrofiService: NewsService by lazy {
        retrofit.create(NewsService::class.java)
    }

}