package Views

import Interfaces.NewsService
import ResponseSamples.News
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.retrofittest.R
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Retrofit_Sample : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_retrofit_sample)
        getNews()
    }

    private fun getNews() {
        val news = NewsService.newsInterface.getHeadlines("in", 1)
        news.enqueue(object : Callback<News> {
            override fun onResponse(call: Call<News>, response: Response<News>) {
                val news = response.body()
                if (news != null) Toast.makeText(
                    this@Retrofit_Sample,
                    "Total results found = ${news.totalResults}",
                    Toast.LENGTH_LONG
                ).show()
            }

            override fun onFailure(call: Call<News>, t: Throwable) {
                Toast.makeText(this@Retrofit_Sample,t.message,Toast.LENGTH_SHORT).show()
            }
        })
    }

}