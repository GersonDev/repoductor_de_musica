package com.example.repoductor_de_musica.data.api

data class GetMusicaResponse(
    var id: String,
    var title: String,
    var subtitulo: String,
    var image_url: String,
    var love: Boolean,
    var musica_url: String
)