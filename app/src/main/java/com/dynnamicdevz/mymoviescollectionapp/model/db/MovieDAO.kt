package com.dynnamicdevz.mymoviescollectionapp.model.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.dynnamicdevz.mymoviescollectionapp.model.data.FavoritesCache

@Dao
interface MovieDAO {
//    @Insert(onConflict = REPLACE)
//    fun cacheData(data: MovieCache)
//
//    @Query("SELECT * FROM movie_cache WHERE cache_id = $CACHE_KEY")
//    fun readFromCache(): MovieCache

    @Insert
    fun insertNewFavorites(vararg favoritesCache: FavoritesCache)

    @Query("SELECT * FROM favorites")
    fun getAllFavorites(): List<FavoritesCache>

    @Delete
    fun deleteFavorites(vararg favoritesCache: FavoritesCache)
}