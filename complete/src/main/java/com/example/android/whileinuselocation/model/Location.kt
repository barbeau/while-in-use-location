package com.example.android.whileinuselocation.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "location_table")
data class Location(
    @PrimaryKey val elapsedRealtimeNanos: Long,
    val latitude: Double,
    val longitude: Double
)