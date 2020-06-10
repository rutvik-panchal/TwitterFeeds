package com.rutvik.apps.twitterfeeds

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.rutvik.apps.twitterfeeds.api.ApiClient
import com.rutvik.apps.twitterfeeds.api.Tweet
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        getTweetss()
    }

    private fun getTweetss() {
        val callback = object : Callback<Tweet> {
            override fun onFailure(call: Call<Tweet>?, t:Throwable?) {
                Log.e("MainActivity", call.toString())
                Log.e("MainActivity", "Problem calling API {${t?.message}}")
            }

            override fun onResponse(call: Call<Tweet>?, response: Response<Tweet>?) {
                response?.isSuccessful.let {
                    Log.d("Main",response.toString())
                }
            }}
        ApiClient.retreiveTweets(callback)
    }
}
