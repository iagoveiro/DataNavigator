package com.example.analayzermobile.features.components

import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.outlined.DateRange
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material.icons.rounded.DateRange
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.analayzermobile.design.PlacesToTravel
import com.example.analayzermobile.features.screens.AllCurrencies

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
fun NavItemBottomBar(modifier: Modifier = Modifier) {

    val items = listOf(
        NavItemState(
            title = "Home / Currencies",
            selectedIcon = Icons.Filled.Home,
            unselectedIcon = Icons.Outlined.Home,
            hasBadge = false,
            badgeNum = 0
        ),
        NavItemState(
            title = "Trips",
            selectedIcon = Icons.Rounded.DateRange,
            unselectedIcon = Icons.Outlined.DateRange,
            hasBadge = false,
            badgeNum = 0
        ),
        NavItemState(
            title = "Help",
            selectedIcon = Icons.Filled.Info,
            unselectedIcon = Icons.Outlined.Info,
            hasBadge = false,
            badgeNum = 0
        ),
    )


    var bottomNavState by rememberSaveable {
        mutableStateOf(0)
    }
    Scaffold(
        modifier = modifier,
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
            if (bottomNavState == 1) {
                FloatingActionButton(onClick = { }) {
                    Icon(imageVector = Icons.Filled.Add, contentDescription = "add" )
                }
            }
        }
    ) { contentPadding ->

        /*
        Esta columna y su contenido es referente al nombre de cada NavItem(Home/Trips/help),
        también se modifica el Text y la Column que lo contiene
        */
        Column(
            modifier = modifier.then(Modifier.padding(contentPadding))
        ) {
            Text(
                text = items[bottomNavState].title,
                fontWeight = FontWeight.ExtraBold,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 18.dp, start = 8.dp),
                fontSize = 28.sp
            )

            Column(
                modifier = modifier.then(Modifier.padding(top = 18.dp))
            ) {
                // Importa como Column los elementos de imágenes como botones
                when (bottomNavState) {
                    1 -> {
                        PlacesToTravel()
                    }
                }

                // Lista de monedas mostradas en columna
                when (bottomNavState) {
                    0 ->
                    AllCurrencies(navigateToMain = {})
                }
            }
        }
    }
}
