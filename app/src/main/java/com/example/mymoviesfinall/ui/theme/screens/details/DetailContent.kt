package com.example.mymoviesfinall.ui.theme.screens.details

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.mymoviesfinall.model.MediaItem
import com.example.mymoviesfinall.ui.theme.screens.common.Thumb

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailContent(mediaItem: MediaItem, modifier: Modifier = Modifier) {

    Thumb(mediaItem = mediaItem)

}