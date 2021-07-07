package com.dynnamicdevz.mymoviescollectionapp.model.network

import com.dynnamicdevz.mymoviescollectionapp.model.data.MoviesResponse
import com.dynnamicdevz.mymoviescollectionapp.util.Constants.*
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers

class MoviesRetrofit {
    private val movieService = createRetrofit().create(MovieService::class.java)
    private fun createRetrofit() = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun getMovies() = movieService.getAllPopularMovies()

    interface MovieService{
        @Headers(API_KEY)
        @GET(END_POINT)
        fun getAllPopularMovies(): Call<MoviesResponse>
    }
}