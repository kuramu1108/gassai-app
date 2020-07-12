package com.pocraft.gassai.db

import androidx.room.TypeConverter
import java.time.Instant
import java.time.LocalDateTime
import java.time.ZoneId

object Converter {
    @TypeConverter
    @JvmStatic
    fun tsToDate(value: Long?): LocalDateTime? =
        value?.let {
            LocalDateTime.ofInstant(
                Instant.ofEpochMilli(
                    value
                ),
                ZoneId.systemDefault()
            )
        }

    @TypeConverter
    @JvmStatic
    fun dateToTs(date: LocalDateTime?): Long? = date?.atZone(ZoneId.systemDefault())?.toInstant()?.toEpochMilli()
}