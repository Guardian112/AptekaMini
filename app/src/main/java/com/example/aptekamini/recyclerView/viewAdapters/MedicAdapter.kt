package com.example.aptekamini.recyclerView.viewAdapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.aptekamini.R
import com.example.aptekamini.databinding.PatternMedicBinding
import com.example.aptekamini.recyclerView.models.MedicModel

class MedicAdapter: RecyclerView.Adapter<MedicAdapter.MedicHolder>() {
    val medicModelList = ArrayList<MedicModel>()
    class MedicHolder(item: View): RecyclerView.ViewHolder(item) {
        val binding = PatternMedicBinding.bind(item)
        fun bind(medicModel: MedicModel) = with(binding) {
            medicName.text = medicModel.name
            dozirovka.text = medicModel.dosage
            prise.text = null
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MedicHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.pattern_medic, parent, false)
        return MedicHolder(view)
    }

    override fun onBindViewHolder(holder: MedicHolder, position: Int) {
        holder.bind(medicModelList[position])
    }

    override fun getItemCount(): Int {
        return medicModelList.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun addMedic(medicModel: MedicModel) {
        medicModelList.add(medicModel)
        notifyDataSetChanged()
    }
}