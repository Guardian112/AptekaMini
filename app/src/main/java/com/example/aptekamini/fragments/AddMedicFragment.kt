package com.example.aptekamini.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.MenuHost
import androidx.core.view.MenuProvider
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.navigation.findNavController
import com.example.aptekamini.MainActivity
import com.example.aptekamini.R
import com.example.aptekamini.databinding.FragmentAddMedicBinding
import com.example.aptekamini.model.MedicEntity
import com.example.aptekamini.viewModel.MedicViewModel

class AddMedicFragment : Fragment(R.layout.fragment_add_medic), MenuProvider {

    private var addMedicBinding: FragmentAddMedicBinding? = null
    private val binding get() = addMedicBinding!!

    private lateinit var medicViewModel: MedicViewModel
    private lateinit var addMedicView: View

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        addMedicBinding = FragmentAddMedicBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val menuHost: MenuHost = requireActivity()
        menuHost.addMenuProvider(this, viewLifecycleOwner, Lifecycle.State.RESUMED)

        medicViewModel = (activity as MainActivity).medicViewModel
        addMedicView = view
    }

    private fun saveMedic(view: View) {
        val medicName = binding.addMedicName.text.toString().trim()
        val medicDosage = binding.addMedicDosage.text.toString().trim()
        val medicDescription = binding.addMedicDescription.text.toString().trim()

        if (medicName.isNotEmpty() && medicDosage.isNotEmpty() && medicDescription.isNotEmpty()){
            val medic = MedicEntity(0, medicName, medicDosage, medicDescription)
            medicViewModel.addMedic(medic)

            Toast.makeText(addMedicView.context, "Лекарстов создано", Toast.LENGTH_SHORT).show()
            view.findNavController().popBackStack(R.id.medicListFragment, false)
        }
        else {
            Toast.makeText(addMedicView.context, "Не все данные введены", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
        menu.clear()
        menuInflater.inflate(R.menu.add_menu, menu)
    }

    override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
        return when(menuItem.itemId){
            R.id.saveMenu -> {
                saveMedic(addMedicView)
                true
            }
            else -> false
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        addMedicBinding = null
    }
}