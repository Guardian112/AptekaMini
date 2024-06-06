package com.example.aptekamini.repository

import com.example.aptekamini.database.MainDB
import com.example.aptekamini.model.MedicEntity
import com.example.aptekamini.model.PharmacyEntity

class Repository(private val db: MainDB) {

    suspend fun addMedic(medicEntity: MedicEntity) = db.getDao().addMedic(medicEntity)
    suspend fun updateMedic(medicEntity: MedicEntity) = db.getDao().updateMedic(medicEntity)
    suspend fun deleteMedic(medicEntity: MedicEntity) = db.getDao().deleteMedic(medicEntity)

    fun getAllMedic() = db.getDao().getAllMedic()
    fun searchMedic(query: String?) = db.getDao().searchMedic(query)

    suspend fun addPharmacy(pharmacyEntity: PharmacyEntity) = db.getDao().addPharmacy(pharmacyEntity)
    suspend fun updatePharmacy(pharmacyEntity: PharmacyEntity) = db.getDao().updatePharmacy(pharmacyEntity)
    suspend fun deletePharmacy(pharmacyEntity: PharmacyEntity) = db.getDao().deletePharmacy(pharmacyEntity)

    fun getAllPharmacy() = db.getDao().getAllPharmacy()
    fun searchPharmacy(query: String?) = db.getDao().searchPharmacy(query)
}