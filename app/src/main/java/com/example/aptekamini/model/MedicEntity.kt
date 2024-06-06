package com.example.aptekamini.model

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Entity(tableName = "Medicament")
@Parcelize
data class MedicEntity (
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null,
    @ColumnInfo(name = "name")
    var name: String,
    @ColumnInfo(name = "dosage")
    var dosage: String,
    @ColumnInfo(name = "description")
    var description: String
): Parcelable