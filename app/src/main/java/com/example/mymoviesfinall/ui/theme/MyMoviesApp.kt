package com.example.mymoviesfinall.ui.theme

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.mymoviesfinall.ui.theme.theme1.MyMoviesFinallTheme

@Composable
fun MyMoviesApp(content: @Composable () -> Unit) {
    MyMoviesFinallTheme {
        // A surface container using the 'background' color from the theme
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background){
        }

    }
}