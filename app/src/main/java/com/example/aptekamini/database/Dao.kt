package com.example.aptekamini.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.aptekamini.database.entities.MedicEntity
import com.example.aptekamini.database.entities.PharmacyEntity
import com.example.aptekamini.database.entities.AvailabilityEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface Dao {
    @Insert
    fun insertMedic(medicEntity: MedicEntity)
    @Query("SELECT name, dosage FROM Medicament ORDER BY id")
    fun detAllMedic(): Flow<List<MedicEntity>>
    @Query("SELECT * FROM Pharmacy ORDER BY id")
    fun detAllPharmacy(): Flow<List<PharmacyEntity>>
}