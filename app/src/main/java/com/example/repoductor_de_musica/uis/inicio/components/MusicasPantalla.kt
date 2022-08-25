package com.example.repoductor_de_musica.uis.inicio.components

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.example.repoductor_de_musica.R
import com.example.repoductor_de_musica.domain.models.Musica
import com.example.repoductor_de_musica.ui.theme.Poppins


@Composable
fun MusicasPantalla(musicas: List<Musica>, onClikMusica: (Musica) -> Unit) {

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ) {
        Text(
            text = "New Release",
            color = Color.Black,
            fontFamily = Poppins,
            style = MaterialTheme.typography.h2,
            textAlign = TextAlign.Center
        )
        Text(
            text = "ALBUM",
            color = Color.LightGray,
            fontFamily = Poppins,
            style = MaterialTheme.typography.body1,
            textAlign = TextAlign.Center
        )
        Column(
            modifier = Modifier
                .padding(start = 25.dp, end = 25.dp)
                .verticalScroll(rememberScrollState())
        ) {
            musicas.forEach { musica ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable { onClikMusica(musica) },

                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    val painter = rememberImagePainter(musica.image_url)
                    Image(
                        painter = painter,
                        contentDescription = null,
                        modifier = Modifier
                            .size(70.dp)
                            .clip(RoundedCornerShape(12.dp))
                    )
                    Column(
                        modifier = Modifier
                            .weight(1f)
                            .padding(start = 10.dp)
                    ) {
                        Text(
                            text = "${musica.title}",
                            fontFamily = Poppins,
                            style = MaterialTheme.typography.h2
                        )
                        Text(
                            text = "${musica.subtitulo}",
                            fontFamily = Poppins,
                            style = MaterialTheme.typography.body1,
                            color = Color.LightGray
                        )
                    }
                    if (musica.love) {
                        Image(
                            painter = painterResource(id = R.drawable.love),
                            contentDescription = "love"
                        )
                    } else {
                        Image(
                            painter = painterResource(id = R.drawable.lovenegro),
                            contentDescription = "love"
                        )
                    }
                    Spacer(modifier = Modifier.height(85.dp))
                }

            }
        }
    }
}