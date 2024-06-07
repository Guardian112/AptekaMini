package com.example.aptekamini.fragments

import android.app.AlertDialog
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
import androidx.navigation.fragment.navArgs
import com.example.aptekamini.MainActivity
import com.example.aptekamini.R
import com.example.aptekamini.databinding.FragmentPharmacyInfoBinding
import com.example.aptekamini.model.PharmacyEntity
import com.example.aptekamini.viewModel.PharmacyViewModel

class PharmacyInfoFragment : Fragment(R.layout.fragment_pharmacy_info), MenuProvider {
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

        val menuHost: MenuHost = requireActivity()
        menuHost.addMenuProvider(this, viewLifecycleOwner, Lifecycle.State.RESUMED)

        pharmacyViewModel = (activity as MainActivity).pharmacyViewModel
        currentPharmacy = args.pharmacy!!

        binding.editPharmacyInfoName.setText(currentPharmacy.name)
        binding.editPharmacyInfoAdress.setText(currentPharmacy.address)
        binding.editPharmacyInfoNumber.setText(currentPharmacy.contactInformation)
        binding.editPharmacyInfoWorkTime.setText(currentPharmacy.workSchedule)

        binding.editPharmacyBut.setOnClickListener {
            val pharmacyName = binding.editPharmacyInfoName.text.toString().trim()
            val pharmacyAdress = binding.editPharmacyInfoAdress.text.toString().trim()
            val pharmacyContactInformation = binding.editPharmacyInfoNumber.text.toString().trim()
            val pharmacyWorkTime = binding.editPharmacyInfoWorkTime.text.toString().trim()

            if (pharmacyName.isNotEmpty() &&
                pharmacyAdress.isNotEmpty() &&
                pharmacyContactInformation.isNotEmpty() &&
                pharmacyWorkTime.isNotEmpty()){
                val pharmacy = PharmacyEntity(currentPharmacy.id, pharmacyName, pharmacyAdress, pharmacyContactInformation, pharmacyWorkTime)
                pharmacyViewModel.updatePharmacy(pharmacy)
                view.findNavController().popBackStack(R.id.pharmacyListFragment, false)
            }
            else {
                Toast.makeText(context, "Не все данные введены", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun deletePharmacy(){
        AlertDialog.Builder(activity).apply {
            setTitle("Удалить аптеку")
            setMessage("Вы хотите удалить эту аптеку?")
            setPositiveButton("Удалить") {_,_ ->
                pharmacyViewModel.deletePharmacy(currentPharmacy)
                Toast.makeText(context, "Лекарство удалено", Toast.LENGTH_SHORT).show()
                view?.findNavController()?.popBackStack(R.id.pharmacyListFragment, false)
            }
            setNegativeButton("Отмена", null)
        }.create().show()
    }

    override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
        menu.clear()
        menuInflater.inflate(R.menu.delete_menu, menu)
    }

    override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
        return when(menuItem.itemId) {
            R.id.deleteMenu -> {
                deletePharmacy()
                true
            }
            else -> false
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        pharmacyBinding = null
    }
}