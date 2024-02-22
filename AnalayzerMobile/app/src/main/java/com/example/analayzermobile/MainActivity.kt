package com.example.analayzermobile

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.analayzermobile.features.screens.MainScreen
import com.example.analayzermobile.features.screens.SettingsScreen
import com.example.analayzermobile.features.screens.TripsScreen


public class MainActivity : ComponentActivity() {

    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            Scaffold(

            ) { paddingValues ->
                Box(modifier = Modifier.padding(paddingValues)) {
                    NavHost(navController = navController, startDestination = "Main") {
                        composable("Login") {
                            //LoginScreen(LoginViewModel())
                        }
                        composable("Main") {
                            MainScreen(navigateToCurrencies = { navController.navigate("Currencies") },
                                navigateToTrips = { navController.navigate("Trips") },
                                navigateToOptions ={ navController.navigate("Options") })
                        }
                        composable("Currencies") {
                            //CurrenciesScreen { navController.navigate("Main") }
                        }
                        composable("Trips") {
                            TripsScreen()
                        }
                        composable("Options") {
                            SettingsScreen()
                        }

                    }
                }
            }
        }
    }
}



