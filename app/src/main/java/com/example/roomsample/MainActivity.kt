package com.example.roomsample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.roomsample.databinding.ActivityMainBinding
import com.example.roomsample.entity.Library
import com.example.roomsample.entity.Playlist
import com.example.roomsample.entity.Song
import com.example.roomsample.entity.User
import com.example.roomsample.viewmodel.UserViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var userViewModel: UserViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        userViewModel = ViewModelProvider(this).get(UserViewModel::class.java)
        binding.viewModel = userViewModel
        binding.lifecycleOwner = this

        populateDB()
    }

    private fun populateDB() {
        userViewModel.apply {
            insertUser(User(101, "Arthur", 35))
            insertUser(User(102, "Thomas", 30))

            insertPlaylist(Playlist(301, 101, "FavPlaylist"))
            insertPlaylist(Playlist(302, 101, "Workout"))
            insertPlaylist(Playlist(303, 102, "EDM list"))

            insertSong(Song(401, "The Search", "NF"))
            insertSong(Song(402, "Berridim", "Berrywam"))
            insertSong(Song(403, "DeathBed", "Powfu"))
            insertSong(Song(404, "uproar", "Lil Wayne"))
            insertSong(Song(405, "Astronomia", "Vincent"))

            insertLibrary(Library(201, 101))
            insertLibrary(Library(202, 102))
        }
    }
}