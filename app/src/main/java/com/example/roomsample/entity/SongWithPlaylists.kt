package com.example.roomsample.entity

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation

/**
 * Created by PR72510 on 5/5/20.
 */
data class SongWithPlaylists(
    @Embedded val song: Song,
    @Relation(
        parentColumn = "songId",
        entityColumn = "playlistId",
        associateBy = Junction(PlaylistSongCrossRefr::class)
    )
    val playlist: List<Playlist>
)