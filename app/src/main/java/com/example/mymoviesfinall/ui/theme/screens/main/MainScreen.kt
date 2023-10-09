package com.example.mymoviesfinall.ui.theme.screens.main

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.example.mymoviesfinall.model.MediaItem
import com.example.mymoviesfinall.ui.theme.MyMoviesApp

@RequiresApi(Build.VERSION_CODES.Q)
@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun MainScreen(onNavigate : (Int) -> Unit) {
    MyMoviesApp {
        Scaffold(
            topBar = { MainAppBar() }
        ) { padding ->
            MainContent(onNavigate = onNavigate, Modifier.padding(padding))
        }
    }
}