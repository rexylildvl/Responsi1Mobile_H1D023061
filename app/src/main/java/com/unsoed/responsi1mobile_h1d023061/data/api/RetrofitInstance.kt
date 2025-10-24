package com.unsoed.responsi1mobile_h1d023061.data.api

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    private const val BASE_URL = "https://api.football-data.org/v4/"
    private const val API_KEY = "485cb0fb9ed3494e9c88ec71017b1371"

    private val client = OkHttpClient.Builder()
        .addInterceptor { chain ->
            val request = chain.request().newBuilder()
                .addHeader("X-Auth-Token", API_KEY)
                .build()
            chain.proceed(request)
        }
        .build()

    val api: FootballApiService by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
            .create(FootballApiService::class.java)
    }
}
