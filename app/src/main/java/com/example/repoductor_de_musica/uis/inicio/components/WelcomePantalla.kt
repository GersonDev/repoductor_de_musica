package com.example.repoductor_de_musica.uis.inicio.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.repoductor_de_musica.R
import com.example.repoductor_de_musica.ui.theme.Poppins

@Composable
fun WelcomePantalla(onClickIngresar:()->Unit) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize()
            .background(color = Color.Black)

    ) {
        Box(
            contentAlignment = Alignment.Center,
        ) {
            Image(
                modifier = Modifier
                    .height(
                        116.dp
                    )
                    .width(
                        174.dp
                    )
                    .padding(bottom = 10.dp),
                painter = painterResource(id = R.drawable.logopantalla),
                contentDescription = "nube"
            )
            Row() {
                Image(
                    modifier = Modifier
                        .height(
                            28.dp
                        )
                        .width(
                            28.dp
                        ),
                    painter = painterResource(id = R.drawable.vector),
                    contentDescription = "Lineas"
                )
                Image(
                    modifier = Modifier
                        .height(
                            28.dp
                        )
                        .width(
                            28.dp
                        ),
                    painter = painterResource(id = R.drawable.vector),
                    contentDescription = "Lineas"
                )
            }
        }
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Cloud",
                color = Color.White,
                fontFamily = Poppins,
                style = MaterialTheme.typography.caption,
                textAlign = TextAlign.Center
            )
            Text(
                text = "Music",
                color = Color.LightGray,
                fontFamily = Poppins,
                style = MaterialTheme.typography.body1,
                textAlign = TextAlign.Center
            )
            Button(
                onClick = onClickIngresar,
                colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xD7FFFFFF)),
                shape = RoundedCornerShape(22.dp),
                modifier = Modifier
                    .width(105.dp)
                    .height(38.dp),
                content = {
                    Text(
                        text = "Ingresar",
                        fontFamily = Poppins,
                        style = MaterialTheme.typography.h4
                    )
                }
            )
        }
    }
}
