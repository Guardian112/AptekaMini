package com.example.aptekamini.model

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Entity(tableName = "Availability")
@Parcelize
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
): Parcelable