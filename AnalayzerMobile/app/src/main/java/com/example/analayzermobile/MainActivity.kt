package com.example.analayzermobile

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.Navigation
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.analayzermobile.design.LoginViewModel
import com.example.analayzermobile.features.components.SideBarApp
import com.example.analayzermobile.features.scrns.MainScreen
import com.example.analayzermobile.features.scrns.CurrenciesScreen
import com.example.analayzermobile.features.scrns.LoginScreen
import com.example.analayzermobile.features.scrns.SettingsScreen
import com.example.analayzermobile.features.scrns.TripsScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
public class MainActivity : ComponentActivity() {

    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            SideBarApp()
            Scaffold(

            ) { paddingValues ->
                Box(modifier = Modifier.padding(paddingValues)) {
                    NavHost(navController = navController, startDestination = "Login") {
                        composable("Login") {
                            LoginScreen(
                                LoginViewModel(),
                                navigateToMain = { navController.navigate("Main") })
                        }
                        composable("Main") {
                            MainScreen(navigateToCurrencies = { navController.navigate("Currencies") },
                                navigateToTrips = { navController.navigate("Trips") },
                                navigateToOptions = { navController.navigate("Options") },
                                navigateToExit = { navController.navigate("Login") })
                        }
                        composable("Currencies") {
                            CurrenciesScreen { navController.navigate("Main") }
                        }
                        composable("Trips") {
                            TripsScreen(navigateToMain = { navController.navigate("Main") })
                        }
                        composable("Options") {
                            SettingsScreen(navigateToMain = { navController.navigate("Main") })
                        }


                    }
                }
            }
        }
    }
}