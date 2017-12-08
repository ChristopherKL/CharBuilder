package com.chrisphil.charbuilder.creationfragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.chrisphil.charbuilder.R

/**
 * Created by Christopher on 04.12.2017.
 */
class CareerFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater?.inflate(R.layout.char_creation_career, container, false);
    }
}