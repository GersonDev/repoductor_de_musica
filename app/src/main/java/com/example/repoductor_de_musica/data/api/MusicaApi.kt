package com.example.repoductor_de_musica.data.api

import retrofit2.http.*

interface MusicaApi {
    @GET("musicas")
    suspend fun getBrands(): List<GetMusicaResponse>

    @POST("musicas")
    suspend fun createBrand(
        @Body brandRequest: MusicaRequest
    ): PostMusicaResponse

    @PUT
    suspend fun updateBrand()

    @DELETE
    suspend fun deleteBrand()
}