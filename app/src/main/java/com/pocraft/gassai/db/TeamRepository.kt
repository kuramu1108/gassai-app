package com.pocraft.gassai.db

import com.pocraft.gassai.db.dao.TeamDao
import com.pocraft.gassai.model.Team
import javax.inject.Inject

class TeamRepository @Inject constructor(private val teamDao: TeamDao) {
    fun teams() = teamDao.allTeamsFlow()

    suspend fun save(teams: List<Team>) {
        teamDao.insert(teams)
    }

    suspend fun isEmpty() = teamDao.rowCount() == 0
}