package com.example.questnavigasitugas_041.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Description
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.questnavigasitugas_041.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DashboardScreen(
    listPeserta: List<TampilData>,
    onNavigateToForm: () -> Unit,
    onNavigateToHome: () -> Unit
) {
    ListScreen(
        listPeserta = listPeserta,
        onNavigateToForm = onNavigateToForm,
        onNavigateToHome = onNavigateToHome
    )
}

@Composable
fun WelcomeScreen(onMasukClick: () -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(10.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Selamat Datang!",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                modifier = Modifier.padding(bottom = 8.dp)
            )

            Text(
                text = "Aplikasi Formulir Pendaftaran",
                fontSize = 20.sp,
                color = Color.Black,
                modifier = Modifier.padding(bottom = 8.dp)
            )

            Image(
                painter = painterResource(id = R.drawable.employe),
                contentDescription = "Logo Employee",
                modifier = Modifier
                    .size(355.dp)
                    .padding(vertical = 10.dp)
            )

            Text(
                "Lailatul Ramadhani",
                fontSize = 13.sp,
                color = Color.DarkGray)

            Text(
                "20230140041",
                fontSize = 12.sp,
                color = Color.DarkGray,
                modifier = Modifier.padding(bottom = 30.dp))

            Button(
                onClick = onMasukClick,
                colors = ButtonDefaults.buttonColors(containerColor = Color.Black),
                shape = CircleShape,
                modifier = Modifier
                    .width(180.dp)
                    .height(48.dp)
            ) {
                Text(
                    "Masuk",
                    fontSize = 15.sp,
                    color = Color.White,
                    fontWeight = FontWeight.Medium)
            }
        }
    }
}




