package ru.hivislav.pddtestapp.domain

data class Question(
    val numberOfQuestion: Int,
    val question: String,
    val pictureOfQuestion: Int,
    val allAnswers: List<String>,
    val rightAnswer: String
)