package ru.hivislav.pddtestapp.domain

class GenerateQuestionUseCase(
    private val repository: Repository
) {

    operator fun invoke(questions: List<Question>): Question {
       return repository.generateQuestion(questions)
    }
}