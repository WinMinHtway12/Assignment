package com.themovie.assignment.ui.popular

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.themovie.assignment.api.ApiClient
import com.themovie.assignment.model.Movie
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PopularViewModel : ViewModel() {

    private var movie: MutableLiveData<Movie> = MutableLiveData()

    fun getPopular(): MutableLiveData<Movie> = movie

    fun loadmovie() {

        val apiClient = ApiClient()


        val apiCall = apiClient.getPopular()

        apiCall.enqueue(object : Callback<Movie> {
            override fun onFailure(call: Call<Movie>, t: Throwable) {
                Log.d("Error>>>",t.toString())
            }

            override fun onResponse(call: Call<Movie>, response: Response<Movie>) {
                movie.value = response.body()
                //  Log.d("result",response.body().toString())

            }

        })

    }

}