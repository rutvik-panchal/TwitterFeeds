package com.rutvik.apps.twitterfeeds.api

import com.twitter.sdk.android.core.internal.oauth.OAuth2Token
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.Query

interface ApiInterface {

    @POST("oauth2/token")
    fun getToken( @Header("Authorization") auth: String,
                  @Header("content-type") contentType: String,
                  @Query("grant_type") grant_type: String
    ) : Call<OAuth2Token>

    @GET("1.1/search/tweets.json")
    fun getTweets( @Header("Authorization") authorization: String,
                   @Header("content-type") contentType: String,
                   @Query("q") hashTag: String
    ): Call<TweetList>
}