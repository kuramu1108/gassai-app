package com.pocraft.gassai.model

import androidx.room.Embedded
import androidx.room.Relation

data class SessionWithTeam(
    @Embedded val session: Session,
    @Relation(
        parentColumn = "teamPerformingId",
        entityColumn = "teamId"
    )
    val team: Team
)