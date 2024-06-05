package com.example.aptekamini.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.aptekamini.model.MedicEntity
import com.example.aptekamini.repository.Repository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MedicViewModel(app: Application, private val medicRepository: Repository): AndroidViewModel(app) {

    fun addMedic(medicEntity: MedicEntity) =
        viewModelScope.launch(Dispatchers.IO) {
            medicRepository.addMedic(medicEntity)
        }

    fun updateMedic(medicEntity: MedicEntity) =
        viewModelScope.launch(Dispatchers.IO) {
            medicRepository.updateMedic(medicEntity)
        }

    fun deleteMedic(medicEntity: MedicEntity) =
        viewModelScope.launch(Dispatchers.IO) {
            medicRepository.deleteMedic(medicEntity)
        }

    fun getAllMedic() = medicRepository.getAllMedic()

    fun searchMedic(query: String?) = medicRepository.searchMedic(query)
}