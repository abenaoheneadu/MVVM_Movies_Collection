package com.dynnamicdevz.mymoviescollectionapp.model.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.dynnamicdevz.mymoviescollectionapp.model.data.MovieCache
import com.dynnamicdevz.mymoviescollectionapp.util.Constants.Companion.DATABASE_NAME
@Database(version = 1, entities = [MovieCache::class])
abstract class MovieDatabase: RoomDatabase() {
    abstract fun getDAO(): MovieDAO
    companion object{

        private lateinit var movieDatabase: MovieDatabase

        fun initializedDatabase(context: Context){
            movieDatabase = Room.databaseBuilder(
                context,
                MovieDatabase::class.java,
                DATABASE_NAME
            ).build()

        }
        fun getDao() = movieDatabase.getDAO()
    }

}