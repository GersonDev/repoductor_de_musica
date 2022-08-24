package com.example.repoductor_de_musica.uis.inicio.components

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.repoductor_de_musica.R
import com.example.repoductor_de_musica.domain.models.Musica

@Composable
fun MusicasPantalla(musicas: List<Musica>) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ) {
        Text(
            text = "New Release",
            color = Color.Black,
            style = MaterialTheme.typography.h1,
            textAlign = TextAlign.Center
        )
        Text(
            text = "ALBUM",
            color = Color.LightGray,
            style = MaterialTheme.typography.h5,
            textAlign = TextAlign.Center
        )
        Column(
            modifier = Modifier
                .padding(start = 25.dp, end = 25.dp)
                .verticalScroll(rememberScrollState())
        ) {
            musicas.forEach {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                   // TODO tu imagen que pinta la url

                    AsyncImage(
                        model = "https://blog.edufors.com/wp-content/uploads/2018/07/deporte-400x400.jpg",
                        contentDescription = null
                    )
                    Column(
                        modifier = Modifier
                            .weight(1f)
                            .padding(start = 10.dp)
                    ) {
                        Text(
                            text = "${it.title}",
                            style = MaterialTheme.typography.h5
                        )
                        Text(
                            text = "${it.subtitulo}",
                            style = MaterialTheme.typography.caption,
                            color = Color.LightGray
                        )
                    }
                    if (it.love) {
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