package com.example.aptekamini.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController
import com.example.aptekamini.R

class PharmacyFragment: Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_pharmacy, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val bF1 = view.findViewById<Button>(R.id.goToMedic)
        val bF2 = view.findViewById<Button>(R.id.goToMainRight)
        val controller = findNavController()
        bF1.setOnClickListener {
            controller.navigate(R.id.action_pharmacyFragment_to_medicFragment)
        }
        bF2.setOnClickListener {
            controller.navigate(R.id.action_pharmacyFragment_to_mainFragment)
        }
    }
}