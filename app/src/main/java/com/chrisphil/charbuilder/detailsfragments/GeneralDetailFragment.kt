package com.chrisphil.charbuilder.detailsfragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.chrisphil.charbuilder.R
import com.chrisphil.charbuilder.controller.CharDetailsController
import kotlinx.android.synthetic.main.char_details_general.view.*

/**
 * Created by Christopher on 27.01.2018.
 */
class GeneralDetailFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var view = inflater!!.inflate(R.layout.char_details_general, container, false)

        setTextViewValues()
        return view
    }

    private fun setTextViewValues(){
        view?.general_species_value?.text = CharDetailsController.playerObject.species
        view?.general_career_value?.text = CharDetailsController.playerObject.career
        view?.general_specialization_value?.text = CharDetailsController.playerObject.specialization
        view?.general_obligation1_value?.text = CharDetailsController.playerObject.obligation
        view?.general_obligation2_value?.text = CharDetailsController.playerObject.obligation2
        view?.general_motivation1_value?.text = CharDetailsController.playerObject.motivation
        view?.general_motivation2_value?.text = CharDetailsController.playerObject.motivation2

        view?.attribute_brawn_value?.text = CharDetailsController.playerObject.brawn.toString()
        view?.attribute_agility?.text = CharDetailsController.playerObject.agility.toString()
        view?.attribute_intellect_value?.text = CharDetailsController.playerObject.intellect.toString()
        view?.attribute_cunning_value?.text = CharDetailsController.playerObject.cunning.toString()
        view?.attribute_willpower_value?.text = CharDetailsController.playerObject.willpower.toString()
        view?.attribute_presence_value?.text = CharDetailsController.playerObject.presence.toString()
        view?.attribute_woundthreshold_value?.text = CharDetailsController.playerObject.woundThreshold.toString()
        view?.attribute_strainthreshold_value?.text = CharDetailsController.playerObject.strainThreshold.toString()
        view?.attribute_defense_value?.text = CharDetailsController.playerObject.defense.toString()
        view?.attribute_soakvalue_value?.text = CharDetailsController.playerObject.soakValue.toString()
    }

    companion object {

        private val ARG_SECTION_NUMBER = "section_number"

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        fun newInstance(sectionNumber: Int): GeneralDetailFragment {
            val fragment = GeneralDetailFragment()
            val args = Bundle()
            args.putInt(ARG_SECTION_NUMBER, sectionNumber)
            fragment.arguments = args
            return fragment
        }
    }
}