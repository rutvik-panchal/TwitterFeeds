package com.rutvik.apps.twitterfeeds.api

import com.twitter.sdk.android.core.internal.oauth.OAuth2Token
import retrofit2.Callback
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {

    private const val BASE_URL: String = "https://api.twitter.com/"

    fun getClient(): ApiInterface {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        return retrofit.create(ApiInterface::class.java)
    }

    fun retreiveTweets(callback: Callback<TweetList>, hashtag: String) {
        val call = getClient().getTweets("Bearer AAAAAAAAAAAAAAAAAAAAAMQbFAEAAAAAoMn7Kj2jMd6cA4VTzQxxrTEQsQM%3DTJf0IrPoh4WWtK17cym0jvmj1Idos5hAW3TYuoJC4t6TI86Qiz", "application/json", hashtag)
        call.enqueue(callback)
    }

    fun getToken(callback: Callback<OAuth2Token>) {
        val call = getClient().getToken("Basic bWVnM2VnZ2dzY0x4ZUxDM09vVG5ldjdXVDo5OG5ONmVVQnVXWFFpSVVScDhoMkE0a0szdlFkVzd5SmJiYzNud2ZEdndtWVhVOVJlNg==", "application/json","client_credentials")
        call.enqueue(callback)
    }
}