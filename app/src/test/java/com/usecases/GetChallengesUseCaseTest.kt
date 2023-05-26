package com.usecases

import com.data.repository.ChallengeRepository
import com.domain.ModelCommon
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner
import org.mockito.kotlin.whenever

@OptIn(ExperimentalCoroutinesApi::class)
@RunWith(MockitoJUnitRunner::class)
class GetChallengesUseCaseTest {

    @Mock
    private lateinit var challengeRepository: ChallengeRepository

    private lateinit var getChallengesUseCase: GetChallengesUseCase

    @Before
    fun setup() {
        getChallengesUseCase = GetChallengesUseCase(challengeRepository)
    }

    @Test
    fun `when GetChallengesUseCase is called should returns challenges`(): Unit =
        runTest {
            val challenges =
              listOf(ModelCommon("", "", "", ""))
            whenever(challengeRepository.challenges).thenReturn(challenges)


            val result = getChallengesUseCase()

            assertEquals(challenges, result)
        }

}