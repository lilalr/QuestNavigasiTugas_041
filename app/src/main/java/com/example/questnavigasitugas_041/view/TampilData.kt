package com.example.questnavigasitugas_041.view

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

data class TampilData(
    val namaLengkap: String = "",
    val jenisKelamin: String = "",
    val jabatan: String = "",
    val departemen: String = "",
    val status: String = ""
)

class PesertaViewModel : ViewModel() {

    private val _listPeserta = MutableStateFlow(
        listOf(
            TampilData(
                namaLengkap = "Gita Anggraini",
                jenisKelamin = "Perempuan",
                jabatan = "Staff HRD",
                departemen = "Human Resource",
                status = "Aktif"
            ),
            TampilData(
                namaLengkap = "Farhan Yusuf",
                jenisKelamin = "Laki-Laki",
                jabatan = "Supervisor Produksi",
                departemen = "Produksi",
                status = "Cuti"
            ),
            TampilData(
                namaLengkap = "Citra Lestari",
                jenisKelamin = "Perempuan",
                jabatan = "Manager Keuangan",
                departemen = "Finance",
                status = "Aktif"
            ),
            TampilData(
                namaLengkap = "Hari Wijaya",
                jenisKelamin = "Laki-Laki",
                jabatan = "Staff IT Support",
                departemen = "Teknologi Informasi",
                status = "Kontrak"
            )
        )
    )

    val listPeserta: StateFlow<List<TampilData>> = _listPeserta.asStateFlow()

    fun addPeserta(data: TampilData) {
        _listPeserta.value = _listPeserta.value + data
    }
}
