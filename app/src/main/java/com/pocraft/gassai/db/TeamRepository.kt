package com.pocraft.gassai.db

import com.pocraft.gassai.db.dao.TeamDao

class TeamRepository constructor(private val teamDao: TeamDao) {
    fun teams() = teamDao.allTeamsFlow()
}