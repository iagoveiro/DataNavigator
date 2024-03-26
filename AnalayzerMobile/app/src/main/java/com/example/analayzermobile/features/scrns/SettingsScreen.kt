package com.example.analayzermobile.features.scrns

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.example.analayzermobile.features.components.TopGenericBar

@Composable
fun SettingsScreen(navigateToMain: () -> Unit) {
    TopGenericBar(navigateToMain = { navigateToMain() })
    Text("Settings Screen")
}