package com.example.aptekamini

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.isInvisible
import androidx.core.view.isVisible
import com.example.aptekamini.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
    fun MedicOnClick(view: View) {
        with(binding) {
            appAvatar.isVisible = false
            goToMedic.isVisible = false
            goToPharmacy.isVisible = true
            goToMainLeft.isVisible = true
            goToMainRight.isVisible = false
            infoScrollView.isVisible = true
            medicLayout.isVisible = true
            pharmacyLayout.isVisible = false
        }
    }
    fun PharmacyOnClick(view: View) {
        with(binding) {
            appAvatar.isVisible = false
            goToMedic.isVisible = true
            goToPharmacy.isVisible = false
            goToMainLeft.isVisible = false
            goToMainRight.isVisible = true
            infoScrollView.isVisible = true
            medicLayout.isVisible = false
            pharmacyLayout.isVisible = true
        }
    }
    fun MainOnClick(view: View) {
        with(binding) {
            appAvatar.isVisible = true
            goToMedic.isVisible = true
            goToPharmacy.isVisible = true
            goToMainLeft.isVisible = false
            goToMainRight.isVisible = false
            infoScrollView.isVisible = false
            medicLayout.isVisible = false
            pharmacyLayout.isVisible = false
        }
    }
    fun SearchOnClick(view: View) {}
}