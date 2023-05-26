package com.data.repository

import com.data.datasource.ChallengeLocalDataSource
import com.domain.ModelCommon

class ChallengeRepository (
    private val localDataSource: ChallengeLocalDataSource
) {
    val challenges get() = localDataSource.allChallenges

    fun findById(id: Int): ModelCommon = localDataSource.findById(id)
}
