package com.pocraft.gassai.model

import androidx.room.Embedded
import androidx.room.Relation

data class TeamWithSessions(
    @Embedded val team: Team,
    @Relation(
        parentColumn = "teamId",
        entityColumn = "teamPerformingId"
    )
    val sessions: List<Session>
)