package Interfaces

import ResponseSamples.News
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import retrofit2.http.GET
import retrofit2.http.Query

//https://newsapi.org/v2/top-headlines?country=us&category=business&apiKey=API_KEY
//https://newsapi.org/v2/everything?q=tesla&from=2023-06-05&sortBy=publishedAt&apiKey=API_KEY

const val BASE_URL = "https://newsapi.org/"
const val API_KEY = "5c4893346937452a822ee1289368f9b6"

interface NewsInterface {
    @GET("v2/top-headlines?apiKey=$API_KEY")
    fun getHeadlines(@Query("country") country: String, @Query("page") page: Int): Call<News>
}

object NewsService {
    val newsInterface: NewsInterface

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        newsInterface = retrofit.create(NewsInterface::class.java)
    }
}