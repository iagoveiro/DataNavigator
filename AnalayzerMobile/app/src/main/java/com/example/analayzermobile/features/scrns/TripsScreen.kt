package com.example.analayzermobile.features.scrns

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.analayzermobile.R
import com.example.analayzermobile.design.PlacesScreenViewModel
import com.example.analayzermobile.features.components.TopGenericBar

@Composable
fun TripsScreen(navigateToMain: () -> Unit) {
    PlacesToTravel(navigateToMain)
}


data class Place(
    val imageResourceId: Int,
    val name: String,
    val price: Int,
)

val destImages = listOf(
    Place(R.drawable.alsk, "Alaska", 600),
    Place(R.drawable.canc, "Cancún", 1218),
    Place(R.drawable.noruega, "Norway", 599),
    Place(R.drawable.carb, "Caribean", 1466),
    Place(R.drawable.brazil, "Brazil", 1254),
    Place(R.drawable.japan, "Japan", 1059)
)

@OptIn(ExperimentalMaterial3Api::class)




@Composable
@Preview
fun PlacesToTravel(navigateToMain: () -> Unit = {}) {
    val viewModel: PlacesScreenViewModel = viewModel()

    Scaffold(

    ) { it ->

        LazyColumn(
            contentPadding = it,
            modifier = Modifier
                .background(Color(0xFF121111))
                .fillMaxSize()
                .padding(top = 65.dp)
        ) {
            items(destImages.sortedBy { it.name }) {
                PlaceItem(
                    viewModel,
                    place = it,
                    modifier = Modifier
                        .padding(bottom = 16.dp, start = 8.dp, end = 8.dp)
                        .background(Color(0xFF121111)),
                )
            }

        }
        TopGenericBar(navigateToMain = navigateToMain, text = "Places to travel")
    }
}

@Composable
fun PlaceItem(
    viewModel: PlacesScreenViewModel,
    place: Place,
    modifier: Modifier = Modifier
) {
    val nombre = place.name
    Card(
        modifier = modifier.clickable { viewModel.cuandoClickeEnUnElemento(nombre) },
    ) {
        Row(
            modifier = Modifier.fillMaxWidth()
        ) {
            PlaceIcon(place.imageResourceId)
            PlaceInformation(place.name, place.price)
        }
    }
}


@Composable
fun PlaceIcon(
    @DrawableRes placeIcon: Int
) {
    Image(
        modifier = Modifier
            .size(dimensionResource(R.dimen.image_size))
            .padding(dimensionResource(R.dimen.padding_small))
            .clip(MaterialTheme.shapes.large),
        contentScale = ContentScale.Crop,
        painter = painterResource(placeIcon),

        contentDescription = null
    )
}


@Composable
fun PlaceInformation(
    placeName: String,
    placeCost: Int
) {
    Column() {
        Text(
            text = placeName,
            style = MaterialTheme.typography.displayMedium
        )
        Text(
            text = stringResource(R.string.price, placeCost),
            style = MaterialTheme.typography.bodyLarge
        )
    }
}
