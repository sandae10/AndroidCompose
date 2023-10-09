package com.example.mymoviesfinall.ui.theme.screens.main

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SliderDefaults.Thumb
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import coil.annotation.ExperimentalCoilApi
import com.example.mymoviesfinall.R
import com.example.mymoviesfinall.model.MediaItem
import com.example.mymoviesfinall.model.getMedia
import com.example.mymoviesfinall.ui.theme.MyMoviesApp

@RequiresApi(Build.VERSION_CODES.Q)
@OptIn(ExperimentalCoilApi::class)
@Composable
fun MediaList(onMediaClick: (MediaItem) -> Unit , modifier: Modifier = Modifier, onClick: () -> Unit) {
    LazyVerticalGrid(
        columns = GridCells.Adaptive(dimensionResource(R.dimen.cell_min_wedith)),
        contentPadding = PaddingValues(dimensionResource(R.dimen.padding_xsmall)),
        modifier = modifier
    ) {
        items(getMedia()) {
            MediaListItem(
                mediaItem = it,
                onClick = { onMediaClick(it)} ,
                modifier = Modifier.padding(dimensionResource(R.dimen.padding_xsmall)),
            )
        }
    }
}

@RequiresApi(Build.VERSION_CODES.Q)
@OptIn(ExperimentalMaterial3Api::class)
@ExperimentalCoilApi
@Composable
fun MediaListItem(
    mediaItem: MediaItem,
    onClick : () -> Unit,
    modifier: Modifier = Modifier
)   {
    Card(

        modifier = modifier.clickable { onClick() },
        border = BorderStroke(1.dp, Color.Gray),

    ) {
        Column{
            com.example.mymoviesfinall.ui.theme.screens.common.
            Thumb(mediaItem)
            Title(mediaItem)
        }

    }


}




@Composable
private fun Title(mediaItem: MediaItem){
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxWidth()
            //.background(MaterialTheme.colorScheme.secondary)
            .padding(dimensionResource(R.dimen.padding_medium))
    ){
        Text(
            text = mediaItem.title,
            style = MaterialTheme.typography.bodyMedium
        )
    }
}


@RequiresApi(Build.VERSION_CODES.Q)
@Preview
@Composable
fun MediaListPreview() {
    MyMoviesApp {
        val mediaItem = MediaItem(1, "Item 1", "", MediaItem.Type.VIDEO)
                MediaListItem(mediaItem = mediaItem, onClick = {})
    }

}