package com.chrisphil.charbuilder.detailsfragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.chrisphil.charbuilder.R
import com.chrisphil.charbuilder.controller.CharDetailsController
import kotlinx.android.synthetic.main.char_creation_gear.view.*

/**
 * Created by Christopher on 27.01.2018.
 */
class GearDetailFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater!!.inflate(R.layout.char_creation_gear, container, false)

        view?.weaponName1?.setOnFocusChangeListener { _, _ ->
            if (!view.weaponName1.hasFocus()) {
                CharDetailsController.playerObject.weapons[0] = view.weaponName1.text.toString()
            }
        }

        view?.weaponName2?.setOnFocusChangeListener { _, _ ->
            if (!view.weaponName1.hasFocus()) {
                CharDetailsController.playerObject.weapons[1] = view.weaponName2.text.toString()
            }
        }

        view?.weaponName3?.setOnFocusChangeListener { _, _ ->
            if (!view.weaponName3.hasFocus()) {
                CharDetailsController.playerObject.weapons[2] = view.weaponName3.text.toString()
            }
        }

        view?.weaponDamage1?.setOnFocusChangeListener { _, _ ->
            if (!view.weaponDamage1.hasFocus()) {
                CharDetailsController.playerObject.weaponDamage[0] = view.weaponDamage1.text.toString()
            }
        }

        view?.weaponDamage2?.setOnFocusChangeListener { _, _ ->
            if (!view.weaponDamage2.hasFocus()) {
                CharDetailsController.playerObject.weaponDamage[1] = view.weaponDamage2.text.toString()
            }
        }

        view?.weaponDamage3?.setOnFocusChangeListener { _, _ ->
            if (!view.weaponDamage3.hasFocus()) {
                CharDetailsController.playerObject.weaponDamage[2] = view.weaponDamage3.text.toString()
            }
        }

        view?.itemName1?.setOnFocusChangeListener { _, _ ->
            if (!view.itemName1.hasFocus()) {
                CharDetailsController.playerObject.items[0] = view.itemName1.text.toString()
            }
        }

        view?.itemName2?.setOnFocusChangeListener { _, _ ->
            if (!view.itemName2.hasFocus()) {
                CharDetailsController.playerObject.items[1] = view.itemName2.text.toString()
            }
        }

        view?.itemName3?.setOnFocusChangeListener { _, _ ->
            if (!view.itemName3.hasFocus()) {
                CharDetailsController.playerObject.items[2] = view.itemName3.text.toString()
            }
        }

        view?.itemName4?.setOnFocusChangeListener { _, _ ->
            if (!view.itemName4.hasFocus()) {
                CharDetailsController.playerObject.items[3] = view.itemName4.text.toString()
            }
        }

        view?.itemName5?.setOnFocusChangeListener { _, _ ->
            if (!view.itemName5.hasFocus()) {
                CharDetailsController.playerObject.items[4] = view.itemName5.text.toString()
            }
        }

        view?.commentText1?.setOnFocusChangeListener { _, _ ->
            if (!view.commentText1.hasFocus()) {
                CharDetailsController.playerObject.itemAnnotations[0] = view.commentText1.text.toString()
            }
        }

        view?.commentText2?.setOnFocusChangeListener { _, _ ->
            if (!view.commentText2.hasFocus()) {
                CharDetailsController.playerObject.itemAnnotations[1] = view.commentText2.text.toString()
            }
        }

        view?.commentText3?.setOnFocusChangeListener { _, _ ->
            if (!view.commentText3.hasFocus()) {
                CharDetailsController.playerObject.itemAnnotations[2] = view.commentText3.text.toString()
            }
        }

        view?.commentText4?.setOnFocusChangeListener { _, _ ->
            if (!view.commentText4.hasFocus()) {
                CharDetailsController.playerObject.itemAnnotations[3] = view.commentText4.text.toString()
            }
        }

        view?.commentText5?.setOnFocusChangeListener { _, _ ->
            if (!view.commentText5.hasFocus()) {
                CharDetailsController.playerObject.itemAnnotations[4] = view.commentText5.text.toString()
            }
        }

        view?.creditsText?.setOnFocusChangeListener { _, _ ->
            if (!view.creditsText.hasFocus() && !view.creditsText.text.isEmpty()) {
                CharDetailsController.playerObject.credits = view.creditsText.text.toString().toInt()
            }
        }

        checkEditText()

        return view
    }

    private fun checkEditText(){
        if(CharDetailsController.playerObject.weapons[0] != ""){view?.weaponName1?.setText(CharDetailsController.playerObject.weapons[0], TextView.BufferType.EDITABLE)}
        if(CharDetailsController.playerObject.weapons[1] != ""){view?.weaponName2?.setText(CharDetailsController.playerObject.weapons[1], TextView.BufferType.EDITABLE)}
        if(CharDetailsController.playerObject.weapons[2] != ""){view?.weaponName3?.setText(CharDetailsController.playerObject.weapons[2], TextView.BufferType.EDITABLE)}
        if(CharDetailsController.playerObject.weaponDamage[0] != ""){view?.weaponDamage1?.setText(CharDetailsController.playerObject.weaponDamage[0], TextView.BufferType.EDITABLE)}
        if(CharDetailsController.playerObject.weaponDamage[1] != ""){view?.weaponDamage2?.setText(CharDetailsController.playerObject.weaponDamage[1], TextView.BufferType.EDITABLE)}
        if(CharDetailsController.playerObject.weaponDamage[2] != ""){view?.weaponDamage3?.setText(CharDetailsController.playerObject.weaponDamage[2], TextView.BufferType.EDITABLE)}
        if(CharDetailsController.playerObject.items[0] != ""){view?.itemName1?.setText(CharDetailsController.playerObject.items[0], TextView.BufferType.EDITABLE)}
        if(CharDetailsController.playerObject.items[1] != ""){view?.itemName2?.setText(CharDetailsController.playerObject.items[1], TextView.BufferType.EDITABLE)}
        if(CharDetailsController.playerObject.items[2] != ""){view?.itemName3?.setText(CharDetailsController.playerObject.items[2], TextView.BufferType.EDITABLE)}
        if(CharDetailsController.playerObject.items[3] != ""){view?.itemName4?.setText(CharDetailsController.playerObject.items[3], TextView.BufferType.EDITABLE)}
        if(CharDetailsController.playerObject.items[4] != ""){view?.itemName5?.setText(CharDetailsController.playerObject.items[4], TextView.BufferType.EDITABLE)}
        if(CharDetailsController.playerObject.itemAnnotations[0] != ""){view?.commentText1?.setText(CharDetailsController.playerObject.itemAnnotations[0], TextView.BufferType.EDITABLE)}
        if(CharDetailsController.playerObject.itemAnnotations[1] != ""){view?.commentText2?.setText(CharDetailsController.playerObject.itemAnnotations[1], TextView.BufferType.EDITABLE)}
        if(CharDetailsController.playerObject.itemAnnotations[2] != ""){view?.commentText3?.setText(CharDetailsController.playerObject.itemAnnotations[2], TextView.BufferType.EDITABLE)}
        if(CharDetailsController.playerObject.itemAnnotations[3] != ""){view?.commentText4?.setText(CharDetailsController.playerObject.itemAnnotations[3], TextView.BufferType.EDITABLE)}
        if(CharDetailsController.playerObject.itemAnnotations[4] != ""){view?.commentText5?.setText(CharDetailsController.playerObject.itemAnnotations[4], TextView.BufferType.EDITABLE)}
        if(CharDetailsController.playerObject.credits != 0){view?.creditsText?.setText(CharDetailsController.playerObject.credits, TextView.BufferType.EDITABLE)}
    }

    companion object {

        private val ARG_SECTION_NUMBER = "section_number"

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        fun newInstance(sectionNumber: Int): GearDetailFragment {
            val fragment = GearDetailFragment()
            val args = Bundle()
            args.putInt(ARG_SECTION_NUMBER, sectionNumber)
            fragment.arguments = args
            return fragment
        }
    }
}