package com.irtiza.movieapp.ui_layer

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import coil.compose.AsyncImage
import com.irtiza.movieapp.model.Movie

@Composable
fun MovieListScreen(viewModel: MovieViewModel = hiltViewModel()) {
    val result = viewModel.movieList.value

    if(result.isLoading) {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            CircularProgressIndicator()
        }
    }

    if(result.error.isNotBlank()) {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {

            Text(text = result.error, style = MaterialTheme.typography.headlineMedium)
        }
    }

    result.data?.let {
        LazyColumn {
            items(result.data) { data ->
               MovieItem(data)
            }
        }
    }
}

@Composable
fun MovieItem(movie: Movie) {
    AsyncImage(model = "https://image.tmbd.org/t/p/w500/${movie.poster_path}",  contentDescription = null,
        modifier = Modifier.fillMaxWidth().height(200.dp))
}