package com.example.aptekamini.fragments

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.MenuHost
import androidx.core.view.MenuProvider
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import com.example.aptekamini.MainActivity
import com.example.aptekamini.R
import com.example.aptekamini.databinding.FragmentMedicInfoBinding
import com.example.aptekamini.model.MedicEntity
import com.example.aptekamini.viewModel.MedicViewModel

class MedicInfoFragment : Fragment(R.layout.fragment_medic_info), MenuProvider {
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

        val menuHost: MenuHost = requireActivity()
        menuHost.addMenuProvider(this, viewLifecycleOwner, Lifecycle.State.RESUMED)

        medicViewModel = (activity as MainActivity).medicViewModel
        currentMedic = args.medic!!

        binding.editMedicInfoName.setText(currentMedic.name)
        binding.editMedicInfoDosage.setText(currentMedic.dosage)
        binding.editMedicInfoDescription.setText(currentMedic.description)

        binding.editMedicBut.setOnClickListener {
            val medicName = binding.editMedicInfoName.text.toString().trim()
            val medicDosage = binding.editMedicInfoDosage.text.toString().trim()
            val medicDescription = binding.editMedicInfoDescription.text.toString().trim()

            if (medicName.isNotEmpty() && medicDosage.isNotEmpty() && medicDescription.isNotEmpty()){
                val medic = MedicEntity(currentMedic.id, medicName, medicDosage, medicDescription)
                medicViewModel.updateMedic(medic)
                view.findNavController().popBackStack(R.id.medicListFragment, false)
            }
            else {
                Toast.makeText(context, "Не все данные введены", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun deleteMedic(){
        AlertDialog.Builder(activity).apply {
            setTitle("Удалить лекарство")
            setMessage("Вы хотите удалить это лекарство?")
            setPositiveButton("Удалить") {_,_ ->
                medicViewModel.deleteMedic(currentMedic)
                Toast.makeText(context, "Лекарство удалено", Toast.LENGTH_SHORT).show()
                view?.findNavController()?.popBackStack(R.id.medicListFragment, false)
            }
            setNegativeButton("Отменить", null)
        }
    }
}