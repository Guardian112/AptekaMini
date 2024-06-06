package com.example.aptekamini

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.aptekamini.database.MainDB
import com.example.aptekamini.repository.Repository
import com.example.aptekamini.viewModel.MedicViewModel
import com.example.aptekamini.viewModel.MedicViewModelFactory
import com.example.aptekamini.viewModel.PharmacyViewModel
import com.example.aptekamini.viewModel.PharmacyViewModelFactory

class MainActivity : AppCompatActivity() {
    lateinit var medicViewModel: MedicViewModel
    lateinit var pharmacyViewModel: PharmacyViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupViewModel()
    }

    private fun setupViewModel(){
        val repository = Repository(MainDB(this))
        val viewModelProviderFactory = MedicViewModelFactory(application, repository)
        val viewModelProviderFactory2 = PharmacyViewModelFactory(application, repository)
        medicViewModel = ViewModelProvider(this, viewModelProviderFactory)[MedicViewModel::class.java]
        pharmacyViewModel = ViewModelProvider(this, viewModelProviderFactory2)[PharmacyViewModel::class.java]
    }
}