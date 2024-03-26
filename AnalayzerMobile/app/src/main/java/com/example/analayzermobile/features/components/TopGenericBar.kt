package com.example.analayzermobile.features.components

import androidx.compose.foundation.background
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.surfaceColorAtElevation
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopGenericBar(navigateToMain: () -> Unit, text: String = "") {
    Color(0xFF121111)
    TopAppBar(
        title = {
            Text(
                text = text,
                color = Color(0xFFCDE640),
                modifier = Modifier
            )
        },
        navigationIcon = {
            IconButton(onClick = { navigateToMain() }) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                    contentDescription = text,
                    modifier = Modifier.background(Color.Transparent),
                    Color(0xFFCDE640)
                )
            }
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Color(
                0xFF121111
            ),

            )
    )
}

