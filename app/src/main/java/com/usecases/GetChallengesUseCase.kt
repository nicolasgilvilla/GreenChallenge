package com.usecases

import com.data.repository.ChallengeRepository
import com.domain.ModelCommon

class GetChallengesUseCase (private val challengeRepository: ChallengeRepository) {

    operator fun invoke(): List<ModelCommon> {
            return challengeRepository.challenges
        }
}
