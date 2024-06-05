package com.example.aptekamini.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.aptekamini.R
import com.example.aptekamini.databinding.PharmacyLayoutBinding
import com.example.aptekamini.model.PharmacyEntity

class PharmacyListAdapter: RecyclerView.Adapter<PharmacyListAdapter.PharmacyHolder>()  {
    val pharmacyModelList = ArrayList<PharmacyEntity>()
    class PharmacyHolder(item: View): RecyclerView.ViewHolder(item)  {
        val binding = PharmacyLayoutBinding.bind(item)
        fun bind(pharmacyModel: PharmacyEntity) = with(binding) {
            pharmacyName.text = pharmacyModel.name
            time.text = pharmacyModel.address
            adress.text = pharmacyModel.workSchedule
            phone.text = pharmacyModel.contactInformation
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PharmacyHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.pharmacy_layout, parent, false)
        return PharmacyHolder(view)
    }

    override fun onBindViewHolder(holder: PharmacyHolder, position: Int) {
        holder.bind(pharmacyModelList[position])
    }

    override fun getItemCount(): Int {
        return pharmacyModelList.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun addPharmacy(pharmacyModel: PharmacyEntity) {
        pharmacyModelList.add(pharmacyModel)
        notifyDataSetChanged()
    }
}