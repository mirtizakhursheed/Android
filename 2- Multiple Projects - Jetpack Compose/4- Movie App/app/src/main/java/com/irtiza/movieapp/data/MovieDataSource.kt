package com.irtiza.movieapp.data

import com.irtiza.movieapp.network.ApiService

class MovieDataSource(private val apiService: ApiService) {

    suspend fun getMovieList() = apiService.getMovieList(apiKey = "")
}