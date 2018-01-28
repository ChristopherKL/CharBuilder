package com.chrisphil.charbuilder.importExportFragments

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.Toast
import com.chrisphil.charbuilder.MainNavigationDrawer
import com.chrisphil.charbuilder.Player

import com.chrisphil.charbuilder.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.storage.FirebaseStorage
import kotlinx.android.synthetic.main.fragment_import.view.*
import kotlinx.android.synthetic.main.import_export_listelement.view.*

class ImportFragment : Fragment() {


    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        var view = inflater!!.inflate(R.layout.fragment_import, container, false)

        view.back_button.setOnClickListener {
            fragmentManager
                    .beginTransaction()
                    .replace(R.id.content_frame, IEMenuFragment.newInstance(),"importExport")
                    .commit()
        }

        view.import_button.setOnClickListener {
            var fbstorage = FirebaseStorage.getInstance()
            var fbstorageReference = fbstorage.reference
            var userfolder = FirebaseAuth.getInstance().currentUser!!.uid + "/"
            var filename = "characters.json"
            var playerFileRef = fbstorageReference.child("chars/"+userfolder+filename)

            playerFileRef.getBytes(Long.MAX_VALUE).addOnSuccessListener {
                var player = String(it)
                MainNavigationDrawer.savePlayerListCloud(context,player)
                MainNavigationDrawer.loadPlayerList(context)
                view.listviewOnline.adapter = ImportListAdapter(context,MainNavigationDrawer.characterList)
                Toast.makeText(context,"Download erfolgreich", Toast.LENGTH_SHORT).show()
            }
        }

        return view
    }
    inner class ImportListAdapter(context : Context, var chars : ArrayList<Player>) : BaseAdapter(){
        override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
            val li = LayoutInflater.from(context)
            val view = li.inflate(R.layout.import_export_listelement,p2,false)
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
        fun newInstance(): ImportFragment {
            return ImportFragment()
        }
    }
}