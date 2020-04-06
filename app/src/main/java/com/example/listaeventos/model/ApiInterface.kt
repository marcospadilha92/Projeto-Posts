package com.example.listaeventos.model

import com.example.listaeventos.viewmodel.DescriptionList
import com.example.listaeventos.viewmodel.PostList
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {
    @GET("/posts")
    fun getPosts(): Call<List<PostList>>

    @GET("/users")
    fun getDescription(@Query("users") user: Int): Call<List<DescriptionList>>
}