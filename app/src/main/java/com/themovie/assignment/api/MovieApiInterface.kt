package com.themovie.assignment.api

import com.themovie.assignment.model.Movie
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieApiInterface{
    @GET("everything")
    fun getEverything(
        @Query("q") keyword: String,
        @Query("apikey") apiKey: String
    ): Call<Movie>

}