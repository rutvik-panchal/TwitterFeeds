package com.rutvik.apps.twitterfeeds.api

import okhttp3.OkHttpClient
import retrofit2.Callback
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {

    var BASE_URL: String = "https://api.twitter.com/1.1/"

    var httpClient = OkHttpClient.Builder().addInterceptor{ chain ->
        val original = chain.request()
        val request = original.newBuilder()
            .header("authorization", "Bearer AAAAAAAAAAAAAAAAAAAAAMQbFAEAAAAAoMn7Kj2jMd6cA4VTzQxxrTEQsQM%3DTJf0IrPoh4WWtK17cym0jvmj1Idos5hAW3TYuoJC4t6TI86Qiz")
            .header("content-type", "application/json")
            .method(original.method(), original.body())
            .build()
        chain.proceed(request)
    }

    var client = httpClient.build();

    fun getClient(): ApiInterface {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
        return retrofit.create(ApiInterface::class.java)
    }

    fun retreiveTweets(callback: Callback<Tweet>) {
        val call = getClient().getTweets()
        call.enqueue(callback)
    }}