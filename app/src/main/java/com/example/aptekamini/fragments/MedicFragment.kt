package com.example.aptekamini.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController
import com.example.aptekamini.R

class MedicFragment: Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_medic, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val bF1 = view.findViewById<Button>(R.id.goToMainLeft)
        val bF2 = view.findViewById<Button>(R.id.goToPharmacy)
        val controller = findNavController()
        bF1.setOnClickListener {
            controller.navigate(R.id.action_medicFragment_to_mainFragment)
        }
        bF2.setOnClickListener {
            controller.navigate(R.id.action_medicFragment_to_pharmacyFragment)
        }
    }
}