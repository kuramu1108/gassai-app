package com.pocraft.gassai.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.pocraft.gassai.model.Session
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
}