package ru.hivislav.pddtestapp.domain

interface Repository {

    fun generateQuestion(questions: List<Question>): Question
}