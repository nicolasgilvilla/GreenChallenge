package com.data.datasource

import com.domain.ModelCommon

interface ChallengeLocalDataSource {
    val allChallenges: List<ModelCommon>

    suspend fun isEmpty(): Boolean

    fun findById(id: Int): ModelCommon

    //Si Se va a usar modelado por error se deja este return
    //No creo que vayamos a usar un delete

    suspend fun save(challenges: List<ModelCommon>): Error?
}
