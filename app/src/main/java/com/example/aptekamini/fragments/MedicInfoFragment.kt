package com.example.aptekamini.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.example.aptekamini.MainActivity
import com.example.aptekamini.R
import com.example.aptekamini.databinding.FragmentMedicInfoBinding
import com.example.aptekamini.model.MedicEntity
import com.example.aptekamini.viewModel.MedicViewModel

class MedicInfoFragment : Fragment(R.layout.fragment_medic_info) {
    private var medicBinding: FragmentMedicInfoBinding? = null
    private val binding get() = medicBinding!!

    lateinit var medicViewModel: MedicViewModel
    lateinit var currentMedic: MedicEntity

    private val args: MedicInfoFragmentArgs by navArgs()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        medicBinding = FragmentMedicInfoBinding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        medicViewModel = (activity as MainActivity).medicViewModel
        currentMedic = args.medic!!
        //setupPriseRecyclerView()

        binding.medicInfoName.setText(currentMedic.name)
        binding.medicInfoDosage.setText(currentMedic.dosage)
        binding.medicInfoDescription.setText(currentMedic.description)
    }
}