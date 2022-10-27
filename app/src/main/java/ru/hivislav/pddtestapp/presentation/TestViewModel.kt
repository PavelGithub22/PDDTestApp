package ru.hivislav.pddtestapp.presentation

import android.app.Application
import android.os.CountDownTimer
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ru.hivislav.pddtestapp.R
import ru.hivislav.pddtestapp.data.RepositoryImpl
import ru.hivislav.pddtestapp.domain.GenerateQuestionUseCase
import ru.hivislav.pddtestapp.domain.Question
import ru.hivislav.pddtestapp.domain.TestResult

class TestViewModel(
    private val application: Application
): ViewModel() {

    private val repository = RepositoryImpl(application)
    private val generateQuestionUseCase = GenerateQuestionUseCase(repository)

    private var countOfQuestions = COUNT_OF_QUESTIONS
    private var countOfRightAnswers = 0
    private var countOfMistakes = 0
    private var enoughCountOfQuestions = countOfQuestions - (countOfRightAnswers + countOfMistakes)

    private var timer: CountDownTimer? = null

    private val _question = MutableLiveData<Question>()
    val question: LiveData<Question>
        get() = _question

    private val _testResult = MutableLiveData<TestResult>()
    val testResult: LiveData<TestResult>
        get() = _testResult

    private val _formattedTime = MutableLiveData<String>()
    val formattedTime: LiveData<String>
        get() = _formattedTime

    private val _progressAnswers = MutableLiveData<String>()
    val progressAnswers: LiveData<String>
        get() = _progressAnswers

    init {
        startTest()
    }

    private fun startTest() {
        startTimer()
        generateQuestion()
        updateProgress()
    }

    private fun finishTest() {
        _testResult.value = TestResult(
            countOfMistakes <= MAX_COUNT_MISTAKES,
            (countOfRightAnswers + countOfMistakes),
            countOfRightAnswers,
            countOfMistakes
        )
    }

    private fun generateQuestion() {
        _question.value = generateQuestionUseCase()
    }

    private fun startTimer() {
        timer = object : CountDownTimer(
            TEST_DURATION_IN_MINUTES * SECONDS_IN_MINUTES * MILLIS_IN_SECONDS,
            MILLIS_IN_SECONDS
        ) {
            override fun onTick(millisUntilFinished: Long) {
                _formattedTime.value = formatTime(millisUntilFinished)
            }

            override fun onFinish() {
                finishTest()
            }
        }
        timer?.start()
    }

    private fun formatTime(millisUntilFinished: Long): String {
        val seconds = millisUntilFinished / MILLIS_IN_SECONDS
        val minutes = seconds / SECONDS_IN_MINUTES
        val leftSeconds = seconds - (minutes * SECONDS_IN_MINUTES)

        return String.format("%02d:%02d", minutes, leftSeconds)
    }

    private fun updateProgress() {
        if (enoughCountOfQuestions == 0 || countOfMistakes > MAX_COUNT_MISTAKES) {
            finishTest()
        } else {
            _progressAnswers.value = String.format(
                application.resources.getString(R.string.progress_text_view_test_fragment),
                countOfQuestions,
                enoughCountOfQuestions,
                countOfMistakes
            )
        }
    }

    fun chooseAnswer(answer: String) {
        checkAnswer(answer)
        updateProgress()
        generateQuestion()
    }

    private fun checkAnswer(answer: String) {
        val rightAnswer = question.value?.rightAnswer

        if (answer == rightAnswer) {
            countOfRightAnswers++
        } else {
            countOfMistakes++
            countOfQuestions += ADD_QUESTION_COUNT_FOR_MISTAKE
            enoughCountOfQuestions += ADD_QUESTION_COUNT_FOR_MISTAKE
        }
        enoughCountOfQuestions--
    }

    override fun onCleared() {
        super.onCleared()
        timer?.cancel()
    }

    companion object{
        private const val TEST_DURATION_IN_MINUTES = 20
        private const val SECONDS_IN_MINUTES = 60
        private const val MILLIS_IN_SECONDS = 1000L
        private const val MAX_COUNT_MISTAKES = 2
        private const val ADD_QUESTION_COUNT_FOR_MISTAKE = 5
        private const val COUNT_OF_QUESTIONS = 20

    }
}