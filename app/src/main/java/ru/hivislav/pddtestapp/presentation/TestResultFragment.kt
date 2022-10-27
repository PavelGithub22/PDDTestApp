package ru.hivislav.pddtestapp.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import ru.hivislav.pddtestapp.R
import ru.hivislav.pddtestapp.databinding.FragmentTestResultBinding
import ru.hivislav.pddtestapp.domain.TestResult

class TestResultFragment : Fragment() {

    private var _binding: FragmentTestResultBinding? = null
    private val binding
        get() = _binding!!

    private lateinit var testResult: TestResult

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        parseArgs()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentTestResultBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        bindViews()
        setClickListeners()
    }

    private fun setClickListeners() {
        binding.retryButtonTestResultFragment.setOnClickListener {
            requireActivity().supportFragmentManager
                .beginTransaction()
                .replace(R.id.mainContainer, TestFragment.newInstance())
                .commit()
        }

        val callback = object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                requireActivity().supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.mainContainer, WelcomeFragment.newInstance())
                    .commit()
            }
        }
        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner, callback)
    }

    private fun bindViews() {
        with(binding) {
            resultImageViewTestResultFragment.setImageResource(getSmileResId())
            allAnswersTextViewTestResultFragment.text = String.format(
                getString(R.string.all_answers_text_view_test_result_fragment),
                testResult.countOfQuestions
            )
            trueAnswersTextViewTestResultFragment.text = String.format(
                getString(R.string.true_answers_text_view_test_result_fragment),
                testResult.countOfRightAnswers
            )
            mistakesTextViewTestResultFragment.text = String.format(
                getString(R.string.mistakes_text_view_test_result_fragment),
                testResult.countOfMistakes
            )
        }
    }

    private fun getSmileResId(): Int {
        return if (testResult.winner) {
            R.drawable.ic_smile
        } else {
            R.drawable.ic_sad
        }
    }

    private fun parseArgs() {
        requireArguments().getParcelable<TestResult>(TEST_RESULT_KEY)?.let {
            testResult = it
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        private const val TEST_RESULT_KEY = "test"
        fun newInstance(testResult: TestResult) = TestResultFragment().apply {
            arguments = Bundle().apply {
                putParcelable(TEST_RESULT_KEY, testResult)
            }
        }
    }
}