package com.example.aptekamini.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.example.aptekamini.MainActivity
import com.example.aptekamini.databinding.FragmentPharmacyInfoBinding
import com.example.aptekamini.model.PharmacyEntity
import com.example.aptekamini.viewModel.PharmacyViewModel

class PharmacyInfoFragment : Fragment() {
    private var pharmacyBinding: FragmentPharmacyInfoBinding? = null
    private val binding get() = pharmacyBinding!!

    lateinit var pharmacyViewModel: PharmacyViewModel
    lateinit var currentPharmacy: PharmacyEntity

    private val args: PharmacyInfoFragmentArgs by navArgs()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        pharmacyBinding = FragmentPharmacyInfoBinding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        pharmacyViewModel = (activity as MainActivity).pharmacyViewModel
        currentPharmacy = args.pharmacy!!

        binding.pharmacyInfoName.setText(currentPharmacy.name)
        binding.pharmacyInfoAdress.setText(currentPharmacy.address)
        binding.pharmacyInfoNumber.setText(currentPharmacy.contactInformation)
        binding.pharmacyInfoWorkTime.setText(currentPharmacy.workSchedule)
    }
}