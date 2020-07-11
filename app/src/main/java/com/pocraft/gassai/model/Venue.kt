package com.pocraft.gassai.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "venue")
data class Venue (
    @PrimaryKey val id: Int,
    val name: String
)