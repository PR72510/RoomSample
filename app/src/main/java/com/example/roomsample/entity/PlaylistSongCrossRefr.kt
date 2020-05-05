package com.example.roomsample.entity

import androidx.room.Entity

/**
 * Created by PR72510 on 5/5/20.
 */

@Entity(primaryKeys = ["playlistId", "songId"])
class PlaylistSongCrossRefr(
    val playlistId: Long,
    val songId: Long
)