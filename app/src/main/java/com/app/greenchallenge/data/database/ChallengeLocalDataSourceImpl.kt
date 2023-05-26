package com.app.greenchallenge.data.database

import com.data.datasource.ChallengeLocalDataSource
import com.domain.ModelCommon

class ChallengeLocalDataSourceImpl(
) : ChallengeLocalDataSource {

    override val allChallenges: List<ModelCommon> =
        listOf(ModelCommon("", "", "", "")) //Obtener los retos y mapearlas al modelo de dominio

    override suspend fun isEmpty(): Boolean = true//Referencia de las peliculas == 0

    override fun findById(id: Int): ModelCommon =
        (ModelCommon("", "", "", ""))//Obtener por Id y mapear al domain model

    override suspend fun save(challenges: List<ModelCommon>): Error? {
        //insertar los challenges
        return null
    }
}
