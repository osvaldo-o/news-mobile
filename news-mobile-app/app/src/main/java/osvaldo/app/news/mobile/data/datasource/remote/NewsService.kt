package osvaldo.app.news.mobile.data.datasource.remote

import osvaldo.app.news.mobile.BuildConfig
import osvaldo.app.news.mobile.data.datasource.remote.model.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsService {

    @GET("everything")
    suspend fun getEverything(
        @Query("q") search: String,
        @Query("pageSize") pageSize: Int = 30,
        @Query("language") language: String,
        @Query("sortBy") sortBy: String = "publishedAt",
        @Query("apiKey") apiKey: String = BuildConfig.API_KEY
    ): Response

}