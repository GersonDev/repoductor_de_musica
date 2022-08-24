package com.example.repoductor_de_musica.domain.repositories

import com.example.repoductor_de_musica.data.datasources.RemoteDataSource
import com.example.repoductor_de_musica.domain.models.Musica
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class MusicasRepository {

    private val remoteDataSource=RemoteDataSource()


    suspend fun getMusicasFromRemote(): List<Musica>{
        return  withContext(Dispatchers.IO){
            remoteDataSource.getUsersFromRemote()
        }
    }
}