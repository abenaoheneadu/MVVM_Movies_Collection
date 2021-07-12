package com.dynnamicdevz.mymoviescollectionapp.model.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "movie_cache")
data class MovieCache(
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "cache_id")
    val cacheID: Int,

    @ColumnInfo(name = "data")
    val data: String
)
