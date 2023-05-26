package com.data.repository

import com.data.datasource.ChallengeLocalDataSource
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
class ChallengeRepositoryTest {

    @Mock
    lateinit var challengeLocalDataSource: ChallengeLocalDataSource

    private lateinit var challengeRepository: ChallengeRepository

    @Before
    fun setUp() {
        challengeRepository = ChallengeRepository(challengeLocalDataSource)
    }

    @Test
    fun `Challenges are taken from local data source if available`(): Unit = runTest {
        val challenge = listOf(ModelCommon("", "", "", ""))
        whenever(challengeLocalDataSource.allChallenges).thenReturn(challenge)

        val result = challengeRepository.challenges

        assertEquals(challenge, result)
    }
}
