package com.example.roomsample.dao

import androidx.room.*
import com.example.roomsample.entity.User
import com.example.roomsample.entity.UserAndLibrary
import com.example.roomsample.entity.UserWithPlaylists

/**
 * Created by PR72510 on 5/5/20.
 */
@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertUser(user: User)

    @Transaction
    @Query("Select * from USER")
    suspend fun getUserAndLibraries(): List<UserAndLibrary>

    @Transaction
    @Query("SELECT * FROM User")
    suspend fun getUsersWithPlaylists(): List<UserWithPlaylists>
}
