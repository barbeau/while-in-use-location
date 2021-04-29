package com.example.android.whileinuselocation.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import com.example.android.whileinuselocation.toLocation
import kotlinx.coroutines.flow.Flow

@Dao
interface LocationDao {

  @Transaction
  suspend fun updateLocation(location: android.location.Location) {
    location.toLocation()?.let {
      deleteLocations()
      insertLocation(it)
    }
  }

  @Insert
  suspend fun insertLocation(location: com.example.android.whileinuselocation.model.Location)

  @Query("DELETE FROM location_table")
  suspend fun deleteLocations()

  @Query("SELECT * FROM location_table")
  suspend fun getLocations(): Flow<List<com.example.android.whileinuselocation.model.Location>>
}
