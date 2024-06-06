package com.example.aptekamini.viewModel

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.aptekamini.repository.Repository

class PharmacyViewModelFactory(val app: Application, private val pharmacyRepository: Repository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return PharmacyViewModel(app, pharmacyRepository) as T
    }
}