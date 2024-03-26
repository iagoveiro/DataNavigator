package com.example.analayzermobile.features.scrns

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Create
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.sharp.Add
import androidx.compose.material.icons.sharp.CheckCircle
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.analayzermobile.features.components.BottomMainBar


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(
    navigateToCurrencies: () -> Unit,
    navigateToTrips: () -> Unit,
    navigateToOptions: () -> Unit,
    navigateToExit: () -> Unit
) {
    Scaffold(
        modifier = Modifier.background(Color(0xFF121111)),
        bottomBar = {
            BottomMainBar()
        },
    ) { paddingValues ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFF121111))
                .padding(paddingValues), contentAlignment = Alignment.Center
        ) {
            MainScreenButtons(
                navigateToCurrencies,
                navigateToTrips,
                navigateToOptions,
                navigateToExit
            )

        }
    }
}


@Composable
fun ButtonOptions(icon: ImageVector, text: String, containerColor: Color, onClick: () -> Unit) {
    Button(
        onClick = onClick,
        modifier = Modifier.size(140.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = containerColor,
            contentColor = Color.White
        ),
        shape = RoundedCornerShape(20.dp)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Icon(
                imageVector = icon,
                contentDescription = null,
                tint = Color(0xFFCDE640),
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(text, color = Color(0xFFCDE640))
        }
    }
}


@Composable
fun MainScreenButtons(
    navigateToCurrencies: () -> Unit,
    navigateToTrips: () -> Unit,
    navigateToOptions: () -> Unit,
    navigateToExit: () -> Unit
) {

    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Row(horizontalArrangement = Arrangement.SpaceEvenly) {
            ButtonOptions(
                icon = Icons.Sharp.Add,
                text = "Currency",
                containerColor = Color(0xFF282727),
                onClick = { navigateToCurrencies() })
            Spacer(modifier = Modifier.size(25.dp))
            ButtonOptions(
                icon = Icons.Default.LocationOn,
                text = "Trips",
                containerColor = Color(0xFF282727),
                onClick = { navigateToTrips() })
        }
        Spacer(modifier = Modifier.size(25.dp))

        Row(horizontalArrangement = Arrangement.SpaceEvenly) {
            ButtonOptions(
                icon = Icons.Sharp.CheckCircle,
                text = "Visited",

                containerColor = Color(0xFF282727),
                onClick = { })
            Spacer(modifier = Modifier.size(25.dp))
            ButtonOptions(
                icon = Icons.Default.DateRange,
                text = "Date",
                containerColor = Color(0xFF282727),
                onClick = { })
        }
        Spacer(modifier = Modifier.size(25.dp))

        Row(horizontalArrangement = Arrangement.SpaceEvenly) {
            ButtonOptions(
                icon = Icons.Default.Person,
                text = "People",
                containerColor = Color(0xFF282727),
                onClick = { })
            Spacer(modifier = Modifier.size(25.dp))
            ButtonOptions(
                icon = Icons.Default.Create,
                text = "Create",
                containerColor = Color(0xFF282727),
                onClick = { })
        }
        Spacer(modifier = Modifier.size(25.dp))

        Row(horizontalArrangement = Arrangement.SpaceEvenly) {
            ButtonOptions(
                icon = Icons.Default.Settings,

                text = "Options",
                containerColor = Color(0xFF282727),
                onClick = { navigateToOptions() })
            Spacer(modifier = Modifier.size(25.dp))
            ButtonOptions(
                icon = Icons.Default.ExitToApp,
                text = "Exit",
                containerColor = Color(0xFF282727),
                onClick = { navigateToExit() })
        }
    }
}