package com.example.analayzermobile.features.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.analayzermobile.R

@Composable
fun CurrenciesScreen(navigateToMain: () -> Unit) {
    AllCurrencies(navigateToMain)
}

data class Currencies(
    val imageResourceId: Int,
    val name: String,
    val value: Double = 0.0
)

val currencyList = listOf(
    Currencies(R.drawable.bandusa, "USD", 1.0),
    Currencies(R.drawable.bandeuro, "EUR"),
    Currencies(R.drawable.banduk, "GBP"),
    Currencies(R.drawable.bandjap, "JPY"),
    Currencies(R.drawable.bandsuiza, "CHF"),
    Currencies(R.drawable.bandnzd, "NZD"),
    Currencies(R.drawable.bandcanada, "CAD"),
    Currencies(R.drawable.bandaud, "AUD"),
    Currencies(R.drawable.bandeuro, "UNO"),
    Currencies(R.drawable.bandeuro, "DOS"),
    Currencies(R.drawable.bandeuro, "TRE")
)


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AllCurrencies(navigateToMain: () -> Unit
) {
    val sortedCurrencyList = currencyList.sortedBy { it.name }


    Scaffold(
        modifier = Modifier
            .fillMaxSize(),
        containerColor = Color(0xFF121111)
    ) { scaffoldPadding ->

        LazyColumn(contentPadding = scaffoldPadding, modifier = Modifier.padding(top =  55.dp)) {
            itemsIndexed(sortedCurrencyList) { index, item ->
                val backgroundColor = if (index % 2 == 0) {
                    Color(0xFF282727)
                } else {
                    Color(0xFF1A1919)
                }
                Row(
                    modifier = Modifier
                        .background(backgroundColor)
                        .fillMaxSize()
                        .padding(10.dp)
                        .height(50.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    Image(
                        painter = painterResource(id = item.imageResourceId),
                        contentDescription = null,
                        modifier = Modifier.size(20.dp)
                    )
                    Spacer(modifier = Modifier.size(10.dp))
                    Text(
                        text = item.name,
                        color = Color(0xFFCDE640),
                        modifier = Modifier.clickable { /* Acción al hacer clic */ },
                        fontSize = 18.sp,
                    )
                    Spacer(modifier = Modifier.width(265.dp))

                    Text(
                        text = item.value.toString(),
                        color = Color(0xFFCDE640),
                        modifier = Modifier,
                        textAlign = TextAlign.End,
                    )
                }
            }
        }
    }
    TopAppBar(modifier = Modifier,
        title = {
            Text(
                text = "Currencies",
                color = Color(0xFFCDE640),
                modifier = Modifier
            )
        },
        navigationIcon = {
            IconButton(onClick = {navigateToMain()}) {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = "Currencies",
                    modifier = Modifier.background(Color(0xFF121111)),
                    Color(0xFFCDE640)
                )
            }
        }
    )

}
