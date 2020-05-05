package com.example.roomsample.entity

import androidx.room.Embedded
import androidx.room.Relation

/**
 * Created by PR72510 on 5/5/20.
 */

data class UserWithPlaylists(
    @Embedded val user: User,
    @Relation(
        parentColumn = "userId",
        entityColumn = "userCreatorId"
    )
    val playlist: List<Playlist>
)