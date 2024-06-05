package com.example.aptekamini.repository

import com.example.aptekamini.database.MainDB
import com.example.aptekamini.model.MedicEntity

class Repository(private val db: MainDB) {

    suspend fun addMedic(medicEntity: MedicEntity) = db.getDao().addMedic(medicEntity)
    suspend fun updateMedic(medicEntity: MedicEntity) = db.getDao().updateMedic(medicEntity)
    suspend fun deleteMedic(medicEntity: MedicEntity) = db.getDao().deleteMedic(medicEntity)

    fun getAllMedic() = db.getDao().getAllMedic()
    fun searchMedic(query: String?) = db.getDao().searchMedic(query)
}