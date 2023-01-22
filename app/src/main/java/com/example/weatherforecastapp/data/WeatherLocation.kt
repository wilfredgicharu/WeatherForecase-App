package com.example.weatherforecastapp.data

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import java.time.Instant
import java.time.ZoneId
import java.time.ZonedDateTime

const val WEATHER_LOCATION_ID = 0
@Entity(tableName = "current_weather")
data class WeatherLocation(
    val name: String,
    val region: String,
    val country: String,
    val lat: Double,
    val lon: Double,
    @SerializedName("tz_id")
    val tzId: String,
    @SerializedName("localtime_epoch")
    val localtimeEpoch: Long
){
    @PrimaryKey(autoGenerate = false)
    var id: Int = WEATHER_LOCATION_ID

    val zonedDateTime: ZonedDateTime
    @RequiresApi(Build.VERSION_CODES.O)
    get(){
        val instant = Instant.ofEpochSecond(localtimeEpoch)
        val zoneId = ZoneId.of(tzId)
        return ZonedDateTime.ofInstant(instant, zoneId)
    }

}


