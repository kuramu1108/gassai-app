package com.pocraft.gassai.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.pocraft.gassai.db.dao.PostDao
import com.pocraft.gassai.db.dao.SessionDao
import com.pocraft.gassai.db.dao.TeamDao
import com.pocraft.gassai.db.dao.VenueDao
import com.pocraft.gassai.model.Post
import com.pocraft.gassai.model.Session
import com.pocraft.gassai.model.Team
import com.pocraft.gassai.model.Venue

@Database(
    entities = [
        Post::class,
        Session::class,
        Team::class,
        Venue::class
    ],
    version = 2,
    exportSchema = false
)
@TypeConverters(Converter::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun postDao(): PostDao
    abstract fun sessionDao(): SessionDao
    abstract fun teamDao(): TeamDao
    abstract fun venueDao(): VenueDao
}