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


