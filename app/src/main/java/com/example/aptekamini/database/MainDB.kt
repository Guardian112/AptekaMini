package com.example.aptekamini.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.aptekamini.database.entities.AvailabilityEntity
import com.example.aptekamini.database.entities.MedicEntity
import com.example.aptekamini.database.entities.PharmacyEntity

@Database(entities = [MedicEntity::class, PharmacyEntity::class, AvailabilityEntity::class], version = 1)
abstract class MainDB : RoomDatabase() {
    abstract fun getDao(): Dao

    companion object {
        fun getDB(context: Context): MainDB {
            return Room.databaseBuilder(
                context.applicationContext,
                MainDB::class.java,
                "AptekaMiniDB"
            ).build()
        }
    }
}