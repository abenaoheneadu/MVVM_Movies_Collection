package com.dynnamicdevz.mymoviescollectionapp.model.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Favorites")
data class FavoritesCache(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "Id")
    val id: Int,
    @ColumnInfo(name = "title")
    val title: String,
    @ColumnInfo(name = "posterPath")
    val poster_path: String,
    @ColumnInfo(name = "overview")
    val overview: String,
    @ColumnInfo(name = "releaseId")
    val release_date: String,
    @ColumnInfo(name = "voteAverage")
    val vote_average: Double
    ) {
    constructor(title: String, poster_path: String,overview: String, release_date: String, vote_average: Double) : this(
        0,
        title,
        poster_path,
        overview,
        release_date,
        vote_average
    )
}