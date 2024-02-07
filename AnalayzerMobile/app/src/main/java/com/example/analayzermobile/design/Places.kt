package com.example.analayzermobile.design

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.analayzermobile.R

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
fun PlacesToTravel() {
    val viewModel: PlacesScreenViewModel = viewModel()

    Scaffold(
        topBar = {
            PlacesTopAppBar(viewModel)
        }
    ) { it ->
        LazyColumn(contentPadding = it) {
            items(destImages.sortedBy { it.name }) {
                PlaceItem(
                    viewModel,
                    place = it,
                    modifier = Modifier.padding( end = 16.dp, bottom = 16.dp),
                )
            }
        }
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
        modifier = modifier.clickable { viewModel.cuandoClickeEnUnElemento(nombre) }
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(dimensionResource(R.dimen.padding_small))
        ) {
            PlaceIcon(place.imageResourceId)
            PlaceInformation(place.name, place.price)
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PlacesTopAppBar(viewModel: PlacesScreenViewModel,modifier: Modifier = Modifier) {
    val tituloState = viewModel.titulo.collectAsState()

    CenterAlignedTopAppBar(
        title = {
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalAlignment = Alignment.Top
            ) {
                Text(
                    text = tituloState.value,
                    style = MaterialTheme.typography.displayMedium
                )
            }
        },
        modifier = modifier
            .fillMaxWidth()
            .padding(top = 0.dp)
    )
}

@Composable
fun PlaceIcon(
    @DrawableRes placeIcon: Int,
    modifier: Modifier = Modifier
) {
    Image(
        modifier = modifier
            .size(dimensionResource(R.dimen.image_size))
            .padding(dimensionResource(R.dimen.padding_small))
            .clip(MaterialTheme.shapes.small),
        contentScale = ContentScale.Crop,
        painter = painterResource(placeIcon),

        contentDescription = null
    )
}


@Composable
fun PlaceInformation(
    placeName: String,
    placeCost: Int,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        Text(
            text = placeName,
            style = MaterialTheme.typography.displayMedium,
            modifier = Modifier.padding(top = dimensionResource(R.dimen.padding_small))
        )
        Text(
            text = stringResource(R.string.price, placeCost),
            style = MaterialTheme.typography.bodyLarge
        )
    }
}
