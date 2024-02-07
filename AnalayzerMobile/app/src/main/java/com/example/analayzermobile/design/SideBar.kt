package com.example.analayzermobile.design

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Preview(device = Devices.NEXUS_5)
@Composable
fun SideBarApp(){
    
    Scaffold (){
        
        Box(){
            
            Column(
                Modifier.fillMaxSize(),
                Arrangement.Center,
                Alignment.CenterHorizontally
            ){
                Text(text = "Home Page")
            }
            Column(
                Modifier
                    .fillMaxHeight()
                    .width(50.dp)
                    .background(Color.LightGray)) {
                Icon(Icons.Default.Menu, contentDescription = null, tint = Color.White)
                Spacer(modifier = Modifier.height((20.dp))
                )
                Row(
                    Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ){
                    Icon(imageVector = Icons.Default.Person,contentDescription = null,tint = Color.White
                    )
                    Spacer(Modifier.height(10.dp))
                    Text(text = "Profile", color = Color.Black)
                }

            }
        }
    }
}