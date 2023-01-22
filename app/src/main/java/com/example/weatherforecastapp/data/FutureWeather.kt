package com.example.weatherforecastapp.data

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(tableName = "future_weather", indices = [Index(value = ["date"], unique = true)])
data class FutureWeather(
    @PrimaryKey(autoGenerate = false)
    val id: Int? = null,
    val date: String,
    @Embedded
    val day: Day,

)
