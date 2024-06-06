package com.example.aptekamini.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.SearchView
import androidx.core.view.MenuHost
import androidx.core.view.MenuProvider
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.aptekamini.MainActivity
import com.example.aptekamini.R
import com.example.aptekamini.adapter.MedicListAdapter
import com.example.aptekamini.databinding.FragmentMedicListBinding
import com.example.aptekamini.model.MedicEntity
import com.example.aptekamini.viewModel.MedicViewModel

class MedicListFragment: Fragment(R.layout.fragment_medic_list), SearchView.OnQueryTextListener, MenuProvider {
    private var medicBinding: FragmentMedicListBinding? = null
    private val binding get() = medicBinding!!

    private lateinit var medicViewModel: MedicViewModel
    private lateinit var medicListAdapter: MedicListAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        medicBinding = FragmentMedicListBinding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val goToMain = view.findViewById<Button>(R.id.goToMain)
        val controller = findNavController()

        val menuHost: MenuHost = requireActivity()
        menuHost.addMenuProvider(this, viewLifecycleOwner, Lifecycle.State.RESUMED)

        medicViewModel = (activity as MainActivity).medicViewModel
        setupMedicRecyclerView()

        goToMain.setOnClickListener {
            controller.navigate(R.id.action_medicListFragment_to_mainFragment)
        }
    }

    private fun updateUI(medic: List<MedicEntity>?){
        if (medic != null){
            if (medic.isNotEmpty()){
                binding.appAvatar.visibility = View.GONE
                binding.medicList.visibility = View.VISIBLE
            }
            else {
                binding.appAvatar.visibility = View.VISIBLE
                binding.medicList.visibility = View.GONE
            }
        }
    }

    private fun setupMedicRecyclerView(){
        medicListAdapter = MedicListAdapter()
        binding.medicList.apply {
            layoutManager = StaggeredGridLayoutManager(1,StaggeredGridLayoutManager.VERTICAL)
            setHasFixedSize(true)
            adapter = medicListAdapter
        }
        activity?.let {
            medicViewModel.getAllMedic().observe(viewLifecycleOwner){ medic ->
                medicListAdapter.differ.submitList(medic)
            }
        }
    }

    private fun searchMedic(query: String?){
        val searchQuery = "%$query"
        Log.d("SearchMedic", "Query: $searchQuery")

        medicViewModel.searchMedic(searchQuery).observe(this) {medic ->
            if (medic != null && medic.isNotEmpty()) {
                medicListAdapter.differ.submitList(medic)
                updateUI(medic)
            }
            else {
                Log.d("SearchMedic", "No data found for query: $searchQuery")
            }
        }
    }

    override fun onQueryTextSubmit(query: String?): Boolean {
        return false
    }
    override fun onQueryTextChange(newText: String?): Boolean {
        if (newText != null){
            searchMedic(newText)
        }
        return true
    }
    override fun onDestroy() {
        super.onDestroy()
        medicBinding = null
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