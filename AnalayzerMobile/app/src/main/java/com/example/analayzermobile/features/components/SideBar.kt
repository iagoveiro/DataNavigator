package com.example.analayzermobile.features.components

import android.annotation.SuppressLint
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Create
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Preview()
@Composable
fun SideBarApp() {
    var isExpanded by remember {
        mutableStateOf(false)
    }

    Scaffold() {
        Box() {
            Column(
                Modifier.fillMaxSize(),
                Arrangement.Center,
                Alignment.CenterHorizontally
            ) {
                Text(text = "Home Page")
            }
            Column(
                Modifier
                    .fillMaxHeight()
                    .width(if (isExpanded) 160.dp else 60.dp)
                    .background(Color(0xFF282727))
                    .padding(horizontal = 20.dp, vertical = 10.dp),
                horizontalAlignment = Alignment.Start
            ) {
                Icon(
                    Icons.Default.Menu,
                    modifier = Modifier.clickable {
                        isExpanded = !isExpanded
                    },
                    contentDescription = null,
                    tint = Color(0xFFD7D5D5)
                )

                Spacer(modifier = Modifier.height((30.dp)))
                SideBarItem(Icons.Default.CheckCircle, "Currencies", isExpanded)
                SideBarItem(Icons.Default.Person, "Profile", isExpanded)
                SideBarItem(Icons.Default.Create, "Notes", isExpanded)
                SideBarItem(Icons.Default.Info, "About", isExpanded)
                SideBarItem(Icons.Default.Share, "Share", isExpanded)
                SideBarItem(Icons.Default.Settings, "Settings", isExpanded)
            }
        }
    }
}


@OptIn(ExperimentalAnimationApi::class)
@Composable
fun SideBarItem(icon: ImageVector, title: String, expanded: Boolean) {
    Row(
        Modifier
            .fillMaxWidth()
            .padding(vertical = 5.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        if (!expanded) {
            Icon(icon, contentDescription = null, tint = Color(0xFFD7D5D5))
        } else {
            Icon(icon, contentDescription = null, tint = Color(0xFFCDE640))
            Spacer(Modifier.width(8.dp))
            Text(
                text = title,
                color = Color(0xFFCDE640),
                fontSize = 16.sp,
                modifier = Modifier.padding(vertical = 8.dp)
            )
        }
    }
}

