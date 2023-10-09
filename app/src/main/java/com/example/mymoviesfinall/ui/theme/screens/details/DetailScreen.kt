package com.example.mymoviesfinall.ui.theme.screens.details

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.example.mymoviesfinall.model.getMedia
import com.example.mymoviesfinall.ui.theme.screens.common.ArrowBackIcon
import com.example.mymoviesfinall.ui.theme.screens.common.Thumb

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailScreen(mediaId : Int, onUpClick:() -> Unit) {
    val mediaItem = remember { getMedia().first{it.id == mediaId}}

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = mediaItem.title) },
                navigationIcon = { ArrowBackIcon(onUpClick)
                }
            )
        }
    ) {padding ->
        DetailContent(
            mediaItem = mediaItem,
            modifier = Modifier.padding(padding)
        )
    }

}

