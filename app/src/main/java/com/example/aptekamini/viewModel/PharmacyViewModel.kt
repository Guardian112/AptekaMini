package com.example.aptekamini.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.aptekamini.model.PharmacyEntity
import com.example.aptekamini.repository.Repository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class PharmacyViewModel(app: Application, private val repository: Repository): AndroidViewModel(app) {
    fun addPharmacy(pharmacyEntity: PharmacyEntity) =
        viewModelScope.launch(Dispatchers.IO) {
            repository.addPharmacy(pharmacyEntity)
        }

    fun updatePharmacy(pharmacyEntity: PharmacyEntity) =
        viewModelScope.launch(Dispatchers.IO) {
            repository.updatePharmacy(pharmacyEntity)
        }

    fun deletePharmacy(pharmacyEntity: PharmacyEntity) =
        viewModelScope.launch(Dispatchers.IO) {
            repository.deletePharmacy(pharmacyEntity)
        }

    fun getAllPharmacy() = repository.getAllPharmacy()

    fun searchPharmacy(query: String?) = repository.searchPharmacy(query)
}