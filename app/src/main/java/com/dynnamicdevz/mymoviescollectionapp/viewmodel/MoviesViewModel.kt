package com.dynnamicdevz.mymoviescollectionapp.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.dynnamicdevz.mymoviescollectionapp.model.data.MoviesResponse
import com.dynnamicdevz.mymoviescollectionapp.model.data.Result
import com.dynnamicdevz.mymoviescollectionapp.model.network.MoviesRetrofit
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

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

}
