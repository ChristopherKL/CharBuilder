package com.chrisphil.charbuilder.controller

import android.content.Intent
import android.support.v4.app.Fragment
import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.chrisphil.charbuilder.CharAdapter
import com.chrisphil.charbuilder.CharInfo
import com.chrisphil.charbuilder.MainNavigationDrawer
import com.chrisphil.charbuilder.R
import kotlinx.android.synthetic.main.char_list_view.*

/**
 * Created by Phil on 24.11.2017.
 */
class CharListController : Fragment(){

    companion object {
        fun newInstance(): CharListController {
            return CharListController()
        }
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view: View = inflater!!.inflate(R.layout.char_list_view,container,false)

        var recList = view.findViewById<RecyclerView>(R.id.cardList) as RecyclerView
        recList.layoutManager = LinearLayoutManager(activity)
        recList.adapter = CharAdapter(MainNavigationDrawer.characterList,context)

        var fab = view.findViewById<FloatingActionButton>(R.id.newCharButton) as FloatingActionButton
        fab.setOnClickListener{
            val intent = Intent(context,CharCreationController::class.java)
            startActivityForResult(intent,0)
        }
        return view
    }

    override fun onStart() {
        super.onStart()
        cardList.adapter.notifyDataSetChanged()
    }
}