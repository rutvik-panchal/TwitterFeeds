package com.rutvik.apps.twitterfeeds.api

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers

interface ApiInterface {

    @Headers("authorization: Bearer AAAAAAAAAAAAAAAAAAAAAMQbFAEAAAAAoMn7Kj2jMd6cA4VTzQxxrTEQsQM%3DTJf0IrPoh4WWtK17cym0jvmj1Idos5hAW3TYuoJC4t6TI86Qiz",
    "content-type: application/json")
    @GET("search/tweets.json?q=%23pray&include_entities=true")
    fun getTweets(): Call<Tweet>

}