package com.io.mvvmclean.data.source.network

import com.io.mvvmclean.data.source.network.entities.MyBlogs
import retrofit2.http.GET

interface NetworkApi {

    @GET("posts")
    suspend fun getBlogsFromNetwork():List<MyBlogs>

}