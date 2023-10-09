package com.example.mymoviesfinall.model

import com.example.mymoviesfinall.model.MediaItem.*

data class MediaItem(
    val id: Int,
    val title: String,
    val thumb: String,
    val type : Type
) {
    enum class Type {PHOTO, VIDEO}
}

fun getMedia() = (1..10).map {
    MediaItem(
        id = it,
        title = "Title $it",
        thumb = "https://loremflickr.com/320/240/$it",
        type = if (it % 3 == 0) Type.VIDEO  else Type.PHOTO

    )
}
