package com.irtiza.movieapp.di

import com.irtiza.movieapp.data.MovieDataSource
import com.irtiza.movieapp.data.MovieRepository
import com.irtiza.movieapp.network.ApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@InstallIn(SingletonComponent::class)
@Module
object AppModule {

    @Provides
    fun providesRetrofit(): Retrofit = Retrofit.Builder().baseUrl("https://api.themoviedb.org/")
        .addConverterFactory(GsonConverterFactory.create()).build()

    @Provides
    fun providesApiService(retrofit: Retrofit) : ApiService  = retrofit.create(ApiService::class.java)

    @Provides
    fun provideDataSource(apiService: ApiService) : MovieDataSource = MovieDataSource(apiService)

    @Provides
    fun provideRepository(dataSource: MovieDataSource) : MovieRepository = MovieRepository(dataSource)
}