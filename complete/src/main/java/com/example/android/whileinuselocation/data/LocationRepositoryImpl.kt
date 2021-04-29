package com.example.android.whileinuselocation.data

import com.example.android.whileinuselocation.data.db.LocationDao

class LocationRepositoryImpl(private val locationDao: LocationDao) : LocationRepository {

  override suspend fun getLocations() =
      locationDao.getLocations()
}
