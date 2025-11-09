package com.example.questnavigasitugas_041.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FormulirScreen(
    onSubmit: (TampilData) -> Unit,
    onKembali: () -> Unit
) {
    var namaLengkap by remember { mutableStateOf("") }
    var jenisKelamin by remember { mutableStateOf("") }
    var jabatan by remember { mutableStateOf("") }
    var departemen by remember { mutableStateOf("") }
    var status by remember { mutableStateOf("") }
    var showError by remember { mutableStateOf(false) }
    var showPopup by remember { mutableStateOf(false) }
    var expandedStatus by remember { mutableStateOf(false) }

    val statusOptions = listOf("Aktif", "Cuti", "Kontrak", "Resign")

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFE6E6E6))
            .padding(16.dp)
    ) {
        Column(
            modifier = Modifier
                .verticalScroll(rememberScrollState())
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Formulir Data Karyawan",
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                modifier = Modifier
                    .padding(top = 16.dp, bottom = 16.dp)
            )

            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 30.dp)
                    .shadow(
                        elevation = 10.dp,
                        shape = RoundedCornerShape(20.dp),
                    ),
                shape = RoundedCornerShape(20.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Color.White
                ),
                elevation = CardDefaults.cardElevation(defaultElevation = 0.dp)
            ) {
                Column(
                    modifier = Modifier
                        .padding(20.dp)
                ) {
                    if (showError) {
                        Card(
                            colors = CardDefaults.cardColors(
                                containerColor = Color(0xFFFFE6E6)),
                            shape = RoundedCornerShape(20.dp),
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(bottom = 12.dp)
                        ) {
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                modifier = Modifier
                                    .padding(12.dp)
                            ) {
                                Spacer(modifier = Modifier
                                    .width(8.dp))
                                Text(
                                    text = "Data tidak boleh kosong !",
                                    color = Color.Red,
                                    fontSize = 16.sp,
                                    fontWeight = FontWeight.Bold
                                )
                            }
                        }
                    }

                    InputField(
                        "Nama Lengkap",
                        namaLengkap
                    ) {
                        namaLengkap = it; showError = false }
                    GenderField(
                        jenisKelamin
                    ) {
                        jenisKelamin = it;
                        showError = false }
                    InputField(
                        "Jabatan",
                        jabatan
                    ) {
                        jabatan = it;
                        showError = false }
                    InputField(
                        "Departemen",
                        departemen
                    ) {
                        departemen = it;
                        showError = false }

                    Text(
                        "Status",
                        fontSize = 12.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = Color.DarkGray
                    )
                    ExposedDropdownMenuBox(
                        expanded = expandedStatus,
                        onExpandedChange = { expandedStatus = !expandedStatus },
                        modifier = Modifier
                            .padding(bottom = 24.dp)
                    ) {
                        OutlinedTextField(
                            value = status,
                            onValueChange = {},
                            readOnly = true,
                            placeholder = { Text("Pilih status karyawan") },
                            trailingIcon = {
                                ExposedDropdownMenuDefaults.TrailingIcon(expanded = expandedStatus)
                            },
                            modifier = Modifier
                                .fillMaxWidth()
                                .menuAnchor()
                        )
                        ExposedDropdownMenu(
                            expanded = expandedStatus,
                            onDismissRequest = { expandedStatus = false }
                        ) {
                            statusOptions
                                .forEach { option ->
                                DropdownMenuItem(
                                    text = { Text(option) },
                                    onClick = {
                                        status = option
                                        expandedStatus = false
                                        showError = false
                                    }
                                )
                            }
                        }
                    }

                    Row(
                        modifier = Modifier
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(12.dp)
                    ) {
                        OutlinedButton(
                            onClick = {
                                onKembali() },
                            modifier = Modifier
                                .weight(1f)
                        ) {
                            Text(
                                "Kembali")
                        }

                        Button(
                            onClick = {
                                if (namaLengkap.isEmpty() || jenisKelamin.isEmpty() ||
                                    jabatan.isEmpty() || departemen.isEmpty() || status.isEmpty()
                                ) {
                                    showError = true
                                } else {
                                    onSubmit(
                                        TampilData(
                                            namaLengkap,
                                            jenisKelamin,
                                            jabatan,
                                            departemen,
                                            status
                                        )
                                    )
                                    showPopup = true
                                }
                            },
                            modifier = Modifier
                                .weight(1f),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Color.Black)
                        ) {
                            Text(
                                "Submit",
                                color = Color.White)
                        }
                    }
                }
            }
        }

        if (showPopup) {
            Dialog(onDismissRequest = {}) {
                Card(
                    shape = RoundedCornerShape(16.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = Color.White)
                ) {
                    Column(
                        modifier = Modifier
                        .padding(24.dp)) {
                        Text(
                            text = "Data karyawan berhasil disimpan!",
                            fontSize = 16.sp,
                            fontWeight = FontWeight.SemiBold,
                            color = Color.Black,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(bottom = 16.dp),
                            textAlign = TextAlign.Center
                        )
                        Text(
                            "Nama: $namaLengkap",
                            fontSize = 12.sp)
                        Text(
                            "Jenis Kelamin: $jenisKelamin",
                            fontSize = 12.sp)
                        Text(
                            "Jabatan: $jabatan",
                            fontSize = 12.sp)
                        Text(
                            "Departemen: $departemen",
                            fontSize = 12.sp)
                        Text(
                            "Status: $status",
                            fontSize = 12.sp,
                            modifier = Modifier
                                .padding(bottom = 16.dp))


