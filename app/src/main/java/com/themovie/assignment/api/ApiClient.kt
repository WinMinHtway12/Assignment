package com.themovie.assignment.api

import com.themovie.assignment.model.Movie
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiClient {

    private val BASE_URL = "https://api.themoviedb.org/3/movie/"

    private val apiInterface: MovieApiInterface

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        apiInterface = retrofit.create(
            MovieApiInterface::class.java
        )
    }

//    fun getallmovie(): Call<Movie> {
//        return apiInterface.getallmovie();
//    }
//    fun getDetail(id: String): Call<Movie> {
//        return apiInterface.getDetails(id)
//    }
    fun getEverything(keyword:String):Call<Movie>{

        return apiInterface.getEverything("871dd789ec4e60ab37f454f22ceff629")
    }
}