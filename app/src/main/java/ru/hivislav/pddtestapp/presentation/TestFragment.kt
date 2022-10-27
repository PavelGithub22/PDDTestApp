package ru.hivislav.pddtestapp.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import ru.hivislav.pddtestapp.R
import ru.hivislav.pddtestapp.databinding.FragmentTestBinding
import ru.hivislav.pddtestapp.domain.Question
import ru.hivislav.pddtestapp.domain.TestResult

class TestFragment : Fragment() {

    private var _binding: FragmentTestBinding? = null
    private val binding
        get() = _binding!!

    private val viewModelFactory by lazy {
        TestViewModelFactory(requireActivity().application)
    }
    private val viewModel by lazy {
        ViewModelProvider(this, viewModelFactory)[TestViewModel::class.java]
    }

    private val cardViewAnswers by lazy {
        mutableListOf<CardView>().apply {
            with(binding) {
                add(answerOneCardViewTestFragment)
                add(answerTwoCardViewTestFragment)
                add(answerThreeCardViewTestFragment)
                add(answerFourCardViewTestFragment)
            }
        }
    }

    private val checkFlagsCardView = mutableListOf(false, false, false, false)
    private var stateActiveButton = false

    private val fourTextViewAnswers by lazy {
        mutableListOf<TextView>().apply {
            with(binding) {
                add(answerOneTextViewTestFragment)
                add(answerTwoTextViewTestFragment)
                add(answerThreeTextViewTestFragment)
                add(answerFourTextViewTestFragment)
            }
        }
    }

    private val threeTextViewAnswers by lazy {
        mutableListOf<TextView>().apply {
            with(binding) {
                add(answerOneTextViewTestFragment)
                add(answerTwoTextViewTestFragment)
                add(answerThreeTextViewTestFragment)
            }
        }
    }

    private val twoTextViewAnswers by lazy {
        mutableListOf<TextView>().apply {
            with(binding) {
                add(answerOneTextViewTestFragment)
                add(answerTwoTextViewTestFragment)
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentTestBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setClickListenersToAnswers()
        observeViewModels()
    }

    private fun observeViewModels() {
        viewModel.question.observe(viewLifecycleOwner) {
            binding.questionTextViewTestFragment.text = it.question
            binding.imageTestFragment.setImageResource(it.pictureOfQuestion)
            when (it.allAnswers.size) {
                COUNT_OF_ANSWERS_FOUR -> {
                    binding.answerThreeCardViewTestFragment.visibility = View.VISIBLE
                    binding.answerFourCardViewTestFragment.visibility = View.VISIBLE
                    setTextAnswers(fourTextViewAnswers, it)
                }
                COUNT_OF_ANSWERS_THREE -> {
                    binding.answerFourCardViewTestFragment.visibility = View.INVISIBLE
                    setTextAnswers(threeTextViewAnswers, it)
                }
                COUNT_OF_ANSWERS_TWO -> {
                    binding.answerThreeCardViewTestFragment.visibility = View.INVISIBLE
                    binding.answerFourCardViewTestFragment.visibility = View.INVISIBLE
                    setTextAnswers(twoTextViewAnswers, it)
                }
            }
        }

        viewModel.formattedTime.observe(viewLifecycleOwner) {
            binding.timerTextViewTestFragment.text = it
        }

        viewModel.progressAnswers.observe(viewLifecycleOwner) {
            binding.progressTextViewTestFragment.text = it
        }

        viewModel.testResult.observe(viewLifecycleOwner) {
            launchTestResultFragment(it)
        }
    }

    private fun launchTestResultFragment(testResult: TestResult) {
        requireActivity().supportFragmentManager
            .beginTransaction()
            .replace(R.id.mainContainer, TestResultFragment.newInstance(testResult))
            .commit()
    }

    private fun setClickListenersToAnswers() {

        for (i in 0 until cardViewAnswers.size) {
            cardViewAnswers[i].setOnClickListener {
                updateCheckCardView()
                checkFlagsCardView[i] = !checkFlagsCardView[i]
                changeStateColorCardView(i)
                stateActiveButton = true
                changeStateColorButton(stateActiveButton)
            }
        }

        binding.acceptButtonTestFragment.setOnClickListener {
            if (stateActiveButton) {
                viewModel.chooseAnswer(getAnswer())
                updateCheckCardView()
                changeStateColorCardView(REFRESH_CARD_VIEW_COLOR_CODE)
                stateActiveButton = false
                changeStateColorButton(stateActiveButton)
            }
        }
    }

    private fun changeStateColorButton(stateActive: Boolean) {
        if (stateActive) {
            binding.acceptButtonTestFragment.apply {
                setBackgroundColor(
                    ContextCompat.getColor(requireActivity(), R.color.purple_500)
                )
                setTextColor(
                    ContextCompat.getColor(requireActivity(), R.color.white)
                )
            }
        } else {
            binding.acceptButtonTestFragment.apply {
                setBackgroundColor(
                    ContextCompat.getColor(requireActivity(), R.color.grey_button)
                )
                setTextColor(
                    ContextCompat.getColor(requireActivity(), R.color.black)
                )
            }
        }
    }

    private fun changeStateColorCardView(indexOfCardView: Int) {
        for (cardViewAnswer in cardViewAnswers) {
            cardViewAnswer.backgroundTintList = ContextCompat.getColorStateList(
                requireActivity(),
                R.color.white
            )
        }

        if (indexOfCardView != REFRESH_CARD_VIEW_COLOR_CODE) {
            cardViewAnswers[indexOfCardView].backgroundTintList = ContextCompat.getColorStateList(
                requireActivity(),
                R.color.grey_button
            )
        }
    }

    private fun getAnswer(): String {
        var index = 0
        for (i in 0 until checkFlagsCardView.size) {
            if (checkFlagsCardView[i]) {
                index = i
            }
        }

        return when(index) {
            NUMBER_ONE_ANSWER_TEXT_VIEW -> binding.answerOneTextViewTestFragment.text.toString()
            NUMBER_TWO_ANSWER_TEXT_VIEW -> binding.answerTwoTextViewTestFragment.text.toString()
            NUMBER_THREE_ANSWER_TEXT_VIEW -> binding.answerThreeTextViewTestFragment.text.toString()
            NUMBER_FOUR_ANSWER_TEXT_VIEW -> binding.answerFourTextViewTestFragment.text.toString()
            else -> {throw RuntimeException("Answer text view not found index $index")}
        }
    }

    private fun updateCheckCardView() {
        for (i in 0 until checkFlagsCardView.size) {
            checkFlagsCardView[i] = false
        }
    }

    private fun setTextAnswers (listTextView: List<TextView>, question: Question) {
        for (i in listTextView.indices) {
            listTextView[i].text = question.allAnswers[i]
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        fun newInstance() = TestFragment()
        private const val COUNT_OF_ANSWERS_FOUR = 4
        private const val COUNT_OF_ANSWERS_THREE = 3
        private const val COUNT_OF_ANSWERS_TWO = 2
        private const val REFRESH_CARD_VIEW_COLOR_CODE = 101

        private const val NUMBER_ONE_ANSWER_TEXT_VIEW = 0
        private const val NUMBER_TWO_ANSWER_TEXT_VIEW = 1
        private const val NUMBER_THREE_ANSWER_TEXT_VIEW = 2
        private const val NUMBER_FOUR_ANSWER_TEXT_VIEW = 3
    }
}