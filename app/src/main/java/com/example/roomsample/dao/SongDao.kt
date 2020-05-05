package com.example.roomsample.dao

import androidx.room.*
import com.example.roomsample.entity.Song
import com.example.roomsample.entity.SongWithPlaylists

/**
 * Created by PR72510 on 5/5/20.
 */

@Dao
interface SongDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertSong(song: Song)

    @Transaction
    @Query("SELECT * FROM Song")
    suspend fun getSongsWithPlaylists(): List<SongWithPlaylists>
}