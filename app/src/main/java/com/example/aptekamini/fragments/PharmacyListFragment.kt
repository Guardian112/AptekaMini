package com.example.aptekamini.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.appcompat.widget.SearchView
import androidx.core.view.MenuHost
import androidx.core.view.MenuProvider
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.aptekamini.MainActivity
import com.example.aptekamini.R
import com.example.aptekamini.adapter.PharmacyListAdapter
import com.example.aptekamini.databinding.FragmentPharmacyListBinding
import com.example.aptekamini.model.PharmacyEntity
import com.example.aptekamini.viewModel.PharmacyViewModel

class PharmacyListFragment: Fragment(R.layout.fragment_pharmacy_list), SearchView.OnQueryTextListener, MenuProvider {
    private var pharmacyBinding: FragmentPharmacyListBinding? = null
    private val binding get() = pharmacyBinding!!
    private lateinit var pharmacyViewModel: PharmacyViewModel
    private lateinit var pharmacyListAdapter: PharmacyListAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        pharmacyBinding = FragmentPharmacyListBinding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val goToMain = view.findViewById<Button>(R.id.goToMain)
        val controller = findNavController()

        val menuHost: MenuHost = requireActivity()
        menuHost.addMenuProvider(this, viewLifecycleOwner, Lifecycle.State.RESUMED)

        pharmacyViewModel = (activity as MainActivity).pharmacyViewModel

        binding.addPharmacyBut.setOnClickListener(){
            it.findNavController().navigate(R.id.action_pharmacyListFragment_to_addPharmacyFragment)
        }
        setupPharmacyRecyclerView()

        goToMain.setOnClickListener {
            controller.navigate(R.id.action_pharmacyListFragment_to_mainFragment)
        }
    }

    private fun updateUI(pharmacy: List<PharmacyEntity>?){
        if (pharmacy != null){
            if (pharmacy.isNotEmpty()){
                binding.appAvatar.visibility = View.GONE
                binding.pharmacyList.visibility = View.VISIBLE
            }
            else {
                binding.appAvatar.visibility = View.VISIBLE
                binding.pharmacyList.visibility = View.GONE
            }
        }
    }
    private fun setupPharmacyRecyclerView(){
        pharmacyListAdapter = PharmacyListAdapter()
        binding.pharmacyList.apply {
            layoutManager = StaggeredGridLayoutManager(1,StaggeredGridLayoutManager.VERTICAL)
            setHasFixedSize(true)
            adapter = pharmacyListAdapter
        }
        activity?.let {
            pharmacyViewModel.getAllPharmacy().observe(viewLifecycleOwner){ pharmacy ->
                pharmacyListAdapter.differ.submitList(pharmacy)
            }
        }
    }

    private fun searchPharmacy(query: String?){
        val searchQuery = "%$query"

        pharmacyViewModel.searchPharmacy(searchQuery).observe(this) {pharmacy ->
            pharmacyListAdapter.differ.submitList(pharmacy)
            updateUI(pharmacy)
        }
    }

    override fun onQueryTextSubmit(query: String?): Boolean {
        return false
    }

    override fun onQueryTextChange(newText: String?): Boolean {
        if (newText != null){
            searchPharmacy(newText)
        }
        return true
    }

    override fun onDestroy() {
        super.onDestroy()
        pharmacyBinding = null
    }

    override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
        menu.clear()
        menuInflater.inflate(R.menu.search_menu, menu)

        val menuSearch = menu.findItem(R.id.searchMenu).actionView as? SearchView
        menuSearch?.isSubmitButtonEnabled = false
        menuSearch?.setOnQueryTextListener(this)
    }

    override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
        return false
    }
}