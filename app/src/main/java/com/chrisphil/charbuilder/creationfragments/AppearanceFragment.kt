package com.chrisphil.charbuilder.creationfragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.chrisphil.charbuilder.R
import com.chrisphil.charbuilder.controller.CharCreationController
import kotlinx.android.synthetic.main.char_creation_appearance.view.*

/**
 * Created by Christopher on 04.12.2017.
 */
class AppearanceFragment : Fragment(){

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater?.inflate(R.layout.char_creation_appearance, container, false)

        view?.genderEditText?.setOnFocusChangeListener { _, _ ->
            if (!view.genderEditText.hasFocus()) {
                CharCreationController.playerObject.gender = view.genderEditText.text.toString()
            }
        }
        if(CharCreationController.playerObject.gender != ""){view?.genderEditText?.setText(CharCreationController.playerObject.gender, TextView.BufferType.EDITABLE)}

        view?.birthdayEditText?.setOnFocusChangeListener { _, _ ->
            if(!view.birthdayEditText.hasFocus()){
                CharCreationController.playerObject.birthday = view.birthdayEditText?.text.toString()
            }
        }
        if(CharCreationController.playerObject.birthday != ""){view?.birthdayEditText?.setText(CharCreationController.playerObject.birthday, TextView.BufferType.EDITABLE)}

        view?.ageEditText?.setOnFocusChangeListener{ _, _ ->
            if(!view.ageEditText.hasFocus() && !view.ageEditText.text.isEmpty()) {
                CharCreationController.playerObject.age = view.birthdayEditText?.text.toString().toInt()
            }
        }
        if(CharCreationController.playerObject.age != 0){view?.ageEditText?.setText(CharCreationController.playerObject.age, TextView.BufferType.EDITABLE)}

        view?.heightEditText?.setOnFocusChangeListener{ _, _ ->
            if(!view.heightEditText.hasFocus() && !view.heightEditText.text.isEmpty()){
                CharCreationController.playerObject.height = view.heightEditText?.text.toString().toDouble()
            }
        }
        if(CharCreationController.playerObject.height != 0.0){view?.heightEditText?.setText(CharCreationController.playerObject.height.toString(), TextView.BufferType.EDITABLE)}

        view?.weightEditText?.setOnFocusChangeListener { _, _ ->
            if(!view.heightEditText.hasFocus() && !view.weightEditText.text.isEmpty()){
                CharCreationController.playerObject.weight = view.weightEditText?.text.toString().toDouble()
            }
        }
        if(CharCreationController.playerObject.weight != 0.0){view?.weightEditText?.setText(CharCreationController.playerObject.weight.toString(), TextView.BufferType.EDITABLE)}

        view?.haircolorEditText?.setOnFocusChangeListener { _, _ ->
            if(!view.haircolorEditText.hasFocus()){
                CharCreationController.playerObject.haircolor = view.haircolorEditText?.text.toString()
            }
        }
        if(CharCreationController.playerObject.haircolor != ""){view?.haircolorEditText?.setText(CharCreationController.playerObject.haircolor, TextView.BufferType.EDITABLE)}

        view?.eyecolorEditText?.setOnFocusChangeListener { _, _ ->
            if(!view.eyecolorEditText.hasFocus()){
                CharCreationController.playerObject.eyecolor = view.eyecolorEditText?.text.toString()
            }
        }
        if(CharCreationController.playerObject.eyecolor != ""){view?.eyecolorEditText?.setText(CharCreationController.playerObject.eyecolor, TextView.BufferType.EDITABLE)}

        view?.skincolorEditText?.setOnFocusChangeListener { _, _ ->
            if(!view.skincolorEditText.hasFocus()){
                CharCreationController.playerObject.skincolor = view.skincolorEditText?.text.toString()
            }
        }
        if(CharCreationController.playerObject.skincolor != ""){view?.skincolorEditText?.setText(CharCreationController.playerObject.skincolor, TextView.BufferType.EDITABLE)}

        view?.featuresEditText?.setOnFocusChangeListener { _, _ ->
            if(!view.featuresEditText.hasFocus()){
                CharCreationController.playerObject.features = view.featuresEditText?.text.toString()
            }
        }
        if(CharCreationController.playerObject.features != ""){view?.featuresEditText?.setText(CharCreationController.playerObject.features, TextView.BufferType.EDITABLE)}

        return view
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