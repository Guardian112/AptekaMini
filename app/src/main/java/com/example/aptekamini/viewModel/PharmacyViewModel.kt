package com.example.aptekamini.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.aptekamini.model.PharmacyEntity
import com.example.aptekamini.repository.Repository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class PharmacyViewModel(app: Application, private val repository: Repository): AndroidViewModel(app) {
    fun addPharmacy(pharmacyEntity: PharmacyEntity) =
        viewModelScope.launch(Dispatchers.IO) {
            repository.addPharmacy(pharmacyEntity)
        }

    fun updatePharmacy(pharmacyEntity: PharmacyEntity) =
        viewModelScope.launch(Dispatchers.IO) {
            repository.updatePharmacy(pharmacyEntity)
        }

    fun deletePharmacy(pharmacyEntity: PharmacyEntity) =
        viewModelScope.launch(Dispatchers.IO) {
            repository.deletePharmacy(pharmacyEntity)
        }

    fun getAllPharmacy() = repository.getAllPharmacy()

    fun searchPharmacy(query: String?) = repository.searchPharmacy(query)

    init {
        viewModelScope.launch(Dispatchers.IO){
            val pharmacyCount = repository.getAllPharmacy().value?.size
            if (pharmacyCount != 15) {
                addPharmacy(PharmacyEntity(name = "Алоэ", address = "Кострома, ул. Евгения Ермакова, 9", contactInformation = "8(4942)49-64-54", workSchedule = "с 09:00 до 21:00"))
                addPharmacy(PharmacyEntity(name = "Антей", address = "Кострома, Юбилейный мкрн, 3", contactInformation = "8(4942)34-93-26", workSchedule = "с 09:00 до 19:00"))
                addPharmacy(PharmacyEntity(name = "Здоровье", address = "Кострома, Петрковский бул., 3", contactInformation = "8(4942)42-03-70", workSchedule = "с 08:00 до 19:00"))
                addPharmacy(PharmacyEntity(name = "Не болей", address = "Кострома, ул. Центральная, 42", contactInformation = "8(4942)41-18-41", workSchedule = "с 08:00 до 21:00"))
                addPharmacy(PharmacyEntity(name = "100М", address = "Кострома, ул. Поселковая, 37", contactInformation = "8(4942)48-00-40", workSchedule = "с 09:00 до 21:00"))
                addPharmacy(PharmacyEntity(name = "Вита Экспресс", address = "Кострома, ул. Ткачей, 7г (ТЦ Галерея)", contactInformation = "8-800-755-00-03", workSchedule = "с 08:00 до 21:00"))
                addPharmacy(PharmacyEntity(name = "Губернская", address = "Кострома, ул. Сутырина, 15", contactInformation = "8(4942)55-49-61", workSchedule = "с 08:00 до 20:00"))
                addPharmacy(PharmacyEntity(name = "ЗАБОТА", address = "Кострома, ул. Советская, 130", contactInformation = "8(4942)64-14-28", workSchedule = "с 08:00 до 20:00"))
                addPharmacy(PharmacyEntity(name = "Здравсити", address = "Кострома, ул. Стопани, 31", contactInformation = "8(4942)34-55-11", workSchedule = "с 08:00 до 21:00"))
                addPharmacy(PharmacyEntity(name = "МИЛГА", address = "Кострома, Сусанинская площадь, Большие Мучные ряды, 19", contactInformation = "8(4942)36-02-63", workSchedule = "с 09:00 до 18:00"))
                addPharmacy(PharmacyEntity(name = "Столички", address = "Кострома, ул. Южная, 12", contactInformation = "8(4942)49-64-64", workSchedule = "с 08:00 до 21:00"))
                addPharmacy(PharmacyEntity(name = "Аптека+", address = "Кострома, ул. Юных пионеров, 39", contactInformation = "8(4942)50-00-16", workSchedule = "с 09:00 до 21:00"))
                addPharmacy(PharmacyEntity(name = "Будь здоров!", address = "Кострома, Сусанинская площадь, Большие Мучные ряды, 15", contactInformation = "8(4942)41-40-00", workSchedule = "с 08:00 до 20:00"))
                addPharmacy(PharmacyEntity(name = "Максавит", address = "Кострома, Черноречье мкрн, 15", contactInformation = "8-920-398-08-71", workSchedule = "с 08:00 до 21:00"))
                addPharmacy(PharmacyEntity(name = "Панацея", address = "Кострома, ул. Титова, 15", contactInformation = "с 08:00 до 20:00", workSchedule = "8-915-902-15-15"))
                addPharmacy(PharmacyEntity(name = "Планета здоровья", address = "Кострома, ул. Магистральная, 20", contactInformation = "8-800-755-05-00", workSchedule = "с 10:00 до 22:00"))
            }
        }
    }
}