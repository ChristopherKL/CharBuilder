package com.chrisphil.charbuilder

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView;
import android.view.Menu
import android.view.MenuItem

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var recList = findViewById<RecyclerView>(R.id.cardList) as RecyclerView
        recList.setHasFixedSize(true)
        var llm = LinearLayoutManager(this)
        llm.orientation = LinearLayoutManager.VERTICAL
        recList.layoutManager = llm
        setSupportActionBar(toolbar)

        var ca : CharAdapter = CharAdapter(createList(30))
        recList.adapter = ca

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }
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
