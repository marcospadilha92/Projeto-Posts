package com.example.listaeventos.model

import com.example.listaeventos.dto.PostList
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory

object ApiClient {
    private val BASE_URL = "http://jsonplaceholder.typicode.com"

    private val api = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .build()
        .create(ApiInterface::class.java)

    //fun <PostList> Sequence<PostList>.toList() : List<PostList>
    fun getPosts() : Call<List<PostList>> { return api.getPosts()}
}