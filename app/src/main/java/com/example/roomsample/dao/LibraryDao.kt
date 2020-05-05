package com.example.roomsample.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.example.roomsample.entity.Library

/**
 * Created by PR72510 on 5/5/20.
 */

@Dao
interface LibraryDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertLibrary(library: Library)
}