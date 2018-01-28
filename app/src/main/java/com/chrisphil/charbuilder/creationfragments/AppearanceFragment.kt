package com.chrisphil.charbuilder.creationfragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.chrisphil.charbuilder.R
import com.chrisphil.charbuilder.controller.CharCreationController
import kotlinx.android.synthetic.main.char_creation_appearance.view.*

/**
 * This Fragment contains every info of the characters appearance during character creation.
 * The user can choose the character's gender, birthday, age, height, weight, haircolor, eyecolor and skincolor
 *
 * @author Christopher Kluck
 */
class AppearanceFragment : Fragment(){

    /**
     * Inflates the layout and sets OnFocusChangeListeners for every EditText
     */
    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater!!.inflate(R.layout.char_creation_appearance, container, false)

        view.genderEditText?.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                CharCreationController.playerObject.gender = view.genderEditText.text.toString()
            }
        })

        view.birthdayEditText?.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                CharCreationController.playerObject.birthday = view.birthdayEditText?.text.toString()
            }
        })

        view.ageEditText?.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                if(view.heightEditText.text.isEmpty()){
                    CharCreationController.playerObject.age = 0
                }
                else{
                    CharCreationController.playerObject.age = view.ageEditText?.text.toString().toInt()
                }
            }
        })

        view.heightEditText?.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                if(view.heightEditText.text.isEmpty()){
                    CharCreationController.playerObject.height = 0.0
                }
                else{
                    CharCreationController.playerObject.height = view.heightEditText?.text.toString().toDouble()
                }
            }
        })

        view.weightEditText?.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                if(view.weightEditText.text.isEmpty()){
                    CharCreationController.playerObject.weight = 0.0
                }
                else{
                    CharCreationController.playerObject.weight = view.weightEditText?.text.toString().toDouble()
                }
            }
        })


        view.haircolorEditText?.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                CharCreationController.playerObject.haircolor = view.haircolorEditText?.text.toString()
            }
        })

        view.eyecolorEditText?.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                CharCreationController.playerObject.eyecolor = view.eyecolorEditText?.text.toString()
            }
        })

        view.skincolorEditText?.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                CharCreationController.playerObject.skincolor = view.skincolorEditText?.text.toString()
            }
        })

        view.featuresEditText?.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                CharCreationController.playerObject.features = view.featuresEditText?.text.toString()
            }
        })

        checkEditText()

        return view
    }

    /**
     * User input for EditTexts gets restored if the according attributes of playerObject are set
     */
    private fun checkEditText(){
        if(CharCreationController.playerObject.gender != ""){view?.genderEditText?.setText(CharCreationController.playerObject.gender, TextView.BufferType.EDITABLE)}
        if(CharCreationController.playerObject.birthday != ""){view?.birthdayEditText?.setText(CharCreationController.playerObject.birthday, TextView.BufferType.EDITABLE)}
        if(CharCreationController.playerObject.age != 0){view?.ageEditText?.setText(CharCreationController.playerObject.age, TextView.BufferType.EDITABLE)}
        if(CharCreationController.playerObject.height != 0.0){view?.heightEditText?.setText(CharCreationController.playerObject.height.toString(), TextView.BufferType.EDITABLE)}
        if(CharCreationController.playerObject.weight != 0.0){view?.weightEditText?.setText(CharCreationController.playerObject.weight.toString(), TextView.BufferType.EDITABLE)}
        if(CharCreationController.playerObject.haircolor != ""){view?.haircolorEditText?.setText(CharCreationController.playerObject.haircolor, TextView.BufferType.EDITABLE)}
        if(CharCreationController.playerObject.eyecolor != ""){view?.eyecolorEditText?.setText(CharCreationController.playerObject.eyecolor, TextView.BufferType.EDITABLE)}
        if(CharCreationController.playerObject.skincolor != ""){view?.skincolorEditText?.setText(CharCreationController.playerObject.skincolor, TextView.BufferType.EDITABLE)}
        if(CharCreationController.playerObject.features != ""){view?.featuresEditText?.setText(CharCreationController.playerObject.features, TextView.BufferType.EDITABLE)}
    }

    companion object {

        private val ARG_SECTION_NUMBER = "section_number"

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        fun newInstance(sectionNumber: Int): AppearanceFragment {
            val fragment = AppearanceFragment()
            val args = Bundle()
            args.putInt(ARG_SECTION_NUMBER, sectionNumber)
            fragment.arguments = args
            return fragment
        }
    }
}