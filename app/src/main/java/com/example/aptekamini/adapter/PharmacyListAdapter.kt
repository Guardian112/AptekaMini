package com.example.aptekamini.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.aptekamini.databinding.PharmacyLayoutBinding
import com.example.aptekamini.fragments.PharmacyListFragmentDirections
import com.example.aptekamini.model.PharmacyEntity

/*
* Создание адаптера для заполнения списка данными из БД
*/
class PharmacyListAdapter: RecyclerView.Adapter<PharmacyListAdapter.PharmacyHolder>()  {
    class PharmacyHolder(val itemBinding: PharmacyLayoutBinding): RecyclerView.ViewHolder(itemBinding.root)

/*
*   Сравнение элементов с модели с элементами из БД
*/

    private val differCallback = object : DiffUtil.ItemCallback<PharmacyEntity>() {
        override fun areItemsTheSame(oldItem: PharmacyEntity, newItem: PharmacyEntity): Boolean {
            return oldItem.id == newItem.id &&
                    oldItem.name == newItem.name &&
                    oldItem.address == newItem.address &&
                    oldItem.workSchedule == newItem.workSchedule &&
                    oldItem.contactInformation == newItem.contactInformation
        }

        override fun areContentsTheSame(oldItem: PharmacyEntity, newItem: PharmacyEntity): Boolean {
            return oldItem == newItem
        }
    }
    val differ = AsyncListDiffer(this, differCallback)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PharmacyListAdapter.PharmacyHolder {
        return PharmacyListAdapter.PharmacyHolder(
            PharmacyLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

/*
*   Присвоение размера списка
*/

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    override fun onBindViewHolder(holder: PharmacyListAdapter.PharmacyHolder, position: Int) {
        val currentPharmacy = differ.currentList[position]

        holder.itemBinding.pharmacyName.text = currentPharmacy.name
        holder.itemBinding.adress.text = currentPharmacy.address
        holder.itemBinding.time.text = currentPharmacy.workSchedule
        holder.itemBinding.phone.text = currentPharmacy.contactInformation

        holder.itemView.setOnClickListener{
            val direction = PharmacyListFragmentDirections.actionPharmacyListFragmentToPharmacyInfoFragment(currentPharmacy)
            it.findNavController().navigate(direction)
        }
    }
}