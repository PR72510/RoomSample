package com.example.roomsample.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Created by PR72510 on 5/5/20.
 */

@Entity
data class Song(
    @PrimaryKey val songId: Long,
    val songName: String,
    val artist: String
)