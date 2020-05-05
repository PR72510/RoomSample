package com.example.roomsample.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.roomsample.UserDatabase
import com.example.roomsample.entity.Library
import com.example.roomsample.entity.Playlist
import com.example.roomsample.entity.Song
import com.example.roomsample.entity.User
import com.example.roomsample.repository.UserRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

/**
 * Created by PR72510 on 5/5/20.
 */

class UserViewModel(application: Application) : AndroidViewModel(application) {
    private val repository: UserRepository

    init {
        val userDao = UserDatabase.getDatabase(application, viewModelScope).userDao()
        val songDao = UserDatabase.getDatabase(application, viewModelScope).songDao()
        val playlistDao = UserDatabase.getDatabase(application, viewModelScope).playlistDao()
        val libraryDao = UserDatabase.getDatabase(application, viewModelScope).libraryDao()
        repository = UserRepository(userDao, songDao, playlistDao, libraryDao)
    }

    fun insertUser(user: User) = viewModelScope.launch(Dispatchers.IO) {
        repository.insertUser(user)
    }

    fun insertSong(song: Song) = viewModelScope.launch(Dispatchers.IO) {
        repository.insertSong(song)
    }

    fun insertPlaylist(playlist: Playlist) = viewModelScope.launch(Dispatchers.IO) {
        repository.insertPlaylist(playlist)
    }

    fun insertLibrary(library: Library) = viewModelScope.launch(Dispatchers.IO) {
        repository.insertLibrary(library)
    }

    fun fetchUserAndLibrary() = viewModelScope.launch(Dispatchers.IO) {
        repository.getUserAndLibraries()
    }

    fun fetchUserAndPlaylists() = viewModelScope.launch(Dispatchers.IO) {
        repository.getUserWithPlaylists()
    }

    fun fetchSongWithPlaylists() = viewModelScope.launch(Dispatchers.IO) {
        repository.getSongWithPlaylists()
    }

    fun fetchPlaylistWithSongs() = viewModelScope.launch(Dispatchers.IO) {
        repository.getPlaylistWithSongs()
    }
}