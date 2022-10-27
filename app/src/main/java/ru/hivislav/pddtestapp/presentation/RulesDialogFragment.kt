package ru.hivislav.pddtestapp.presentation

import android.app.Dialog
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import ru.hivislav.pddtestapp.R

class RulesDialogFragment : DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        return requireActivity().let {
            val builder = AlertDialog.Builder(it)
            builder
                .setTitle(getString(R.string.title_dialog_fragment))
                .setMessage(resources.getString(R.string.rules_dialog_fragment))
                .setIcon(R.drawable.ic_baseline_warning_24)
                .setPositiveButton(getString(R.string.positive_button_dialog_fragment))
                { _, _ ->  launchTestFragment()
                }
            builder.create()
        }
    }

    private fun launchTestFragment() {
        requireActivity().supportFragmentManager
            .beginTransaction()
            .replace(R.id.mainContainer, TestFragment.newInstance())
            .commit()
    }

    companion object {
        fun newInstance() = RulesDialogFragment()
    }
}