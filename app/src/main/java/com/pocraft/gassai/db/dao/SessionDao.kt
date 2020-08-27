package com.pocraft.gassai.db.dao

import androidx.room.*
import com.pocraft.gassai.model.Session
import com.pocraft.gassai.model.SessionWithTeam
import kotlinx.coroutines.flow.Flow

@Dao
interface SessionDao {
    @Query("SELECT * FROM session")
    fun allSessions(): List<Session>

    @Query("SELECT * FROM session WHERE day = :day")
    fun allSessionsIn(day: Int): List<Session>

    @Query("SELECT * FROM session WHERE day = :day")
    fun allSessionsFlowIn(day: Int): Flow<List<Session>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(sessions: List<Session>)

    @Transaction
    @Query("SELECT * FROM session")
    fun allSessionsWithTeam(): Flow<List<SessionWithTeam>>

    @Query("SELECT COUNT(sessionId) FROM session")
    suspend fun rowCount(): Int

    @Update
    suspend fun update(session: Session)
}