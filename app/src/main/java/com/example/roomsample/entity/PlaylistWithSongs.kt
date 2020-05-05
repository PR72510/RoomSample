package com.example.roomsample.entity

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation

/**
 * Created by PR72510 on 5/5/20.
 */

data class PlaylistWithSongs(
    @Embedded val playlist: Playlist,
    @Relation(
        parentColumn = "playlistId",
        entityColumn = "songId",
        associateBy = Junction(PlaylistSongCrossRefr::class)
    )
    val song: List<Song>
)