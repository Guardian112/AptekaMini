package com.example.aptekamini

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider
import com.example.aptekamini.R
import com.example.aptekamini.database.MainDB
import com.example.aptekamini.databinding.ActivityMainBinding
import com.example.aptekamini.repository.Repository
import com.example.aptekamini.viewModel.MedicViewModel
import com.example.aptekamini.viewModel.MedicViewModelFactory

class MainActivity : AppCompatActivity() {
    lateinit var medicViewModel: MedicViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupViewModel()
    }

    private fun setupViewModel(){
        val medicRepository = Repository(MainDB(this))
        val viewModelProviderFactory = MedicViewModelFactory(application, medicRepository)
        medicViewModel = ViewModelProvider(this, viewModelProviderFactory)[MedicViewModel::class.java]
    }
}