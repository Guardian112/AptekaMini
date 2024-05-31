package com.example.aptekamini

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.aptekamini.databinding.ActivityMedicInfoBinding
import com.example.aptekamini.databinding.ActivityPharmacyInfoBinding

class PharmacyInfoActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPharmacyInfoBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_pharmacy_info)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        binding = ActivityPharmacyInfoBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
    fun mainOnClick(view: View) {
        val intent = Intent(this@PharmacyInfoActivity, MainActivity::class.java)
        startActivity(intent)
    }
    fun medicOnClick(view: View) {
        val intent = Intent(this@PharmacyInfoActivity, MedicInfoActivity::class.java)
        startActivity(intent)
    }
    fun searchOnClick(view: View) {
        val intent = Intent(this@PharmacyInfoActivity, SearchViewActivity::class.java)
        startActivity(intent)
    }
}