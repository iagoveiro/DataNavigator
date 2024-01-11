package com.example.analayzermobile

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApp()

        }
    }
}
data class NavItemState(
    val title : String,
    val selectedIcon : ImageVector,
    val unselectedIcon : ImageVector,
    val hasBadge : Boolean,
    val badgeNum : Int
)

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyApp(modifier: Modifier = Modifier) {
    val items = listOf(
        NavItemState(
            title = "Home",
            selectedIcon = Icons.Filled.Home,
            unselectedIcon = Icons.Outlined.Home,
            hasBadge = false,
            badgeNum = 0
        ),
        NavItemState(
            title = "Trips",
            selectedIcon = Icons.Filled.Person,
            unselectedIcon = Icons.Outlined.Person,
            hasBadge = true,
            badgeNum = 0
        ),
        NavItemState(
            title = "Help",
            selectedIcon = Icons.Filled.Info,
            unselectedIcon = Icons.Outlined.Info,
            hasBadge = true,
            badgeNum = 0
        ),
    )
    var bottomNavState by rememberSaveable {
        mutableStateOf(0)
    }
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "TripAnalyzer") },
                modifier = modifier.then(Modifier.background(Color.Blue))
            )
        },
        bottomBar = {
            NavigationBar {
                items.forEachIndexed { index, item ->
                    NavigationBarItem(
                        selected = bottomNavState == index,
                        onClick = { bottomNavState = index },
                        icon = {
                            BadgedBox(badge ={
                                if (item.hasBadge)Badge{}
                                if(item.badgeNum!=0) Badge {
                                    Text(text = item.badgeNum.toString())
                                    
                                }
                            }) {
                                Icon(
                                    imageVector = if (bottomNavState == index) item.selectedIcon
                                    else item.unselectedIcon,
                                    contentDescription = item.title
                                )
                            }
                        })

                }
            }
        },
        floatingActionButton = {
            FloatingActionButton(onClick = { }) {
                Icon(imageVector = Icons.Filled.Add, contentDescription = "add" )
            }
        }
    ) { contentPadding ->

        Column(
            modifier = modifier.then(Modifier.padding(contentPadding))
        ) {
            Text(
                text = items[bottomNavState].title,
                fontWeight = FontWeight.ExtraBold,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 32.dp, start = 16.dp, end = 16.dp, bottom = 16.dp)
                    .background(Color.Gray),
                fontSize = 24.sp
            )

            // Imagen
            Image(
                painter = painterResource(id = R.drawable.ic_launcher_foreground),
                contentDescription = "Logo",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
                    .padding(16.dp)
                    .clip(shape = RoundedCornerShape(8.dp))
            )

            // Lista de elementos
            val itemList = listOf(
                "Currency-USD",
                "Currency-EUR",
                "Currrency-GBP",
                "Currrency-JPY",
                "Currrency-CHF",
                "Currrency-NZD",
                "Currrency-CAD",
                "Currrency-AUD")

            LazyColumn {
                items(itemList) { item ->
                    Text(
                        text = item,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp)
                            .background(Color.LightGray)
                    )
                }
            }
        }
    }
}





