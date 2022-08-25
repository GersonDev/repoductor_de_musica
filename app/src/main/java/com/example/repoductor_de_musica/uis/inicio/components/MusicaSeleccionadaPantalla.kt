package com.example.repoductor_de_musica.uis.inicio.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.example.repoductor_de_musica.domain.models.Musica
import com.example.repoductor_de_musica.ui.theme.Poppins

@Composable
fun MusicaSeleccionadaPantalla(
    musica: Musica?,
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ) {
        Text(
            text = "Now Playing",
            color = Color.Black,
            fontFamily = Poppins,
            style = MaterialTheme.typography.h2,
            textAlign = TextAlign.Center
        )
        val painter = rememberImagePainter(musica!!.image_url)
        Image(
            painter = painter,
            contentDescription = null,
            modifier = Modifier
                .size(300.dp)
                .clip(RoundedCornerShape(12.dp))
        )
        Text(text = "${musica.title}",
            fontFamily = Poppins,
            style = MaterialTheme.typography.h1
        )
        Text(text = "${musica.subtitulo}",
            fontFamily = Poppins,
            style = MaterialTheme.typography.h2,
            color = Color.LightGray
        )

    }
}
