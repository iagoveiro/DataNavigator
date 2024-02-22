package com.example.analayzermobile.features.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Email
import androidx.compose.material.icons.rounded.Favorite
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Preview
@Composable
fun BottomMainBar(

    ) {
    BottomAppBar(
        modifier = Modifier.height(60.dp).fillMaxWidth(),
        containerColor = Color(0xFF282727)
        ) {
        Row(
            modifier = Modifier
                .height(80.dp)
                .fillMaxSize()
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            IconButton(
                onClick = {}, modifier = Modifier.size(48.dp)
            ) {
                Icon(
                    imageVector = Icons.Rounded.Home,
                    contentDescription = "Main",
                    tint = Color(0xFFCDE640)
                )
            }
            IconButton(
                onClick = {}, modifier = Modifier.size(48.dp)
            ) {
                Icon(
                    imageVector = Icons.Rounded.Favorite,
                    contentDescription = "Trips",
                    tint = Color(0xFFCDE640)
                )
            }
            IconButton(
                onClick = {}, modifier = Modifier.size(48.dp)
            ) {
                Icon(
                    imageVector = Icons.Rounded.Email,
                    contentDescription = "Notifications",
                    tint = Color(0xFFCDE640)
                )
            }
        }
    }
}