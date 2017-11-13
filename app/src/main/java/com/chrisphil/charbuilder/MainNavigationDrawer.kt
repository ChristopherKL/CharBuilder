package com.chrisphil.charbuilder

import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_main_navigation_drawer.*
import kotlinx.android.synthetic.main.app_bar_main_navigation_drawer.*

class MainNavigationDrawer : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_navigation_drawer)
        setSupportActionBar(toolbar)

        val toggle = ActionBarDrawerToggle(
                this, drawer_layout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()

        nav_view.setNavigationItemSelectedListener(this)

        var recList = findViewById<RecyclerView>(R.id.cardList) as RecyclerView
        recList.setHasFixedSize(true)
        var llm = LinearLayoutManager(this)
        llm.orientation = LinearLayoutManager.VERTICAL
        recList.layoutManager = llm

        var ca : CharAdapter = CharAdapter(createList(30))
        recList.adapter = ca
    }

    override fun onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // Handle navigation view item clicks here.
        when (item.itemId) {
            R.id.nav_chars -> {
                // Handle the camera action
                this.title = "Charaktere"
            }
            R.id.nav_rulesets -> {
                this.title = "Regelwerke"
            }
            R.id.nav_dice -> {
                this.title = "Würfeltool"
            }
            R.id.nav_manage -> {
                this.title = "Einstellungen"
            }
            R.id.nav_import -> {
                this.title = "Import"
            }
            R.id.nav_export -> {
                this.title = "Export"
            }
        }

        drawer_layout.closeDrawer(GravityCompat.START)
        return true
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
