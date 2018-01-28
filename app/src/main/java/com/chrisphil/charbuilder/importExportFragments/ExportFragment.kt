package com.chrisphil.charbuilder.importExportFragments


import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.chrisphil.charbuilder.MainNavigationDrawer
import com.chrisphil.charbuilder.Player

import com.chrisphil.charbuilder.R
import kotlinx.android.synthetic.main.fragment_export.view.*
import kotlinx.android.synthetic.main.import_export_listelement.view.*

class ExportFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        var view = inflater!!.inflate(R.layout.fragment_export, container, false)

        view.listviewOffline.adapter = CharListAdapter(MainNavigationDrawer.characterList)
        Log.d("test","grgrgrgrgrg: " + MainNavigationDrawer.characterList.count().toString())

        view.back_button.setOnClickListener {
            fragmentManager
                    .beginTransaction()
                    .replace(R.id.content_frame, IEMenuFragment.newInstance(),"importExport")
                    .commit()
        }

        return view
    }


    inner class CharListAdapter(var chars : ArrayList<Player>) : BaseAdapter(){
        override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
            val li = LayoutInflater.from(context)
            val view = li.inflate(R.layout.import_export_listelement,p2,false)
            Log.d("Test",chars.count().toString())
            view.elementName.text = chars[p0].name
            view.elementSpecies.text = chars[p0].species

            return view
        }

        override fun getItem(p0: Int): Any {
            return chars[p0]
        }

        override fun getItemId(p0: Int): Long {
            return p0.toLong()
        }

        override fun getCount(): Int {
            return chars.count()
        }

    }


    companion object {
        fun newInstance(): ExportFragment {
            return ExportFragment()
        }
    }
}
