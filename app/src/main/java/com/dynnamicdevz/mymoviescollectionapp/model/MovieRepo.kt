package com.dynnamicdevz.mymoviescollectionapp.model

import com.dynnamicdevz.mymoviescollectionapp.model.data.FavoritesCache
import com.dynnamicdevz.mymoviescollectionapp.model.data.MovieCache
import com.dynnamicdevz.mymoviescollectionapp.model.data.MoviesResponse
import com.dynnamicdevz.mymoviescollectionapp.model.network.MoviesRetrofit
import retrofit2.Call
import com.dynnamicdevz.mymoviescollectionapp.model.db.MovieDatabase.Companion.getDao
import com.dynnamicdevz.mymoviescollectionapp.util.Constants.Companion.CACHE_KEY
import com.google.gson.Gson

class MovieRepo {
//    private val moviesRetrofit = MoviesRetrofit()
//
//    fun readFromRemoteSource(): Call<MoviesResponse> = moviesRetrofit.getMovies()
//
//    //Reading from cache
//    fun readFromCache(): MoviesResponse {
//        val cache = getDao().readFromCache()
//        val data = Gson().fromJson(cache.data, MoviesResponse::class.java)
//        return data
//    }
//
//    fun saveToCache(response: MoviesResponse){
//        val gson = Gson()
//        val json = gson.toJson(response)
//        getDao().cacheData(MovieCache(CACHE_KEY, json))
//    }
//
//    fun insertNewFavorites(favoritesCache: FavoritesCache){
//        getDao().insertNewFavorites(favoritesCache)
//    }

}