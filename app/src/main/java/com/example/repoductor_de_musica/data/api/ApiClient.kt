package com.example.repoductor_de_musica.data.api

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {

    fun getClient(): MusicaApi {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        val client = OkHttpClient.Builder().addInterceptor(interceptor).build()
        return Retrofit.Builder()
            .baseUrl("http://192.168.0.112:3006/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
            .create(MusicaApi::class.java)
    }
}
