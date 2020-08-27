package com.pocraft.gassai.db

import com.pocraft.gassai.api.GassaiApi
import com.pocraft.gassai.db.dao.TeamDao
import com.pocraft.gassai.model.Team
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class TeamRepository @Inject constructor(
    private val teamDao: TeamDao,
    private val gassaiApi: GassaiApi
) {
    fun teams() = teamDao.allTeamsFlow()

    suspend fun save(teams: List<Team>) {
        teamDao.insert(teams)
    }

    suspend fun syncRemote() = withContext(Dispatchers.IO) {
        val teams = gassaiApi.getTeams().map {
            it.toEntity()
        }
        teamDao.deleteAll()
        teamDao.insert(teams)
    }

    suspend fun isEmpty() = teamDao.rowCount() == 0
}