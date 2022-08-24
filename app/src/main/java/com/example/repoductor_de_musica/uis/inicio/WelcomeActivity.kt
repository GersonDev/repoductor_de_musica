package com.example.repoductor_de_musica.uis.inicio

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.repoductor_de_musica.routes.WelcomeScreen
import com.example.repoductor_de_musica.ui.theme.Repoductor_de_musicaTheme
import com.example.repoductor_de_musica.uis.inicio.components.MusicasPantalla
import com.example.repoductor_de_musica.uis.inicio.components.WelcomePantalla

class WelcomeActivity : ComponentActivity() {

    private val welcomeViewModel by viewModels<WelcomeViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Repoductor_de_musicaTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    MainScreem(
                        welcomeViewModel
                    )
                }
            }
        }
    }
}

@Composable
fun MainScreem(
    welcomeViewModel: WelcomeViewModel
) {
    val musicas by welcomeViewModel.musicas.observeAsState(listOf())
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = WelcomeScreen.Bienvenida.route) {
        composable(WelcomeScreen.Bienvenida.route) {
            WelcomePantalla(
                onClickIngresar = {
                    navController.navigate(WelcomeScreen.Musicas.route)
                }
            )
        }
        composable(WelcomeScreen.Musicas.route) {
            welcomeViewModel.getMusicas()
            MusicasPantalla(musicas = musicas)
        }
    }


}