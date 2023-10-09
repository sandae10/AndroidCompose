package com.example.mymoviesfinall.ui.theme.screens.main

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

♠@RequiresApi(Build.VERSION_CODES.Q)
@Composable
fun MainContent(onNavigate: (Int) -> Unit, modifier: Modifier = Modifier) {
    MediaList(
        onClick = { onNavigate(it.id) },
        modifier = modifier
    )

}