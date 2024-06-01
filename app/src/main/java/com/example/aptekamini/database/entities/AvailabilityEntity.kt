package com.example.aptekamini.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(tableName = "Availability")
data class AvailabilityEntity (
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null,
    @ColumnInfo(name = "pharmacyId")
    var pharmacyId: Int,
    @ColumnInfo(name = "medicamentId")
    var medicamentId: Int,
    @ColumnInfo(name = "price")
    var price: Int,
    @ColumnInfo(name = "quantity")
    var quantity: Int
)