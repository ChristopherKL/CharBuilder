package com.chrisphil.charbuilder.controller

import android.content.Context
import android.content.Intent
import android.support.v4.app.Fragment
import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.chrisphil.charbuilder.CharAdapter
import com.chrisphil.charbuilder.CharInfo
import com.chrisphil.charbuilder.R

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
        recList.adapter = CharAdapter(createList(30))

        var fab = view.findViewById<FloatingActionButton>(R.id.newCharButton) as FloatingActionButton
        fab.setOnClickListener{
            val intent = Intent(context,CharCreationController::class.java)
            startActivityForResult(intent,0)
        }
        return view
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)

    }



    private fun createList(size : Int) : List<CharInfo>{
        var liste : MutableList<CharInfo> = mutableListOf<CharInfo>()
        for (i in 1..size){
            var ci : CharInfo = CharInfo("Peter Zwegert" + i,"Star Wars : Am Rande des Imperiums")
            liste.add(ci)
        }
        return liste
    }
}