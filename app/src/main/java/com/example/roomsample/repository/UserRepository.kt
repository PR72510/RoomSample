package com.example.roomsample.repository

import android.util.Log
import com.example.roomsample.dao.LibraryDao
import com.example.roomsample.dao.PlaylistDao
import com.example.roomsample.dao.SongDao
import com.example.roomsample.dao.UserDao
import com.example.roomsample.entity.*

/**
 * Created by PR72510 on 5/5/20.
 */
class UserRepository(
    private val userDao: UserDao,
    private val songDao: SongDao,
    private val playlistDao: PlaylistDao,
    private val libraryDao: LibraryDao
) {

    suspend fun insertUser(user: User) {
        userDao.insertUser(user)
    }

    suspend fun insertSong(song: Song) {
        songDao.insertSong(song)
    }

    suspend fun insertPlaylist(playlist: Playlist) {
        playlistDao.insertPlaylist(playlist)
    }

    suspend fun insertLibrary(library: Library) {
        libraryDao.insertLibrary(library)
    }

    suspend fun getUserAndLibraries(): List<UserAndLibrary> {
        val userAndLib = userDao.getUserAndLibraries()
        Log.i("MyTag", userAndLib.toString())
        return userAndLib
    }

    suspend fun getUserWithPlaylists(): List<UserWithPlaylists> {
        val userAndPlaylists = userDao.getUsersWithPlaylists()
        Log.i("MyTag", userAndPlaylists.toString())
        return userAndPlaylists
    }

    suspend fun getSongWithPlaylists(): List<SongWithPlaylists> {
        val songWithPlaylists = songDao.getSongsWithPlaylists()
        Log.i("MyTag", songWithPlaylists.toString())
        return songWithPlaylists
    }

    suspend fun getPlaylistWithSongs(): List<PlaylistWithSongs>{
        val playlistWithSongs = playlistDao.getPlaylistsWithSongs()
        Log.i("MyTag", playlistWithSongs.toString())
        return playlistWithSongs
    }
}