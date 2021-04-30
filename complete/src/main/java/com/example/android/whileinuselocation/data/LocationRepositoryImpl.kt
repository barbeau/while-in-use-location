package com.example.android.whileinuselocation.data

import androidx.annotation.WorkerThread
import com.example.android.whileinuselocation.data.db.LocationDao
import com.example.android.whileinuselocation.model.Location

class LocationRepositoryImpl(private val locationDao: LocationDao) : LocationRepository {

    override suspend fun getLocations() = locationDao.getLocations()

    // By default Room runs suspend queries off the main thread, therefore, we don't need to
    // implement anything else to ensure we're not doing long running database work
    // off the main thread.
    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    override suspend fun insertLocation(location: Location) {
        locationDao.insertLocation(location)
    }
}
