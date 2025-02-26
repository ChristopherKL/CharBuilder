package com.chrisphil.charbuilder.controller

import android.content.Context
import android.support.v7.app.AppCompatActivity

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.app.FragmentStatePagerAdapter
import android.support.v7.app.AlertDialog
import android.util.Log
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import com.chrisphil.charbuilder.Player
import com.chrisphil.charbuilder.R
import com.chrisphil.charbuilder.creationfragments.*
import com.chrisphil.charbuilder.interfaces.OnDataPass

import kotlinx.android.synthetic.main.char_creation.*
import kotlinx.android.synthetic.main.fragment_char_creation.view.*
import android.content.Intent
import android.support.v4.content.LocalBroadcastManager
import com.chrisphil.charbuilder.MainNavigationDrawer


class CharCreationController : AppCompatActivity(), OnDataPass{

    companion object {
        var playerObject : Player = Player()
        var old_specialization = ""

        fun newPlayer(){
            this.playerObject = Player()
        }

        fun saveCurrentPlayer(context : Context){
            MainNavigationDrawer.addPlayerToCharList(playerObject)
            MainNavigationDrawer.savePlayerList(context)
        }
    }

    override fun onDataPass(data: String) {
        Log.d("LOG","hello " + data);
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.char_creation)

        setSupportActionBar(toolbar)

        char_tab_layout.addTab(char_tab_layout.newTab().setText(resources.getString(R.string.cc_obligation)))
        char_tab_layout.addTab(char_tab_layout.newTab().setText(resources.getString(R.string.cc_species)))
        char_tab_layout.addTab(char_tab_layout.newTab().setText(resources.getString(R.string.cc_career)))
        char_tab_layout.addTab(char_tab_layout.newTab().setText(resources.getString(R.string.cc_skills)))
        char_tab_layout.addTab(char_tab_layout.newTab().setText(resources.getString(R.string.cc_motivation)))
        char_tab_layout.addTab(char_tab_layout.newTab().setText(resources.getString(R.string.cc_appearance)))
        char_tab_layout.addTab(char_tab_layout.newTab().setText(resources.getString(R.string.cc_gear)))
        char_tab_layout.addTab(char_tab_layout.newTab().setText(resources.getString(R.string.cc_completion)))

        char_tab_layout.tabGravity = TabLayout.GRAVITY_FILL
        char_tab_layout.tabMode = TabLayout.MODE_SCROLLABLE

        val adapter = PageAdapter(supportFragmentManager,char_tab_layout.tabCount)
        container.adapter = adapter
        container.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(char_tab_layout))
        char_tab_layout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabReselected(tab: TabLayout.Tab?) {

            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {

            }

            override fun onTabSelected(tab: TabLayout.Tab?) {
                container.currentItem = tab!!.position
                if(tab!!.position == 3){ //When spec Fragment
                    val lbm = LocalBroadcastManager.getInstance(applicationContext)
                    val i = Intent("SPEC_REFRESH")
                    lbm.sendBroadcast(i)
                }
            }
        })

    }

    override fun onBackPressed() {
        showCancelDialog()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_char_creation_controller, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        val id = item.itemId

        if (id == R.id.action_abort) {
            showCancelDialog()
            return true
        }

        return super.onOptionsItemSelected(item)
    }

    private fun showCancelDialog(){
        val builder = AlertDialog.Builder(this)
        builder.setMessage(R.string.cancel_creation_dialog_message)
                .setTitle(R.string.cancel_creation_dialog_title)

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

    inner class PageAdapter(fm:FragmentManager,tabNum:Int) : FragmentStatePagerAdapter(fm){
        override fun getItem(position: Int): Fragment {
            when(position){
                0 -> return ObligationFragment.newInstance(position+1)
                1 -> return SpeciesFragment.newInstance(position+1)
                2 -> return CareerFragment.newInstance(position+1)
                3 -> return ExperienceFragment.newInstance(position+1)
                4 -> return MotivationFragment.newInstance(position+1)
                5 -> return AppearanceFragment.newInstance(position+1)
                6 -> return GearFragment.newInstance(position+1)
                7 -> return CompletionFragment.newInstance(position+1)
            }
            return PlaceholderFragment.newInstance(99)
        }

        override fun getCount(): Int {
            // Show 9 total pages.
            return 8
        }
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    class PlaceholderFragment : Fragment() {

        override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                                  savedInstanceState: Bundle?): View? {
            val rootView = inflater.inflate(R.layout.fragment_char_creation, container, false)
            rootView.section_label.text = getString(R.string.section_format, arguments.getInt(ARG_SECTION_NUMBER))
            return rootView
        }

        companion object {
            /**
             * The fragment argument representing the section number for this
             * fragment.
             */
            private val ARG_SECTION_NUMBER = "section_number"

            /**
             * Returns a new instance of this fragment for the given section
             * number.
             */
            fun newInstance(sectionNumber: Int): PlaceholderFragment {
                val fragment = PlaceholderFragment()
                val args = Bundle()
                args.putInt(ARG_SECTION_NUMBER, sectionNumber)
                fragment.arguments = args
                return fragment
            }
        }
    }
}
