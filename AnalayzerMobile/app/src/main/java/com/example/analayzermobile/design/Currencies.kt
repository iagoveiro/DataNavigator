package com.example.analayzermobile.design

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.analayzermobile.R
import androidx.compose.runtime.Composable

val currencyList = listOf(
    "USD",
    "EUR",
    "GBP",
    "JPY",
    "CHF",
    "NZD",
    "CAD",
    "AUD",
    "UNO",
    "DOS",
    "TRE")

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AllCurrencies() {
    Scaffold { scaffoldPadding ->
        LazyColumn(contentPadding = scaffoldPadding) {
            itemsIndexed(currencyList.sorted()) { index, item ->
                val backgroundColor = if (index % 2 == 0) {
                    Color.LightGray
                } else {
                    Color.Yellow
                }
                Text(
                    text = item,
                    modifier = Modifier
                        .background(backgroundColor)
                        .fillMaxWidth()
                        .padding(10.dp)
                        .clickable { },
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}
