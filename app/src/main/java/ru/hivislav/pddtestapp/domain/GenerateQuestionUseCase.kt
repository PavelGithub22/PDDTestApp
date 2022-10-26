package ru.hivislav.pddtestapp.domain

class GenerateQuestionUseCase(
    private val repository: Repository
) {

    operator fun invoke(): Question {
       return repository.generateQuestion()
    }
}