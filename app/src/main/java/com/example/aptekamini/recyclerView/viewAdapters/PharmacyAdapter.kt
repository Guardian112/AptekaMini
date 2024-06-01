package com.example.aptekamini.recyclerView.viewAdapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.aptekamini.R
import com.example.aptekamini.databinding.PatternPharmacyBinding
import com.example.aptekamini.recyclerView.models.PharmacyModel

class PharmacyAdapter: RecyclerView.Adapter<PharmacyAdapter.PharmacyHolder>()  {
    val pharmacyModelList = ArrayList<PharmacyModel>()
    class PharmacyHolder(item: View): RecyclerView.ViewHolder(item)  {
        val binding = PatternPharmacyBinding.bind(item)
        fun bind(pharmacyModel: PharmacyModel) = with(binding) {
            pharmacyName.text = pharmacyModel.name
            time.text = pharmacyModel.address
            adress.text = pharmacyModel.workSchedule
            phone.text = pharmacyModel.contactInformation
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PharmacyHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.pattern_pharmacy, parent, false)
        return PharmacyHolder(view)
    }

    override fun onBindViewHolder(holder: PharmacyHolder, position: Int) {
        holder.bind(pharmacyModelList[position])
    }

    override fun getItemCount(): Int {
        return pharmacyModelList.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun addPharmacy(pharmacyModel: PharmacyModel) {
        pharmacyModelList.add(pharmacyModel)
        notifyDataSetChanged()
    }
}