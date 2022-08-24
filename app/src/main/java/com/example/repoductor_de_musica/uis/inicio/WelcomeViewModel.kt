package com.example.repoductor_de_musica.uis.inicio

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.repoductor_de_musica.domain.models.Musica
import com.example.repoductor_de_musica.domain.repositories.MusicasRepository
import kotlinx.coroutines.launch

class WelcomeViewModel(application: Application) : AndroidViewModel(application) {

    private val musicasRepository = MusicasRepository()

    private val _musicas = MutableLiveData<List<Musica>>(listOf())
    val musicas: LiveData<List<Musica>> = _musicas


    fun getMusicas(){
        viewModelScope.launch {
            val musicas = musicasRepository.getMusicasFromRemote()
            _musicas.value= musicas
        }
    }
}