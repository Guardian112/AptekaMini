package com.example.aptekamini.model

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Entity(tableName = "Pharmacy")
@Parcelize
data class PharmacyEntity (
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null,
    @ColumnInfo(name = "name")
    var name: String,
    @ColumnInfo(name = "address")
    var address: String,
    @ColumnInfo(name = "workSchedule")
    var workSchedule: String,
    @ColumnInfo(name = "contactInformation")
    var contactInformation: String
): Parcelable