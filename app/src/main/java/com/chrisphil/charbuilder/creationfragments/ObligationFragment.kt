package com.chrisphil.charbuilder.creationfragments

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.chrisphil.charbuilder.R
import com.chrisphil.charbuilder.interfaces.OnDataPass

/**
 * Created by Christopher on 04.12.2017.
 */
class ObligationFragment : Fragment() {

    lateinit var dataPass : OnDataPass

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater?.inflate(R.layout.char_creation_obligation, container, false);
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
}