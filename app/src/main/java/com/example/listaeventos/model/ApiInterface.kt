package com.example.listaeventos.model

import com.example.listaeventos.dto.PostList
import com.example.listaeventos.dto.UserList
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {
    @GET("/posts")
    fun getPosts(): Call<List<PostList>>

//    @GET("/users")
//    fun getUser(@Query int: user): Call<List<UserList>>
}