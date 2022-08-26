package com.example.repoductor_de_musica.uis.inicio.components

import android.media.AudioManager
import android.media.MediaPlayer
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.example.repoductor_de_musica.R
import com.example.repoductor_de_musica.domain.models.Musica
import com.example.repoductor_de_musica.ui.theme.Poppins

@Composable
fun MusicaSeleccionadaPantalla(
    musica: Musica?,
) {
    val ctx = LocalContext.current
    val mediaPlayer = MediaPlayer()
    var estaInicializado = false
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        colorResource(id = R.color.plomo),
                        colorResource(id = R.color.plomoclaro),
                    )
                )
            )
    ) {
        Spacer(modifier = Modifier.padding(10.dp))
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
        Text(
            text = "${musica.title}",
            fontFamily = Poppins,
            style = MaterialTheme.typography.h1
        )
        Text(
            text = "${musica.subtitulo}",
            fontFamily = Poppins,
            style = MaterialTheme.typography.h2,
            color = Color.LightGray
        )
        Row {
            Button(
                modifier = Modifier
                    .size(100.dp)
                    .padding(7.dp),
                colors = ButtonDefaults.buttonColors(backgroundColor = Color.Transparent),
                onClick = {
                    try {
                        if (estaInicializado == true) {
                            mediaPlayer.start()
                        } else {
                            mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
                            mediaPlayer.setDataSource("${musica.musica_url}")
                            mediaPlayer.prepare()
                            estaInicializado = true
                            mediaPlayer.start()
                        }
                    } catch (e: Exception) {
                        e.printStackTrace()
                    }
                    Toast.makeText(ctx, "Audio started playing..", Toast.LENGTH_SHORT).show()
                }) {
                Image(
                    painter = painterResource(id = R.drawable.play),
                    contentDescription = "play",
                    modifier = Modifier.size(150.dp)
                )
            }
            Spacer(modifier = Modifier.height(20.dp))
            Button(
                modifier = Modifier
                    .size(100.dp)
                    .padding(7.dp),
                colors = ButtonDefaults.buttonColors(backgroundColor = Color.Transparent),
                onClick = {
                    if (mediaPlayer.isPlaying) {
                        mediaPlayer.stop()
                        mediaPlayer.reset()
                        mediaPlayer.release()
                        Toast.makeText(ctx, "Audio has been paused..", Toast.LENGTH_SHORT).show()
                    } else {
                        Toast.makeText(ctx, "Audio not played..", Toast.LENGTH_SHORT).show()
                    }
                }) {
                Image(
                    painter = painterResource(id = R.drawable.pause),
                    contentDescription = "pause",
                    modifier = Modifier.size(150.dp)
                )
            }
        }
    }
}
