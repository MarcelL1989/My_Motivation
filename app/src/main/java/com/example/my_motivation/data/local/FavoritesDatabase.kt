package com.example.my_motivation.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.my_motivation.data.model.Detailcard

@Database(entities = [Detailcard::class], version = 1)
abstract class FavoritesDatabase : RoomDatabase() {

    abstract val favorites: DatabaseDAO
}


private lateinit var INSTANCE: FavoritesDatabase

// if there's no Database a new one is built
fun getDatabase(context: Context): FavoritesDatabase {
    synchronized(FavoritesDatabase::class.java) {
        if (!::INSTANCE.isInitialized) {
            INSTANCE = Room.databaseBuilder(
                context.applicationContext,
                FavoritesDatabase::class.java,
                "favorites"
            )
                .build()
        }
    }
    return INSTANCE
}
