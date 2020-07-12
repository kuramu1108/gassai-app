package com.pocraft.gassai.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDateTime

@Entity(tableName = "session")
data class Session(
    @PrimaryKey val sessionId: Int,
    val teamPerformingId: Int,
    val venueAtId: Int,
    val day: Int,
    val time: LocalDateTime
)