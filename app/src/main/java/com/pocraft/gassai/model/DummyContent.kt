package com.pocraft.gassai.model

import java.time.LocalDateTime

val dummySchedule = arrayOf("Day 1", "Day 2", "Saved")

val venue1 = Venue(0, "銀座")
val venue2 = Venue(1, "上通り")
val venue3 = Venue(2, "下通り")
val venue4 = Venue(3, "二の丸")
val dummyVenueList = listOf(venue1, venue2, venue3, venue4)

val now = LocalDateTime.now()

val session1 = Session(0, 1, 0, 1, now)
val session2 = Session(1, 2, 1, 1, now)
val session3 = Session(2, 1, 2, 1, now)
val session4 = Session(3, 1, 3, 2, now)
val session5 = Session(4, 2, 0, 2, now)
val session6 = Session(5, 1, 1, 2, now)
val session7 = Session(6, 1, 2, 1, now)
val session8 = Session(7, 2, 3, 1, now)
val session9 = Session(8, 1, 0, 1, now)
val session10 = Session(9, 1, 1, 2, now)
val session11 = Session(10, 1, 2, 2, now)
val session12 = Session(11, 2, 3, 1, now)
val session13 = Session(12, 1, 1, 1, now)
val dummySessionDay1 = listOf(session1, session2, session3, session4, session5, session6, session7, session8, session9,
    session10, session11, session12, session13)