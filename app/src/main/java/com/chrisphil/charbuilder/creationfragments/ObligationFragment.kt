package com.chrisphil.charbuilder.creationfragments

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.chrisphil.charbuilder.R
import com.chrisphil.charbuilder.interfaces.OnDataPass
import kotlinx.android.synthetic.main.char_creation_motivation.*
import kotlinx.android.synthetic.main.char_creation_obligation.*
import java.util.*

/**
 * Created by Christopher on 04.12.2017.
 */
class ObligationFragment : Fragment() {

    lateinit var dataPass : OnDataPass

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater?.inflate(R.layout.char_creation_motivation, container, false)
        random_motivation_button.setOnClickListener{
            val obligationResult : Int = Random().nextInt(100)+1
            when(obligationResult) {
                in 1..96 -> chooseObligation(obligationResult)
                in 97..100 -> chooseTwoObligations()
            }
        }
        return view
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        dataPass = context as OnDataPass
    }

    companion object {

        private val ARG_SECTION_NUMBER = "section_number"

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        fun newInstance(sectionNumber: Int): ObligationFragment {
            val fragment = ObligationFragment()
            val args = Bundle()
            args.putInt(ARG_SECTION_NUMBER, sectionNumber)
            fragment.arguments = args
            return fragment
        }
    }

    override fun onDestroyView() {
        dataPass.onDataPass("TODO")
        super.onDestroyView()
    }

    private fun chooseObligation(result : Int){
        when(result){
            in 1..8 -> selected_obligation.text = getString(R.string.obligation_addiction)
            in 9..16 -> selected_obligation.text = getString(R.string.obligation_betrayal)
            in 17..24 -> selected_obligation.text = getString(R.string.obligation_blackmail)
            in 25..32 -> selected_obligation.text = getString(R.string.obligation_bounty)
            in 33..40 -> selected_obligation.text = getString(R.string.obligation_criminal)
            in 41..48 -> selected_obligation.text = getString(R.string.obligation_debt)
            in 49..56 -> selected_obligation.text = getString(R.string.obligation_dutybound)
            in 57..64 -> selected_obligation.text = getString(R.string.obligation_family)
            in 65..72 -> selected_obligation.text = getString(R.string.obligation_favor)
            in 73..80 -> selected_obligation.text = getString(R.string.obligation_oath)
            in 81..88 -> selected_obligation.text = getString(R.string.obligation_obsession)
            in 89..96 -> selected_obligation.text = getString(R.string.obligation_responsibility)
        }
    }

    private fun chooseTwoObligations(){
        
    }
}