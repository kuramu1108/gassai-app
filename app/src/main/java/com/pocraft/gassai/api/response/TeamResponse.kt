package com.pocraft.gassai.api.response

import com.pocraft.gassai.model.Team
import kotlinx.serialization.Serializable

@Serializable
data class TeamResponse(
    val teamId: Int,
    val name: String,
    val prefecture: String,
    val region: String,
    val festival: String,
    val participation: Int,
    val description: String,
    val imgUrl: String
) {
    fun toEntity(): Team =
        Team(
            teamId, name, prefecture, region, festival, participation, description, imgUrl
        )
}
