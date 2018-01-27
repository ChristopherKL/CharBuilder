package com.chrisphil.charbuilder.controller

import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import android.view.*
import com.chrisphil.charbuilder.Player
import com.chrisphil.charbuilder.R
import com.chrisphil.charbuilder.detailsfragments.ExperienceDetailFragment
import com.chrisphil.charbuilder.detailsfragments.AppearanceDetailFragment
import com.chrisphil.charbuilder.detailsfragments.GearDetailFragment
import com.chrisphil.charbuilder.detailsfragments.GeneralDetailFragment
import kotlinx.android.synthetic.main.char_details.*

/**
 * Created by Christopher on 26.01.2018.
 */
class CharDetailsController : AppCompatActivity(){

    companion object {
        var playerObject : Player = Player()

        fun newPlayer(){
            this.playerObject = Player()
        }

        fun saveCurrentPlayer(){

        }

        fun loadCurrentPlayer(){

        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.char_creation)

        setSupportActionBar(char_details_toolbar)

        char_details_tab_layout.addTab(char_details_tab_layout.newTab().setText(resources.getString(R.string.cd_general)))
        char_details_tab_layout.addTab(char_details_tab_layout.newTab().setText(resources.getString(R.string.cc_skills)))
        char_details_tab_layout.addTab(char_details_tab_layout.newTab().setText(resources.getString(R.string.cc_gear)))
        char_details_tab_layout.addTab(char_details_tab_layout.newTab().setText(resources.getString(R.string.cc_appearance)))

        char_details_tab_layout.tabGravity = TabLayout.GRAVITY_FILL
        char_details_tab_layout.tabMode = TabLayout.MODE_SCROLLABLE

        val adapter = PageStateAdapter(supportFragmentManager,char_details_tab_layout.tabCount)
        char_details_container.adapter = adapter
        char_details_container.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(char_details_tab_layout))
        char_details_tab_layout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabReselected(tab: TabLayout.Tab?) {

            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {

            }

            override fun onTabSelected(tab: TabLayout.Tab?) {
                char_details_container.currentItem = tab!!.position
            }
        })

    }

    override fun onBackPressed() {
        showCancelDialog()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_char_creation_controller, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId

        if(id == R.id.action_confirm_details) {
            saveCurrentPlayer()
            newPlayer()
            finish()
            return true
        }

        if (id == R.id.action_abort_details) {
            showCancelDialog()
            return true
        }

        return super.onOptionsItemSelected(item)
    }

    private fun showCancelDialog(){
        val builder = AlertDialog.Builder(this)
        builder.setMessage(R.string.cancel_details_dialog_message)
                .setTitle(R.string.cancel_details_dialog_title)

        val dialog = builder.create()

        dialog.setButton(AlertDialog.BUTTON_POSITIVE,resources.getString(R.string.cancel_dialog_yes),{
            _, _ ->
            newPlayer()
            finish()
        })

        dialog.setButton(AlertDialog.BUTTON_NEGATIVE,resources.getString(R.string.cancel_dialog_no), {
            _, _ ->
            dialog.dismiss()
        })
        dialog.show()
    }

    inner class PageStateAdapter(fm: FragmentManager, tabNum:Int) : FragmentStatePagerAdapter(fm){
        override fun getItem(position: Int): Fragment {
            when(position){
                0 -> return GeneralDetailFragment.newInstance(position+1)
                1 -> return ExperienceDetailFragment.newInstance(position+1)
                2 -> return GearDetailFragment.newInstance(position+1)
                3 -> return AppearanceDetailFragment.newInstance(position+1)
            }
            return CharCreationController.PlaceholderFragment.newInstance(99)
        }

        override fun getCount(): Int {
            // Show 4 total pages.
            return 4
        }
    }
}