package com.example.repoductor_de_musica.data.datasources

import com.example.repoductor_de_musica.data.api.ApiClient
import com.example.repoductor_de_musica.domain.models.Musica

class RemoteDataSource {

    suspend fun getUsersFromRemote(): List<Musica> {
        val musicaResponse = ApiClient.getClient().getMusicas()
        val musicas = musicaResponse.map {
            Musica(
                id = it.id,
                title = it.title,
                subtitulo = it.subtitulo,
                image_url = it.image_url,
                love = it.love,
                musica_url = it.musica_url
            )
        }
        return musicas
    }
}