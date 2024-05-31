package com.example.aptekamini

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.isVisible
import com.example.aptekamini.databinding.ActivitySearchViewBinding

class SearchViewActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySearchViewBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_search_view)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        binding = ActivitySearchViewBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
    fun mainOnClick(view: View) {
        val intent = Intent(this@SearchViewActivity, MainActivity::class.java)
        startActivity(intent)
    }
    fun searchOnClick(view: View) {}
    fun selectMedicOnClick(view: View) {
        with(binding) {
            selectMedic.setBackgroundColor (ContextCompat.getColor(
                this@SearchViewActivity,
                R.color.button)
            )
            selectPharmacy.setBackgroundColor (ContextCompat.getColor(
                this@SearchViewActivity,
                R.color.offbutton)
            )
            medicLayout.isVisible = true
            pharmacyLayout.isVisible = false
        }
    }
    fun selectPharmacyOnClick(view: View) {
        with(binding) {
            selectPharmacy.setBackgroundColor (ContextCompat.getColor(
                this@SearchViewActivity,
                R.color.button)
            )
            selectMedic.setBackgroundColor (ContextCompat.getColor(
                this@SearchViewActivity,
                R.color.offbutton)
            )
            medicLayout.isVisible = false
            pharmacyLayout.isVisible = true
        }
    }
}