package com.chrisphil.charbuilder.importExportFragments


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.chrisphil.charbuilder.R
import kotlinx.android.synthetic.main.fragment_export.view.*

class ExportFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        var view = inflater!!.inflate(R.layout.fragment_export, container, false)

        view.back_button.setOnClickListener {
            fragmentManager
                    .beginTransaction()
                    .replace(R.id.content_frame, IEMenuFragment.newInstance(),"importExport")
                    .commit()
        }

        return view
    }

    companion object {
        fun newInstance(): ExportFragment {
            return ExportFragment()
        }
    }
}
