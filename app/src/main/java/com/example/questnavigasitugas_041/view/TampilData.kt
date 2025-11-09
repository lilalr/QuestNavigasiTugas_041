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


