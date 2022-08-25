package com.example.repoductor_de_musica.routes

sealed class WelcomeScreen(val route:String) {
    object Bienvenida: WelcomeScreen("BienvenidaPantalla")
    object Musicas: WelcomeScreen("MusicasPantalla")
    object MusicaSeleccionada:WelcomeScreen("MusicaSeleccionadaPantalla")
}

