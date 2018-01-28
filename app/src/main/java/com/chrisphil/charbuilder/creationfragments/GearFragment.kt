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
import kotlinx.android.synthetic.main.char_creation_gear.view.*

/**
 * Created by Christopher on 04.12.2017.
 */
class GearFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater!!.inflate(R.layout.char_creation_gear, container, false)

        view.weaponName1?.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                CharCreationController.playerObject.weapons[0] = view.weaponName1.text.toString()
            }
        })

        view.weaponName2?.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                CharCreationController.playerObject.weapons[1] = view.weaponName2.text.toString()
            }
        })

        view?.weaponName3?.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                CharCreationController.playerObject.weapons[2] = view.weaponName3.text.toString()
            }
        })

        view.weaponDamage1?.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                CharCreationController.playerObject.weaponDamage[0] = view.weaponDamage1.text.toString()
            }
        })

        view.weaponDamage2?.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                CharCreationController.playerObject.weaponDamage[1] = view.weaponDamage2.text.toString()
            }
        })

        view.weaponDamage3?.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                CharCreationController.playerObject.weaponDamage[2] = view.weaponDamage3.text.toString()
            }
        })

        view.itemName1?.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                CharCreationController.playerObject.items[0] = view.itemName1.text.toString()
            }
        })

        view.itemName2?.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                CharCreationController.playerObject.items[1] = view.itemName2.text.toString()
            }
        })

        view.itemName3?.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                CharCreationController.playerObject.items[2] = view.itemName3.text.toString()
            }
        })

        view.itemName4?.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                CharCreationController.playerObject.items[3] = view.itemName4.text.toString()
            }
        })

        view.itemName5?.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                CharCreationController.playerObject.items[4] = view.itemName5.text.toString()
            }
        })

        view.commentText1?.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                CharCreationController.playerObject.itemAnnotations[0] = view.commentText1.text.toString()
            }
        })

        view?.commentText2?.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                CharCreationController.playerObject.itemAnnotations[1] = view.commentText2.text.toString()
            }
        })

        view.commentText3?.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                CharCreationController.playerObject.itemAnnotations[2] = view.commentText3.text.toString()
            }
        })

        view.commentText4?.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                CharCreationController.playerObject.itemAnnotations[3] = view.commentText4.text.toString()
            }
        })

        view.commentText5?.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                CharCreationController.playerObject.itemAnnotations[4] = view.commentText5.text.toString()
            }
        })

        view.creditsText?.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                if(view.creditsText.text.isEmpty()){
                    CharCreationController.playerObject.credits = 0
                }
                else{
                    CharCreationController.playerObject.credits = view.creditsText.text.toString().toInt()
                }
            }
        })

        checkEditText(view)

        return view
    }

    private fun checkEditText(view : View){
        if(CharCreationController.playerObject.weapons[0] != ""){view.weaponName1?.setText(CharCreationController.playerObject.weapons[0], TextView.BufferType.EDITABLE)}
        if(CharCreationController.playerObject.weapons[1] != ""){view.weaponName2?.setText(CharCreationController.playerObject.weapons[1], TextView.BufferType.EDITABLE)}
        if(CharCreationController.playerObject.weapons[2] != ""){view.weaponName3?.setText(CharCreationController.playerObject.weapons[2], TextView.BufferType.EDITABLE)}
        if(CharCreationController.playerObject.weaponDamage[0] != ""){view.weaponDamage1?.setText(CharCreationController.playerObject.weaponDamage[0], TextView.BufferType.EDITABLE)}
        if(CharCreationController.playerObject.weaponDamage[1] != ""){view.weaponDamage2?.setText(CharCreationController.playerObject.weaponDamage[1], TextView.BufferType.EDITABLE)}
        if(CharCreationController.playerObject.weaponDamage[2] != ""){view.weaponDamage3?.setText(CharCreationController.playerObject.weaponDamage[2], TextView.BufferType.EDITABLE)}
        if(CharCreationController.playerObject.items[0] != ""){view.itemName1?.setText(CharCreationController.playerObject.items[0], TextView.BufferType.EDITABLE)}
        if(CharCreationController.playerObject.items[1] != ""){view.itemName2?.setText(CharCreationController.playerObject.items[1], TextView.BufferType.EDITABLE)}
        if(CharCreationController.playerObject.items[2] != ""){view.itemName3?.setText(CharCreationController.playerObject.items[2], TextView.BufferType.EDITABLE)}
        if(CharCreationController.playerObject.items[3] != ""){view.itemName4?.setText(CharCreationController.playerObject.items[3], TextView.BufferType.EDITABLE)}
        if(CharCreationController.playerObject.items[4] != ""){view.itemName5?.setText(CharCreationController.playerObject.items[4], TextView.BufferType.EDITABLE)}
        if(CharCreationController.playerObject.itemAnnotations[0] != ""){view.commentText1?.setText(CharCreationController.playerObject.itemAnnotations[0], TextView.BufferType.EDITABLE)}
        if(CharCreationController.playerObject.itemAnnotations[1] != ""){view.commentText2?.setText(CharCreationController.playerObject.itemAnnotations[1], TextView.BufferType.EDITABLE)}
        if(CharCreationController.playerObject.itemAnnotations[2] != ""){view.commentText3?.setText(CharCreationController.playerObject.itemAnnotations[2], TextView.BufferType.EDITABLE)}
        if(CharCreationController.playerObject.itemAnnotations[3] != ""){view.commentText4?.setText(CharCreationController.playerObject.itemAnnotations[3], TextView.BufferType.EDITABLE)}
        if(CharCreationController.playerObject.itemAnnotations[4] != ""){view.commentText5?.setText(CharCreationController.playerObject.itemAnnotations[4], TextView.BufferType.EDITABLE)}
        if(CharCreationController.playerObject.credits != 0){view.creditsText?.setText(CharCreationController.playerObject.credits.toString(), TextView.BufferType.EDITABLE)}
    }

    companion object {

        private val ARG_SECTION_NUMBER = "section_number"

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        fun newInstance(sectionNumber: Int): GearFragment {
            val fragment = GearFragment()
            val args = Bundle()
            args.putInt(ARG_SECTION_NUMBER, sectionNumber)
            fragment.arguments = args
            return fragment
        }
    }
}