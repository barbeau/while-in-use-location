package com.example.android.whileinuselocation.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "location_table")
data class Location(
    val time: Long,
    val latitude: Double,
    val longitude: Double
){
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}