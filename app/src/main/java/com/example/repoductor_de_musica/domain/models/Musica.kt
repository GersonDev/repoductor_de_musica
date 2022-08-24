package com.example.repoductor_de_musica.domain.models

import androidx.annotation.DrawableRes

data class Musica(
    var id: String,
    var title: String,
    var subtitulo: String,
    var image_url: String,
    var love: Boolean,
    var musica_url: String
)
