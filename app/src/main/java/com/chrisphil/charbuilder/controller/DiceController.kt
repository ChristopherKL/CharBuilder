package com.chrisphil.charbuilder.controller

import android.support.v4.app.Fragment
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.chrisphil.charbuilder.R

/**
 * Created by Phil on 24.11.2017.
 */
class DiceController : Fragment() {

    companion object {
        fun newInstance(): DiceController {
            return DiceController()
        }
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view: View = inflater!!.inflate(R.layout.fragment_dice,container,false)

        return view
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)

    }
}