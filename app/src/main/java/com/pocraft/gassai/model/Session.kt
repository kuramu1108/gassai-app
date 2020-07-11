package com.pocraft.gassai.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDate

@Entity(tableName = "session")
data class Session(
    @PrimaryKey val id: Int,
    val team: Team,
    val venue: Venue,
    val day: Int,
    val time: LocalDate
)