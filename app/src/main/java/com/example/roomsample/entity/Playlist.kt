package com.example.roomsample.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Created by PR72510 on 5/5/20.
 */

@Entity
data class Playlist(
    @PrimaryKey val playlistId: Long,
    val userCreatorId: Long,
    val playlistName: String
)