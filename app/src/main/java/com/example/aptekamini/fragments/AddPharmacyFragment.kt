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
import com.example.aptekamini.databinding.FragmentAddPharmacyBinding
import com.example.aptekamini.model.PharmacyEntity
import com.example.aptekamini.viewModel.PharmacyViewModel

class AddPharmacyFragment : Fragment(R.layout.fragment_add_pharmacy), MenuProvider {

    private var addPharmacyBinding: FragmentAddPharmacyBinding? = null
    private val binding get() = addPharmacyBinding!!

    private lateinit var pharmacyViewModel: PharmacyViewModel
    private lateinit var addPharmacyView: View

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        addPharmacyBinding = FragmentAddPharmacyBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val menuHost: MenuHost = requireActivity()
        menuHost.addMenuProvider(this, viewLifecycleOwner, Lifecycle.State.RESUMED)

        pharmacyViewModel = (activity as MainActivity).pharmacyViewModel
        addPharmacyView = view
    }

    private fun savePharmacy(view: View) {
        val pharmacyName = binding.addPharmacyName.text.toString().trim()
        val pharmacyAdress = binding.addPharmacyAdress.text.toString().trim()
        val pharmacyContactInformation = binding.addPharmacyContactInformation.text.toString().trim()
        val pharmacyWorkTime = binding.addPharmacyWorkTime.text.toString().trim()

        if (pharmacyName.isNotEmpty() &&
            pharmacyAdress.isNotEmpty() &&
            pharmacyContactInformation.isNotEmpty() &&
            pharmacyWorkTime.isNotEmpty()){
            val pharmacy = PharmacyEntity(0, pharmacyName, pharmacyAdress, pharmacyContactInformation, pharmacyWorkTime)
            pharmacyViewModel.addPharmacy(pharmacy)

            Toast.makeText(addPharmacyView.context, "Аптека создана", Toast.LENGTH_SHORT).show()
            view.findNavController().popBackStack(R.id.pharmacyListFragment, false)
        }
        else {
            Toast.makeText(addPharmacyView.context, "Не все данные введены", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
        menu.clear()
        menuInflater.inflate(R.menu.add_menu, menu)
    }

    override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
        return when(menuItem.itemId){
            R.id.saveMenu -> {
                savePharmacy(addPharmacyView)
                true
            }
            else -> false
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        addPharmacyBinding = null
    }
}