package com.chrisphil.charbuilder.creationfragments

import android.app.AlertDialog
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.chrisphil.charbuilder.Player
import com.chrisphil.charbuilder.R
import com.chrisphil.charbuilder.controller.CharCreationController
import kotlinx.android.synthetic.main.char_creation_completion.view.*

/**
 * Created by Christopher on 26.01.2018.
 */
class CompletionFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater!!.inflate(R.layout.char_creation_completion, container, false)

        view.char_name_input_field.setOnFocusChangeListener { _, _ ->
            if (!view.char_name_input_field.hasFocus()) {
                CharCreationController.playerObject.name = view.char_name_input_field.text.toString()
            }
        }
        if(CharCreationController.playerObject.name != ""){view?.char_name_input_field?.setText(CharCreationController.playerObject.name, TextView.BufferType.EDITABLE)}

        view.completion_button.setOnClickListener {
            val player : Player = CharCreationController.playerObject
            if(player.obligation != "" && player.species != "" && player.specialization != "" && player.motivation != "" && player.name != ""){
                CharCreationController.saveCurrentPlayer()
                activity.finish()
            }
            else{
                showCompletionDialogue()
            }
        }

        return view
    }

    private fun showCompletionDialogue() {
        var dialogBuilder = AlertDialog.Builder(context)
        dialogBuilder.setTitle(getString(R.string.dialog_missing_values_title))
        var messageString : String = getString(R.string.dialog_missing_values_string)
        if(CharCreationController.playerObject.obligation == ""){messageString += "- " + getString(R.string.cc_obligation) + "\n"}
        if(CharCreationController.playerObject.species == ""){messageString += "- " + getString(R.string.cc_species) + "\n"}
        if(CharCreationController.playerObject.specialization == ""){messageString += "- " + getString(R.string.cc_specialization) + "\n"}
        if(CharCreationController.playerObject.motivation == ""){messageString += "- " + getString(R.string.cc_motivation) + "\n"}
        if(CharCreationController.playerObject.name == ""){messageString += "- " + getString(R.string.character_name)}
        dialogBuilder.setMessage(messageString)
        val dialog = dialogBuilder.create()
        dialog.setButton(AlertDialog.BUTTON_NEUTRAL,getString(R.string.dialog_ok),{
            _, _ ->
            dialog.dismiss()
        })
        dialog.show()
    }

    companion object {

        private val ARG_SECTION_NUMBER = "section_number"

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        fun newInstance(sectionNumber: Int): CompletionFragment {
            val fragment = CompletionFragment()
            val args = Bundle()
            args.putInt(ARG_SECTION_NUMBER, sectionNumber)
            fragment.arguments = args
            return fragment
        }
    }
}