package com.irtiza.movieapp.ui_layer

import com.irtiza.movieapp.model.Movie

data class MovieStateHolder(
    val isLoading: Boolean = false,
    val data: List<Movie>? = null,
    val error: String = ""
    )
