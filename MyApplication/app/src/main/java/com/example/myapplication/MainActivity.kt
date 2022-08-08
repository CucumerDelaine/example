package com.example.myapplication

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.ui.AppBarConfiguration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.databinding.ActivityMainBinding
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
//        recyclerView.layoutManager = GridLayoutManager(this, 2)
        recyclerView.layoutManager = LinearLayoutManager(this)
        RetrofitClientInstance.loadData(recyclerView)
    }
}


object RetrofitClientInstance {

    private var retrofit: Retrofit? = null
    private const val BASE_URL = "https://rickandmortyapi.com/api/"

    private fun getHttpLoggingInterceptor(): HttpLoggingInterceptor? {
        val httpLoggingInterceptor = HttpLoggingInterceptor()
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
        return httpLoggingInterceptor
    }

    private fun getOkHttpCleint(httpLoggingInterceptor: HttpLoggingInterceptor?): OkHttpClient? {
        return httpLoggingInterceptor?.let {
            OkHttpClient.Builder()
                .addInterceptor(it)
                .build()
        }
    }
    private val retrofitInstance: Retrofit?
        get() {
            if (retrofit == null) {
                retrofit = Retrofit
                    .Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(getOkHttpCleint(getHttpLoggingInterceptor())!!)
                    .build()
            }

            return retrofit
        }

    private val TAG = this.javaClass.simpleName
    var service: GetPage? = null

    init {
        service = RetrofitClientInstance.retrofitInstance?.create(GetPage::class.java)
    }

    fun loadData(recyclerView: RecyclerView) {
        val call = service?.getPage()
        loadDataAsync(call, recyclerView)
    }

    private fun loadDataAsync(call: Call<DataApi>?, recyclerView: RecyclerView) {
        call?.enqueue(object : Callback<DataApi> {

            override fun onResponse(call: Call<DataApi>, response: Response<DataApi>) {
                recyclerView.adapter = MyItemRecyclerViewAdapter2(response.body()?.results)
            }

            override fun onFailure(call: Call<DataApi>, t: Throwable) {
                Log.e(TAG, t.printStackTrace().toString())
            }
        })
    }
}



