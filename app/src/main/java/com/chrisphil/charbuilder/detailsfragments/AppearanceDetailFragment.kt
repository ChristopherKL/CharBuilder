package com.chrisphil.charbuilder.detailsfragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.chrisphil.charbuilder.R
import com.chrisphil.charbuilder.controller.CharDetailsController
import kotlinx.android.synthetic.main.char_creation_appearance.view.*

/**
 * Created by Christopher on 27.01.2018.
 */
class AppearanceDetailFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater!!.inflate(R.layout.char_creation_appearance, container, false)

        view.genderEditText?.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                CharDetailsController.playerObject.gender = view.genderEditText.text.toString()
            }
        })

        view.birthdayEditText?.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                CharDetailsController.playerObject.birthday = view.birthdayEditText?.text.toString()
            }
        })

        view.ageEditText?.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                if(view.heightEditText.text.isEmpty()){
                    CharDetailsController.playerObject.age = 0
                }
                else{
                    CharDetailsController.playerObject.age = view.ageEditText?.text.toString().toInt()
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
                    CharDetailsController.playerObject.height = 0.0
                }
                else{
                    CharDetailsController.playerObject.height = view.heightEditText?.text.toString().toDouble()
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
                    CharDetailsController.playerObject.weight = 0.0
                }
                else{
                    CharDetailsController.playerObject.weight = view.weightEditText?.text.toString().toDouble()
                }
            }
        })


        view.haircolorEditText?.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                CharDetailsController.playerObject.haircolor = view.haircolorEditText?.text.toString()
            }
        })

        view.eyecolorEditText?.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                CharDetailsController.playerObject.eyecolor = view.eyecolorEditText?.text.toString()
            }
        })

        view.skincolorEditText?.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                CharDetailsController.playerObject.skincolor = view.skincolorEditText?.text.toString()
            }
        })

        view.featuresEditText?.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                CharDetailsController.playerObject.features = view.featuresEditText?.text.toString()
            }
        })

        checkEditText(view)

        return view
    }

    private fun checkEditText(view : View){
        if(CharDetailsController.playerObject.gender != ""){view.genderEditText?.setText(CharDetailsController.playerObject.gender, TextView.BufferType.EDITABLE)}
        if(CharDetailsController.playerObject.birthday != ""){view.birthdayEditText?.setText(CharDetailsController.playerObject.birthday, TextView.BufferType.EDITABLE)}
        if(CharDetailsController.playerObject.age != 0){view.ageEditText?.setText(CharDetailsController.playerObject.age.toString(), TextView.BufferType.EDITABLE)}
        if(CharDetailsController.playerObject.height != 0.0){view.heightEditText?.setText(CharDetailsController.playerObject.height.toString(), TextView.BufferType.EDITABLE)}
        if(CharDetailsController.playerObject.weight != 0.0){view.weightEditText?.setText(CharDetailsController.playerObject.weight.toString(), TextView.BufferType.EDITABLE)}
        if(CharDetailsController.playerObject.haircolor != ""){view.haircolorEditText?.setText(CharDetailsController.playerObject.haircolor, TextView.BufferType.EDITABLE)}
        if(CharDetailsController.playerObject.eyecolor != ""){view.eyecolorEditText?.setText(CharDetailsController.playerObject.eyecolor, TextView.BufferType.EDITABLE)}
        if(CharDetailsController.playerObject.skincolor != ""){view.skincolorEditText?.setText(CharDetailsController.playerObject.skincolor, TextView.BufferType.EDITABLE)}
        if(CharDetailsController.playerObject.features != ""){view.featuresEditText?.setText(CharDetailsController.playerObject.features, TextView.BufferType.EDITABLE)}
    }

    companion object {

        private val ARG_SECTION_NUMBER = "section_number"

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        fun newInstance(sectionNumber: Int): AppearanceDetailFragment {
            val fragment = AppearanceDetailFragment()
            val args = Bundle()
            args.putInt(ARG_SECTION_NUMBER, sectionNumber)
            fragment.arguments = args
            return fragment
        }
    }
}