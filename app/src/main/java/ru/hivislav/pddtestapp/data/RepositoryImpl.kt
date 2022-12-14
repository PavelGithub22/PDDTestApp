package ru.hivislav.pddtestapp.data

import android.app.Application
import ru.hivislav.pddtestapp.R
import ru.hivislav.pddtestapp.domain.Question
import ru.hivislav.pddtestapp.domain.Repository

class RepositoryImpl(application: Application): Repository {

    private var questions = mutableListOf<Question>()

    init {
        questions = mutableListOf(
            Question(
                1,
                application.resources.getStringArray(R.array.question_and_right_answer_1)[0],
                application.resources.getStringArray(R.array.question_and_right_answer_1)[1],
                application.resources.getStringArray(R.array.answers_1).toList(),
                0,
            ),
            Question(
                2,
                application.resources.getStringArray(R.array.question_and_right_answer_2)[0],
                application.resources.getStringArray(R.array.question_and_right_answer_2)[1],
                application.resources.getStringArray(R.array.answers_2).toList(),
                R.drawable.pic_question_2,
            ),
            Question(
                3,
                application.resources.getStringArray(R.array.question_and_right_answer_3)[0],
                application.resources.getStringArray(R.array.question_and_right_answer_3)[1],
                application.resources.getStringArray(R.array.answers_3).toList(),
                R.drawable.pic_question_3,
            ),
            Question(
                4,
                application.resources.getStringArray(R.array.question_and_right_answer_4)[0],
                application.resources.getStringArray(R.array.question_and_right_answer_4)[1],
                application.resources.getStringArray(R.array.answers_4).toList(),
                R.drawable.pic_question_4,
            ),
            Question(
                5,
                application.resources.getStringArray(R.array.question_and_right_answer_5)[0],
                application.resources.getStringArray(R.array.question_and_right_answer_5)[1],
                application.resources.getStringArray(R.array.answers_5).toList(),
                R.drawable.pic_question_5,
            ),
            Question(
                6,
                application.resources.getStringArray(R.array.question_and_right_answer_6)[0],
                application.resources.getStringArray(R.array.question_and_right_answer_6)[1],
                application.resources.getStringArray(R.array.answers_6).toList(),
                0,
            ),
            Question(
                7,
                application.resources.getStringArray(R.array.question_and_right_answer_7)[0],
                application.resources.getStringArray(R.array.question_and_right_answer_7)[1],
                application.resources.getStringArray(R.array.answers_7).toList(),
                0,
            ),
            Question(
                8,
                application.resources.getStringArray(R.array.question_and_right_answer_8)[0],
                application.resources.getStringArray(R.array.question_and_right_answer_8)[1],
                application.resources.getStringArray(R.array.answers_8).toList(),
                R.drawable.pic_question_8,
            ),
            Question(
                9,
                application.resources.getStringArray(R.array.question_and_right_answer_9)[0],
                application.resources.getStringArray(R.array.question_and_right_answer_9)[1],
                application.resources.getStringArray(R.array.answers_9).toList(),
                R.drawable.pic_question_9,
            ),
            Question(
                10,
                application.resources.getStringArray(R.array.question_and_right_answer_10)[0],
                application.resources.getStringArray(R.array.question_and_right_answer_10)[1],
                application.resources.getStringArray(R.array.answers_10).toList(),
                0,
            ),
            Question(
                11,
                application.resources.getStringArray(R.array.question_and_right_answer_11)[0],
                application.resources.getStringArray(R.array.question_and_right_answer_11)[1],
                application.resources.getStringArray(R.array.answers_11).toList(),
                0,
            ),
            Question(
                12,
                application.resources.getStringArray(R.array.question_and_right_answer_12)[0],
                application.resources.getStringArray(R.array.question_and_right_answer_12)[1],
                application.resources.getStringArray(R.array.answers_12).toList(),
                R.drawable.pic_question_12,
            ),
            Question(
                13,
                application.resources.getStringArray(R.array.question_and_right_answer_13)[0],
                application.resources.getStringArray(R.array.question_and_right_answer_13)[1],
                application.resources.getStringArray(R.array.answers_13).toList(),
                R.drawable.pic_question_13,
            ),
            Question(
                14,
                application.resources.getStringArray(R.array.question_and_right_answer_14)[0],
                application.resources.getStringArray(R.array.question_and_right_answer_14)[1],
                application.resources.getStringArray(R.array.answers_14).toList(),
                R.drawable.pic_question_14,
            ),
            Question(
                15,
                application.resources.getStringArray(R.array.question_and_right_answer_15)[0],
                application.resources.getStringArray(R.array.question_and_right_answer_15)[1],
                application.resources.getStringArray(R.array.answers_15).toList(),
                R.drawable.pic_question_15,
            ),
            Question(
                16,
                application.resources.getStringArray(R.array.question_and_right_answer_16)[0],
                application.resources.getStringArray(R.array.question_and_right_answer_16)[1],
                application.resources.getStringArray(R.array.answers_16).toList(),
                R.drawable.pic_question_16,
            ),
            Question(
                17,
                application.resources.getStringArray(R.array.question_and_right_answer_17)[0],
                application.resources.getStringArray(R.array.question_and_right_answer_17)[1],
                application.resources.getStringArray(R.array.answers_17).toList(),
                0,
            ),
            Question(
                18,
                application.resources.getStringArray(R.array.question_and_right_answer_18)[0],
                application.resources.getStringArray(R.array.question_and_right_answer_18)[1],
                application.resources.getStringArray(R.array.answers_18).toList(),
                0,
            ),
            Question(
                19,
                application.resources.getStringArray(R.array.question_and_right_answer_19)[0],
                application.resources.getStringArray(R.array.question_and_right_answer_19)[1],
                application.resources.getStringArray(R.array.answers_19).toList(),
                0,
            ),
            Question(
                20,
                application.resources.getStringArray(R.array.question_and_right_answer_20)[0],
                application.resources.getStringArray(R.array.question_and_right_answer_20)[1],
                application.resources.getStringArray(R.array.answers_20).toList(),
                0,
            ),
            Question(
                21,
                application.resources.getStringArray(R.array.question_and_right_answer_21)[0],
                application.resources.getStringArray(R.array.question_and_right_answer_21)[1],
                application.resources.getStringArray(R.array.answers_21).toList(),
                0,
            ),
            Question(
                22,
                application.resources.getStringArray(R.array.question_and_right_answer_22)[0],
                application.resources.getStringArray(R.array.question_and_right_answer_22)[1],
                application.resources.getStringArray(R.array.answers_22).toList(),
                R.drawable.pic_question_22,
            ),
            Question(
                23,
                application.resources.getStringArray(R.array.question_and_right_answer_23)[0],
                application.resources.getStringArray(R.array.question_and_right_answer_23)[1],
                application.resources.getStringArray(R.array.answers_23).toList(),
                R.drawable.pic_question_23,
            ),
            Question(
                24,
                application.resources.getStringArray(R.array.question_and_right_answer_24)[0],
                application.resources.getStringArray(R.array.question_and_right_answer_24)[1],
                application.resources.getStringArray(R.array.answers_24).toList(),
                R.drawable.pic_question_24,
            ),
            Question(
                25,
                application.resources.getStringArray(R.array.question_and_right_answer_25)[0],
                application.resources.getStringArray(R.array.question_and_right_answer_25)[1],
                application.resources.getStringArray(R.array.answers_25).toList(),
                R.drawable.pic_question_25,
            ),
            Question(
                26,
                application.resources.getStringArray(R.array.question_and_right_answer_26)[0],
                application.resources.getStringArray(R.array.question_and_right_answer_26)[1],
                application.resources.getStringArray(R.array.answers_26).toList(),
                0,
            ),
            Question(
                27,
                application.resources.getStringArray(R.array.question_and_right_answer_27)[0],
                application.resources.getStringArray(R.array.question_and_right_answer_27)[1],
                application.resources.getStringArray(R.array.answers_27).toList(),
                R.drawable.pic_question_27,
            ),
            Question(
                28,
                application.resources.getStringArray(R.array.question_and_right_answer_28)[0],
                application.resources.getStringArray(R.array.question_and_right_answer_28)[1],
                application.resources.getStringArray(R.array.answers_28).toList(),
                R.drawable.pic_question_28,
            ),
            Question(
                29,
                application.resources.getStringArray(R.array.question_and_right_answer_29)[0],
                application.resources.getStringArray(R.array.question_and_right_answer_29)[1],
                application.resources.getStringArray(R.array.answers_29).toList(),
                R.drawable.pic_question_29,
            ),
            Question(
                30,
                application.resources.getStringArray(R.array.question_and_right_answer_30)[0],
                application.resources.getStringArray(R.array.question_and_right_answer_30)[1],
                application.resources.getStringArray(R.array.answers_30).toList(),
                R.drawable.pic_question_30,
            )
        )
    }

    override fun generateQuestion(): Question {
        val question = questions[(0 until questions.size).random()]
        questions.remove(question)
        return question
    }
}