package com.example.android.whileinuselocation.data.db

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface LocationDao {

  @Transaction
  suspend fun updateLocation(location: com.example.android.whileinuselocation.model.Location) {
    location.let {
      deleteLocations()
      insertLocation(it)
    }
  }

  @Insert(onConflict = OnConflictStrategy.IGNORE)
  suspend fun insertLocation(location: com.example.android.whileinuselocation.model.Location)

  @Query("DELETE FROM location_table")
  suspend fun deleteLocations()

  @Query("SELECT * FROM location_table ORDER BY time")
  fun getLocations(): Flow<List<com.example.android.whileinuselocation.model.Location>>
}
