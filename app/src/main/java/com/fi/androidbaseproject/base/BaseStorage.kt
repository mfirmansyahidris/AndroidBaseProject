package com.fi.androidbaseproject.base

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.fi.androidbaseproject.BuildConfig
import com.fi.androidbaseproject.dao.NameDao
import com.fi.androidbaseproject.models.Name

/**
 ****************************************
created by -fi-
.::manca.fi@gmail.com ::.

30/06/2020, 10:42 AM
 ****************************************
 */

@Database(entities = [Name::class], version = 1)
abstract class BaseStorage : RoomDatabase() {
    abstract fun nameDao(): NameDao

    companion object {
        @Volatile
        private var instance: BaseStorage? = null
        private val LOCK = Any()

        operator fun invoke(context: Context) = instance
            ?: synchronized(LOCK) {
            instance
                ?: buildDatabase(
                    context
                ).also { instance = it }
        }

        private fun buildDatabase(context: Context) = Room.databaseBuilder(
            context,
            BaseStorage::class.java, "${BuildConfig.APPLICATION_NAME}.db"
        )
            .build()
    }
}