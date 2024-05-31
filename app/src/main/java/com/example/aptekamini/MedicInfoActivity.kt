package com.example.aptekamini

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.aptekamini.databinding.ActivityMainBinding
import com.example.aptekamini.databinding.ActivityMedicInfoBinding

class MedicInfoActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMedicInfoBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_medic_info)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        binding = ActivityMedicInfoBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
    fun mainOnClick(view: View) {
        val intent = Intent(this@MedicInfoActivity, MainActivity::class.java)
        startActivity(intent)
    }
    fun pharmacyOnClick(view: View) {
        val intent = Intent(this@MedicInfoActivity, PharmacyInfoActivity::class.java)
        startActivity(intent)
    }
    fun searchOnClick(view: View) {
        val intent = Intent(this@MedicInfoActivity, SearchViewActivity::class.java)
        startActivity(intent)
    }
}