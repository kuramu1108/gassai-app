package com.pocraft.gassai.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "team")
data class Team (
    @PrimaryKey val teamId: Int,
    val name: String,
    val prefecture: String,
    val region: String,
    val festival: String,
    val participation: Int,
    val description: String
)