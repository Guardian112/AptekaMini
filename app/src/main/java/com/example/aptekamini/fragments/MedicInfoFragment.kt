package com.example.aptekamini.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.aptekamini.R
import com.example.aptekamini.databinding.FragmentMedicInfoBinding

class MedicInfoFragment : Fragment(R.layout.fragment_medic_info) {
    private var medicBinding: FragmentMedicInfoBinding? = null
    private val binding get() = medicBinding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        medicBinding = FragmentMedicInfoBinding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }
}