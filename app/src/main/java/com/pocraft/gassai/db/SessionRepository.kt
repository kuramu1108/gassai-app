package com.pocraft.gassai.db

import com.pocraft.gassai.db.dao.SessionDao
import com.pocraft.gassai.model.Session
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class SessionRepository @Inject constructor(private val sessionDao: SessionDao) {
    fun sessionsFor(day: Int) = sessionDao.allSessionsFlowIn(day)
        .map { sessions ->
            sessions.sortedBy { it.time }
        }

    fun sessionsWithTeam() = sessionDao.allSessionsWithTeam()

    suspend fun save(data: List<Session>) {
        sessionDao.insert(data)
    }

    suspend fun isEmpty() = sessionDao.rowCount() == 0

    suspend fun toggleFavorite(session: Session) = with(Dispatchers.IO) {
        session.isFavorite = !session.isFavorite
        sessionDao.update(session)
    }
}