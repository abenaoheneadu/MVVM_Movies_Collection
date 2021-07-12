package com.dynnamicdevz.mymoviescollectionapp.model

import com.dynnamicdevz.mymoviescollectionapp.model.data.MoviesResponse
import com.dynnamicdevz.mymoviescollectionapp.model.network.MoviesRetrofit
import retrofit2.Call
import com.dynnamicdevz.mymoviescollectionapp.model.db.MovieDatabase.Companion.getDao

class MovieRepo {
    private val moviesRetrofit = MoviesRetrofit()

    fun readFromRemoteSource(): Call<MoviesResponse> = moviesRetrofit.getMovies()

   fun readFromCache() = getDao()
}