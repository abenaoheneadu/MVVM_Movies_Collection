package com.dynnamicdevz.mymoviescollectionapp.model.network

import com.dynnamicdevz.mymoviescollectionapp.model.data.MoviesResponse
import com.dynnamicdevz.mymoviescollectionapp.util.Constants.*
import com.dynnamicdevz.mymoviescollectionapp.util.Constants.Companion.API_KEY
import com.dynnamicdevz.mymoviescollectionapp.util.Constants.Companion.API_QUERY
import com.dynnamicdevz.mymoviescollectionapp.util.Constants.Companion.BASE_URL
import com.dynnamicdevz.mymoviescollectionapp.util.Constants.Companion.END_POINT
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.Query

class MoviesRetrofit {
    private val movieService = createRetrofit().create(MovieService::class.java)
    private fun createRetrofit() = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun getMovies() = movieService.getAllPopularMovies(API_KEY)

    interface MovieService{
        @GET(END_POINT)
        fun getAllPopularMovies(@Query(API_QUERY) apiKey: String): Call<MoviesResponse>


//        @GET(END_POINT_2)
//        fun getAllPopularMovies2(): Call<MoviesResponse>
    }
}