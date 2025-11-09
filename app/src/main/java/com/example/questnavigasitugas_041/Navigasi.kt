package com.example.questnavigasitugas_041

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

enum class HalamanApp {
    Welcome,
    List,
    Formulir
}

@Composable
fun NavigasiApp(
    navController: NavHostController = rememberNavController(),
    viewModel: com.example.questnavigasitugas_041.view.PesertaViewModel = viewModel()
) {
    val listPeserta by viewModel.listPeserta.collectAsState()

    NavHost(
        navController = navController,
        startDestination = HalamanApp.Welcome.name
    ) {
        composable(HalamanApp.Welcome.name) {
            com.example.questnavigasitugas_041.view.WelcomeScreen(
                onMasukClick = {
                    navController.navigate(HalamanApp.List.name)
                }
            )
        }

        composable(HalamanApp.List.name) {
            com.example.questnavigasitugas_041.view.ListScreen(
                listPeserta = listPeserta,
                onNavigateToForm = {
                    navController.navigate(HalamanApp.Formulir.name)
                },
                onNavigateToHome = {
                    navController.popBackStack(
                        HalamanApp.Welcome.name,
                        inclusive = false
                    )
                }
            )
        }

        composable(HalamanApp.Formulir.name) {
            com.example.questnavigasitugas_041.view.FormulirScreen(
                onSubmit = { data ->
                    viewModel.addPeserta(data)
                },
                onKembali = {
                    navController.navigate(HalamanApp.List.name)
                }
            )
        }
    }
}

