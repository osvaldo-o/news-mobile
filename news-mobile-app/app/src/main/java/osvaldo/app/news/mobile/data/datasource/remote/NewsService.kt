package osvaldo.app.news.mobile.data.datasource.remote

import osvaldo.app.news.mobile.data.datasource.remote.model.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsService {

    @GET("everything")
    suspend fun getEverything(
        @Query("q") search: String,
        @Query("pageSize") pageSize: Int = 30,
        @Query("language") language: String = "es",
        @Query("sortBy") sortBy: String,
    ): Response

}