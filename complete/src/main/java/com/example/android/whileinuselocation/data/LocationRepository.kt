package com.example.android.whileinuselocation.data

import kotlinx.coroutines.flow.Flow

interface LocationRepository {

  suspend fun getLocations(): Flow<List<com.example.android.whileinuselocation.model.Location>>
}
