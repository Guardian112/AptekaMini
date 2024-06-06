package com.example.aptekamini.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.aptekamini.model.AvailabilityEntity
import com.example.aptekamini.model.MedicEntity
import com.example.aptekamini.model.PharmacyEntity

/*
* Создание БД
*/
@Database(entities = [MedicEntity::class, PharmacyEntity::class, AvailabilityEntity::class], version = 1)
abstract class MainDB : RoomDatabase() {
    abstract fun getDao(): Dao
    companion object {
        @Volatile
        private var instance: MainDB? = null
        private val LOCK = Any()

        operator fun invoke(context: Context) = instance?:
        synchronized(LOCK){
            instance ?:
            getDB(context).also {
                instance = it
            }
        }
        fun getDB(context: Context): MainDB {
            return Room.databaseBuilder(
                context.applicationContext,
                MainDB::class.java,
                "AptekaMiniDB"
            ).build()
        }
    }
}