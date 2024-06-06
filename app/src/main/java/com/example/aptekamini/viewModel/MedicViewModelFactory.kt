package com.example.aptekamini.viewModel

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.aptekamini.repository.Repository

class MedicViewModelFactory(val app: Application, private val medicRepository: Repository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MedicViewModel(app, medicRepository) as T
    }
}