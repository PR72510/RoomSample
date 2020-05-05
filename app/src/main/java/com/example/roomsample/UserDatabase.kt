package com.example.roomsample

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.roomsample.dao.LibraryDao
import com.example.roomsample.dao.PlaylistDao
import com.example.roomsample.dao.SongDao
import com.example.roomsample.dao.UserDao
import com.example.roomsample.entity.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

/**
 * Created by PR72510 on 5/5/20.
 */

@Database(
    entities = [Library::class, Playlist::class, Song::class, User::class, PlaylistSongCrossRefr::class],
    version = 2,
    exportSchema = false
)
abstract class UserDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
    abstract fun songDao(): SongDao
    abstract fun playlistDao(): PlaylistDao
    abstract fun libraryDao(): LibraryDao

    class UserDatabaseCallback(
        private val scope: CoroutineScope
    ) : RoomDatabase.Callback() {
        override fun onOpen(db: SupportSQLiteDatabase) {
            super.onOpen(db)
            INSTANCE?.let { database ->
                scope.launch {
                    populateDatabase(
                        database.userDao(),
                        database.libraryDao(), database.playlistDao(), database.songDao()
                    )
                }
            }
        }

        suspend fun populateDatabase(
            userDao: UserDao,
            libraryDao: LibraryDao,
            playlistDao: PlaylistDao,
            songDao: SongDao
        ) {

        }
    }

    companion object {
        @Volatile
        private var INSTANCE: UserDatabase? = null

        fun getDatabase(
            context: Context,
            scope: CoroutineScope
        ): UserDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null)
                return tempInstance
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    UserDatabase::class.java,
                    "user_database"
                ).addCallback(UserDatabaseCallback(scope))
                    .fallbackToDestructiveMigration().build()
                INSTANCE = instance
                return instance
            }
        }
    }
}