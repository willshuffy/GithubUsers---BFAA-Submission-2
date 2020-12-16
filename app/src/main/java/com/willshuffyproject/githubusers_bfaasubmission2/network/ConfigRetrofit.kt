package com.willshuffyproject.githubusers_bfaasubmission2.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ConfigRetrofit {

    var retrofit = Retrofit.Builder()
        .baseUrl("https://api.github.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    var service = retrofit.create<ConfigApi>(ConfigApi::class.java)
}