package com.example.aptekamini.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Medicament")
data class MedicEntity (
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null,
    @ColumnInfo(name = "name")
    var name: String,
    @ColumnInfo(name = "description")
    var description: String,
    @ColumnInfo(name = "dosage")
    var dosage: String,
    @ColumnInfo(name = "manufacturer")
    var manufacturer: String
)