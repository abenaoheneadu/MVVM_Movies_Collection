package com.dynnamicdevz.mymoviescollectionapp.model.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import com.dynnamicdevz.mymoviescollectionapp.model.data.MovieCache
import com.dynnamicdevz.mymoviescollectionapp.util.Constants.Companion.CACHE_KEY

@Dao
interface MovieDAO {
    @Insert(onConflict = REPLACE)
    fun cacheData(data: MovieCache)

    @Query("SELECT * FROM movie_cache WHERE cache_id = $CACHE_KEY")
    fun readFromCache(): MovieCache
}