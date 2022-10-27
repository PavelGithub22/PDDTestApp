package ru.hivislav.pddtestapp.domain

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class TestResult(
    val winner: Boolean,
    val countOfQuestions: Int,
    val countOfRightAnswers: Int,
    val countOfMistakes: Int
): Parcelable
