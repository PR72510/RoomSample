package com.example.roomsample.dao

import androidx.room.*
import com.example.roomsample.entity.Playlist
import com.example.roomsample.entity.PlaylistWithSongs

/**
 * Created by PR72510 on 5/5/20.
 */

@Dao
interface PlaylistDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertPlaylist(playlist: Playlist)

    @Transaction
    @Query("SELECT * FROM Playlist")
    suspend fun getPlaylistsWithSongs(): List<PlaylistWithSongs>
}