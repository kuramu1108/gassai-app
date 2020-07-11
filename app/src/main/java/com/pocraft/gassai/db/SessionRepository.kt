package com.pocraft.gassai.db

import com.pocraft.gassai.db.dao.SessionDao
import kotlinx.coroutines.flow.map

class SessionRepository constructor(private val sessionDao: SessionDao) {
    fun sessionsFor(day: Int) = sessionDao.allSessionsFlowIn(day)
        .map { sessions ->
            sessions.sortedBy { it.time }
        }
}