package com.themovie.assignment.api

import com.themovie.assignment.model.Movie
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieApiInterface{

    @GET("popular")
    fun getEverything(
        @Query("api_key") apiKey: String
    ): Call<Movie>

    @GET("now_playing")
    fun getNowplaying(
        @Query("api_key") apiKey: String
    ): Call<Movie>

    @GET("top_rated")
    fun getToprated(
        @Query("api_key") apiKey: String
    ): Call<Movie>

    @GET("upcoming")
    fun getUpcoming(
        @Query("api_key") apiKey: String
    ): Call<Movie>

}