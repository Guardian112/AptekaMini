package com.example.aptekamini.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.aptekamini.model.MedicEntity
import com.example.aptekamini.repository.Repository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MedicViewModel(app: Application, private val repository: Repository): AndroidViewModel(app) {

    fun addMedic(medicEntity: MedicEntity) =
        viewModelScope.launch(Dispatchers.IO) {
            repository.addMedic(medicEntity)
        }

    fun updateMedic(medicEntity: MedicEntity) =
        viewModelScope.launch(Dispatchers.IO) {
            repository.updateMedic(medicEntity)
        }

    fun deleteMedic(medicEntity: MedicEntity) =
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteMedic(medicEntity)
        }

    fun getAllMedic() = repository.getAllMedic()

    fun searchMedic(query: String?) = repository.searchMedic(query)
}