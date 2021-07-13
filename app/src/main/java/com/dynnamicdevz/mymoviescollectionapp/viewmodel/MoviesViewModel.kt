package com.dynnamicdevz.mymoviescollectionapp.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.dynnamicdevz.mymoviescollectionapp.model.MovieRepo
import com.dynnamicdevz.mymoviescollectionapp.model.data.FavoritesCache
import com.dynnamicdevz.mymoviescollectionapp.model.data.MovieCache
import com.dynnamicdevz.mymoviescollectionapp.model.data.MoviesResponse
import com.dynnamicdevz.mymoviescollectionapp.model.data.Result
import com.dynnamicdevz.mymoviescollectionapp.model.db.MovieDatabase
import com.dynnamicdevz.mymoviescollectionapp.model.network.MoviesRetrofit
import com.dynnamicdevz.mymoviescollectionapp.view.adapter.MoviesAdapter
import com.google.gson.Gson
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.lang.Exception

class MoviesViewModel: ViewModel() {
    private val moviesRetrofit = MoviesRetrofit()

    //val liveData = MutableLiveData<Int>()

    val moviesLiveData = MutableLiveData<List<Result>>()

    fun getAllPopularMovies() {
        moviesRetrofit.getMovies().enqueue(object: Callback<MoviesResponse> {
            override fun onResponse(call: Call<MoviesResponse>, response: Response<MoviesResponse>) {
                response.body()?.let {
                    moviesLiveData.postValue(it.results)
                } ?: Log.d("TAG_X", "The response was null ${call.request().url()}")
            }

            override fun onFailure(call: Call<MoviesResponse>, t: Throwable) {
                Log.d("TAG_X", t.localizedMessage)
            }
        })
    }

    fun insertFavorites(vararg favoritesCache: FavoritesCache, adapter: MoviesAdapter){
        Thread {
             fun run() {
            try {
                MovieDatabase.getDao().insertNewFavorites(*favoritesCache)
                adapter.listDBResults =  readFromFavorites()
            }catch(e: Exception){
                Log.d(
                    "TAG_X", e.localizedMessage
                )
            }
        }
        }.start()
    }
    fun readFromFavorites(): List<FavoritesCache>{
        var returnList : List<FavoritesCache> = emptyList()
        Thread{
            fun run(){
                try {
                    returnList =  MovieDatabase.getDao().getAllFavorites()
                }catch(e: Exception){
                    Log.d("TAG_X", e.localizedMessage)
                }
            }
        }.start()
        return returnList
    }
    fun deleteFromDB(vararg favoritesCache: FavoritesCache, adapter: MoviesAdapter){

        Thread{
            fun run(){
                try {
                    MovieDatabase.getDao().deleteFavorites(*favoritesCache)
                    adapter.listDBResults = readFromFavorites()
                }catch(e: Exception){
                    Log.d("TAG_X", e.localizedMessage)
                }
            }
        }.start()
    }


//    fun addToFavorites(it: Result) {
//
//        val data = Gson().toJson(it)
//        MovieRepo().readFromCache().cacheData(MovieCache(1, data))
//    }

//    fun getFavorites(){
//        //
//        Thread(){
//
//            val list = Gson(MovieRepo().readFromCache().readFromCache(), Movi)
//
//
//        }.start()
//
//    }


}
