package com.example.aptekamini.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.aptekamini.model.PharmacyEntity
import com.example.aptekamini.repository.Repository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class PharmacyViewModel(app: Application, private val pharmacyRepository: Repository): AndroidViewModel(app) {
    fun addPharmacy(pharmacyEntity: PharmacyEntity) =
        viewModelScope.launch(Dispatchers.IO) {
            pharmacyRepository.addPharmacy(pharmacyEntity)
        }

    fun updatePharmacy(pharmacyEntity: PharmacyEntity) =
        viewModelScope.launch(Dispatchers.IO) {
            pharmacyRepository.updatePharmacy(pharmacyEntity)
        }

    fun deletePharmacy(pharmacyEntity: PharmacyEntity) =
        viewModelScope.launch(Dispatchers.IO) {
            pharmacyRepository.deletePharmacy(pharmacyEntity)
        }

    fun getAllPharmacy() = pharmacyRepository.getAllPharmacy()

    fun searchPharmacy(query: String?) = pharmacyRepository.searchPharmacy(query)

}