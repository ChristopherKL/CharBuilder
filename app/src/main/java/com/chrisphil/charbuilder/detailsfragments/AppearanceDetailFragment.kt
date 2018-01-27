package com.chrisphil.charbuilder.detailsfragments

import android.os.Bundle
import android.support.v4.app.Fragment
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

        view?.genderEditText?.setOnFocusChangeListener { _, _ ->
            if (!view.genderEditText.hasFocus()) {
                CharDetailsController.playerObject.gender = view.genderEditText.text.toString()
            }
        }

        view?.birthdayEditText?.setOnFocusChangeListener { _, _ ->
            if(!view.birthdayEditText.hasFocus()){
                CharDetailsController.playerObject.birthday = view.birthdayEditText?.text.toString()
            }
        }

        view?.ageEditText?.setOnFocusChangeListener{ _, _ ->
            if(!view.ageEditText.hasFocus() && !view.ageEditText.text.isEmpty()) {
                CharDetailsController.playerObject.age = view.birthdayEditText?.text.toString().toInt()
            }
        }

        view?.heightEditText?.setOnFocusChangeListener{ _, _ ->
            if(!view.heightEditText.hasFocus() && !view.heightEditText.text.isEmpty()){
                CharDetailsController.playerObject.height = view.heightEditText?.text.toString().toDouble()
            }
        }

        view?.weightEditText?.setOnFocusChangeListener { _, _ ->
            if(!view.heightEditText.hasFocus() && !view.weightEditText.text.isEmpty()){
                CharDetailsController.playerObject.weight = view.weightEditText?.text.toString().toDouble()
            }
        }

        view?.haircolorEditText?.setOnFocusChangeListener { _, _ ->
            if(!view.haircolorEditText.hasFocus()){
                CharDetailsController.playerObject.haircolor = view.haircolorEditText?.text.toString()
            }
        }

        view?.eyecolorEditText?.setOnFocusChangeListener { _, _ ->
            if(!view.eyecolorEditText.hasFocus()){
                CharDetailsController.playerObject.eyecolor = view.eyecolorEditText?.text.toString()
            }
        }

        view?.skincolorEditText?.setOnFocusChangeListener { _, _ ->
            if(!view.skincolorEditText.hasFocus()){
                CharDetailsController.playerObject.skincolor = view.skincolorEditText?.text.toString()
            }
        }

        checkEditText()

        return view
    }

    private fun checkEditText(){
        if(CharDetailsController.playerObject.gender != ""){view?.genderEditText?.setText(CharDetailsController.playerObject.gender, TextView.BufferType.EDITABLE)}
        if(CharDetailsController.playerObject.birthday != ""){view?.birthdayEditText?.setText(CharDetailsController.playerObject.birthday, TextView.BufferType.EDITABLE)}
        if(CharDetailsController.playerObject.age != 0){view?.ageEditText?.setText(CharDetailsController.playerObject.age, TextView.BufferType.EDITABLE)}
        if(CharDetailsController.playerObject.height != 0.0){view?.heightEditText?.setText(CharDetailsController.playerObject.height.toString(), TextView.BufferType.EDITABLE)}
        if(CharDetailsController.playerObject.weight != 0.0){view?.weightEditText?.setText(CharDetailsController.playerObject.weight.toString(), TextView.BufferType.EDITABLE)}
        if(CharDetailsController.playerObject.haircolor != ""){view?.haircolorEditText?.setText(CharDetailsController.playerObject.haircolor, TextView.BufferType.EDITABLE)}
        if(CharDetailsController.playerObject.eyecolor != ""){view?.eyecolorEditText?.setText(CharDetailsController.playerObject.eyecolor, TextView.BufferType.EDITABLE)}
        if(CharDetailsController.playerObject.skincolor != ""){view?.skincolorEditText?.setText(CharDetailsController.playerObject.skincolor, TextView.BufferType.EDITABLE)}
        if(CharDetailsController.playerObject.features != ""){view?.featuresEditText?.setText(CharDetailsController.playerObject.features, TextView.BufferType.EDITABLE)}
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