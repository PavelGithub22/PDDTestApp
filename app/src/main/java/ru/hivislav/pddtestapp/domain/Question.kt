package ru.hivislav.pddtestapp.domain

data class Question(
    val numberOfQuestion: Int,
    val question: String,
    val rightAnswer: String,
    val allAnswers: List<String>,
    val pictureOfQuestion: Int
)