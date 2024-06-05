package com.example.aptekamini.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.aptekamini.databinding.MedicLayoutBinding
import com.example.aptekamini.fragments.MainFragment
import com.example.aptekamini.fragments.MainFragmentDirections
import com.example.aptekamini.fragments.MedicListFragment
import com.example.aptekamini.fragments.MedicListFragmentDirections
import com.example.aptekamini.model.MedicEntity

/*
* Создание адаптера для заполнения списка данными из БД
*/
class MedicListAdapter: RecyclerView.Adapter<MedicListAdapter.MedicHolder>() {
    class MedicHolder(val itemBinding: MedicLayoutBinding): RecyclerView.ViewHolder(itemBinding.root)
/*
*   Сравнение элементов с модели с элементами из БД
*/
    private val differCallback = object : DiffUtil.ItemCallback<MedicEntity>() {
        override fun areItemsTheSame(oldItem: MedicEntity, newItem: MedicEntity): Boolean {
            return oldItem.id == newItem.id &&
                    oldItem.name == newItem.name &&
                    oldItem.dosage == newItem.dosage
        }

        override fun areContentsTheSame(oldItem: MedicEntity, newItem: MedicEntity): Boolean {
            return oldItem == newItem
        }
    }
    val differ = AsyncListDiffer(this, differCallback)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MedicHolder {
        return MedicHolder(
            MedicLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }
/*
*   Присвоение размера списка
*/
    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    override fun onBindViewHolder(holder: MedicHolder, position: Int) {
        val currentMedic = differ.currentList[position]

        holder.itemBinding.medicName.text = currentMedic.name
        holder.itemBinding.dozirovka.text = currentMedic.dosage

        holder.itemView.setOnClickListener{
            val direction = MedicListFragmentDirections.actionMedicListFragmentToMedicInfoFragment()
            it.findNavController().navigate(direction)
        }
    }
}