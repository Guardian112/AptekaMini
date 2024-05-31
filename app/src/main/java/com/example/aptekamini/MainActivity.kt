package com.example.aptekamini

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
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
    fun medicOnClick(view: View) {
        val intent = Intent(this@MainActivity, MedicInfoActivity::class.java)
        startActivity(intent)
    }
    fun pharmacyOnClick(view: View) {
        val intent = Intent(this@MainActivity, PharmacyInfoActivity::class.java)
        startActivity(intent)
    }
    fun searchOnClick(view: View) {
        val intent = Intent(this@MainActivity, SearchViewActivity::class.java)
        startActivity(intent)
    }
}