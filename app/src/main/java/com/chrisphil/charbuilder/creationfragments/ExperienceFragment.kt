package com.chrisphil.charbuilder.creationfragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.chrisphil.charbuilder.R
import android.content.Intent
import android.content.BroadcastReceiver
import android.content.Context
import android.content.IntentFilter
import android.support.v4.content.LocalBroadcastManager



/**
 * Created by Christopher on 04.12.2017.
 */
class ExperienceFragment : Fragment() {

    private lateinit var r : BRReceiver

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater?.inflate(R.layout.char_creation_specialization, container, false)
        r = BRReceiver()
        return view
    }

    fun refresh() {
        Log.d("LOG","Ich wurde aufgerufen")
    }

    override fun onPause() {
        super.onPause()
        LocalBroadcastManager.getInstance(context).unregisterReceiver(r)
    }

    override fun onResume() {
        super.onResume()
        r = BRReceiver()
        LocalBroadcastManager.getInstance(context).registerReceiver(r,
                IntentFilter("SPEC_REFRESH"))
    }

    private inner class BRReceiver : BroadcastReceiver() {
        override fun onReceive(context: Context, intent: Intent) {
            this@ExperienceFragment.refresh()
        }
    }

    companion object {

        private val ARG_SECTION_NUMBER = "section_number"

        fun newInstance(sectionNumber: Int): ExperienceFragment {
            val fragment = ExperienceFragment()
            val args = Bundle()
            args.putInt(ARG_SECTION_NUMBER, sectionNumber)
            fragment.arguments = args
            return fragment
        }
    }
}