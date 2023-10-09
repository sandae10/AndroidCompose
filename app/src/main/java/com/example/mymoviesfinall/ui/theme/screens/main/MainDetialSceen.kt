package com.example.mymoviesfinall.ui.theme.screens.main

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.example.mymoviesfinall.model.getMedia
import com.example.mymoviesfinall.ui.theme.MyMoviesApp
import com.example.mymoviesfinall.ui.theme.screens.details.DetailContent
import com.example.mymoviesfinall.ui.theme.screens.details.DetailScreen

@OptIn(ExperimentalMaterial3Api::class)
@RequiresApi(Build.VERSION_CODES.Q)
@Composable
fun MainDetailScreen() {
    var currentId by remember { mutableStateOf(1) }
    val mediaItem = getMedia().first{ it.id == currentId}

    MyMoviesApp {
        Scaffold(
            topBar = { MainAppBar() }
        ) { padding ->
            Row(
                modifier = Modifier.padding(padding)
            ) {
                Box(modifier = Modifier.weight(1f)) {
                    MainContent(
                        onNavigate = { currentId = it}
                            )
                }

                Box(modifier = Modifier.weight(2f)) {
                    DetailContent(
                        mediaItem = mediaItem
                    )
                }
            }
        }
    }
}