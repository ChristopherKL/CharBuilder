package com.chrisphil.charbuilder

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import com.chrisphil.charbuilder.controller.CharListController
import com.chrisphil.charbuilder.controller.DiceController
import com.chrisphil.charbuilder.controller.ImportExportController
import com.chrisphil.charbuilder.controller.SettingsController
import com.chrisphil.charbuilder.importExportFragments.IEMenuFragment
import com.google.firebase.auth.FirebaseAuth
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

    }

    override fun onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)
        } else {
            //super.onBackPressed()
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // Handle navigation view item clicks here.
        when (item.itemId) {
            R.id.nav_chars -> {
                this.title = resources.getString(R.string.characters)
                supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.content_frame, CharListController.newInstance(), "charListController")
                        .commit()
            }
            R.id.nav_dice -> {
                this.title = resources.getString(R.string.dices)
                supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.content_frame, DiceController.newInstance(), "diceController")
                        .commit()
            }
            R.id.nav_manage -> {
                this.title = resources.getString(R.string.action_settings)
                supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.content_frame,SettingsController.newInstance(),"settingsController")
                        .commit()
            }
            R.id.nav_importExport -> {
                this.title = resources.getString(R.string.importExport)
                if(FirebaseAuth.getInstance().currentUser == null) {
                    supportFragmentManager
                            .beginTransaction()
                            .replace(R.id.content_frame, ImportExportController.newInstance(), "importExportSignIn")
                            .commit()
                }else{
                    supportFragmentManager
                            .beginTransaction()
                            .replace(R.id.content_frame,IEMenuFragment.newInstance(),"importExport")
                            .commit()
                }
            }
        }

        drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }


}
