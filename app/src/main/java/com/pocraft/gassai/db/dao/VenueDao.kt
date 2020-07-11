package com.pocraft.gassai.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.pocraft.gassai.model.Venue
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.asFlow

@Dao
interface VenueDao {
    @Query("SELECT * FROM venue")
    fun allVenues(): List<Venue>

    @Query("SELECT * FROM venue")
    fun allVenuesFlow(): Flow<List<Venue>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(venues: List<Venue>)
}