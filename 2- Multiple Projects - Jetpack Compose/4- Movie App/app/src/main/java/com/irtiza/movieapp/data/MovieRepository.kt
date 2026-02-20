package com.irtiza.movieapp.data

import com.irtiza.movieapp.common.Resource
import com.irtiza.movieapp.model.Movie
import javax.inject.Inject

class MovieRepository @Inject constructor(private val dataSource: MovieDataSource) {
    suspend fun getMovieList(): Resource<List<Movie>> {
       return  try {
            Resource.Success(data = dataSource.getMovieList().results)
        }
        catch (e: Exception) {
            Resource.Error(message = e.message.toString())
        }
    }
}