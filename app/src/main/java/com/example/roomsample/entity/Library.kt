package com.example.roomsample.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Created by PR72510 on 5/5/20.
 */

@Entity
data class Library(
    @PrimaryKey val libraryId: Long,
    val userOwnerId: Long
)