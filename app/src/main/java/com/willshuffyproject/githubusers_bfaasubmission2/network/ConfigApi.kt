package com.willshuffyproject.githubusers_bfaasubmission2.network

import com.willshuffyproject.githubusers_bfaasubmission2.model.ResponseUser
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface ConfigApi {

    @GET("/users/{username}")
    @Headers("Authorization: token 71662dd3db1074a0c57a246484c8696245f8bcf2")
    fun  getDataUser(
        @Query("username") username: String) : Call<ResponseUser>
}