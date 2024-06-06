package com.example.aptekamini.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.aptekamini.model.MedicEntity
import com.example.aptekamini.model.PharmacyEntity

/*
*   Database access object
*   Написание SLQ запросов для добавления, изменения, удаления, вывода и поиска данных из БД
*/
@Dao
interface Dao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addMedic(medicEntity: MedicEntity)

    @Update
    fun updateMedic(medicEntity: MedicEntity)

    @Delete
    fun deleteMedic(medicEntity: MedicEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addPharmacy(pharmacyEntity: PharmacyEntity)

    @Update
    fun updatePharmacy(pharmacyEntity: PharmacyEntity)

    @Delete
    fun deletePharmacy(pharmacyEntity: PharmacyEntity)

    @Query("SELECT * FROM Medicament ORDER BY id")
    fun getAllMedic(): LiveData<List<MedicEntity>>

    @Query("SELECT * FROM Pharmacy ORDER BY id")
    fun getAllPharmacy(): LiveData<List<PharmacyEntity>>

    @Query("SELECT * FROM Medicament WHERE name LIKE :query")
    fun searchMedic(query: String?): LiveData<List<MedicEntity>>

    @Query("SELECT * FROM Pharmacy WHERE name LIKE :query")
    fun searchPharmacy(query: String?): LiveData<List<PharmacyEntity>>
}