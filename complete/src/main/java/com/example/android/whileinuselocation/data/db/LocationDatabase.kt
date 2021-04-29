package com.example.android.whileinuselocation.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.android.whileinuselocation.model.Location

private const val DB_NAME = "location_database"

@Database(entities = [(Location::class)], version = 1)
abstract class LocationDatabase : RoomDatabase() {

  abstract fun locationDao(): LocationDao

  companion object {
    fun create(context: Context): LocationDatabase {

      return Room.databaseBuilder(
          context,
          LocationDatabase::class.java,
          DB_NAME
      ).build()
    }
  }
}
