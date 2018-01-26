package com.chrisphil.charbuilder.creationfragments

import android.support.v7.app.AlertDialog
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.chrisphil.charbuilder.R
import android.content.Intent
import android.content.BroadcastReceiver
import android.content.Context
import android.content.IntentFilter
import android.support.v4.content.LocalBroadcastManager
import android.util.Log
import android.widget.BaseAdapter
import android.widget.Toast
import com.chrisphil.charbuilder.controller.CharCreationController
import kotlinx.android.synthetic.main.char_creation_specialization.view.*
import kotlinx.android.synthetic.main.char_creation_specialization_edit_dialog.view.*
import kotlinx.android.synthetic.main.skill_list_element.view.*

class ExperienceFragment : Fragment() {

    private lateinit var r : BRReceiver

    data class Skill(var name : String,
                     var description : String)

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var view = inflater!!.inflate(R.layout.char_creation_specialization, container, false)
        r = BRReceiver()

        view.skillList.adapter = SkillListAdapter(CharCreationController.playerObject.skills)

        view.add_skill_button.setOnClickListener {
            if(view.tw_skill.text.toString() != "" && view.et_skill_desc.text.toString() != ""){
                CharCreationController.playerObject.skills.add(Skill(view.tw_skill.text.toString(),view.et_skill_desc.text.toString()))
                view.tw_skill.text.clear()
                view.et_skill_desc.text.clear()
            }else{
                Toast.makeText(context,"Name und Beschreibung dürfen nicht leer sein",Toast.LENGTH_SHORT).show()
            }
        }
        return view
    }

    fun refresh() {

        if(CharCreationController.playerObject.specialization != CharCreationController.old_specialization
                || CharCreationController.old_specialization == ""
                || CharCreationController.playerObject.specialization == "") {

            var dialog = AlertDialog.Builder(context)
            dialog.setTitle("Achtung")
            dialog.setMessage("Deine Brufswahl hat sich geändert oder wurde noch nicht festgelegt, bitte überprüfe die Skills")
            var b = dialog.create()
            b.setButton(AlertDialog.BUTTON_NEUTRAL,resources.getString(R.string.dialog_ok),{
                _, _ ->
                b.dismiss()
            })
            b.show()
        }
        CharCreationController.old_specialization = CharCreationController.playerObject.specialization
    }

    override fun onPause() {
        super.onPause()
        LocalBroadcastManager.getInstance(context).unregisterReceiver(r)
    }

    override fun onResume() {
        super.onResume()
        r = BRReceiver()
        LocalBroadcastManager.getInstance(context).registerReceiver(r,
                IntentFilter("SPEC_REFRESH"))
    }

    private fun showEditDialog(num : Int){
        var builder = AlertDialog.Builder(context)
        var dialogView = layoutInflater.inflate(R.layout.char_creation_specialization_edit_dialog,null)
        builder.setView(dialogView)
        var dialog = builder.create()

        dialogView.et_skill_namedg.setText(CharCreationController.playerObject.skills[num].name)
        dialogView.et_skill_descdg.setText(CharCreationController.playerObject.skills[num].description)

        dialogView.completeSkillButton.setOnClickListener {
            if(dialogView.et_skill_namedg.text.toString() != "" && dialogView.et_skill_descdg.text.toString() != ""){
                CharCreationController.playerObject.skills[num].name = dialogView.et_skill_namedg.text.toString()
                CharCreationController.playerObject.skills[num].description = dialogView.et_skill_descdg.text.toString()
                dialog.dismiss()
            }else{
                Toast.makeText(context,"Name und Beschreibung dürfen nicht leer sein",Toast.LENGTH_SHORT)
            }
        }

        dialog.show()
    }

    private inner class BRReceiver : BroadcastReceiver() {
        override fun onReceive(context: Context, intent: Intent) {
            this@ExperienceFragment.refresh()
        }
    }

    companion object {

        private const val ARG_SECTION_NUMBER = "section_number"

        fun newInstance(sectionNumber: Int): ExperienceFragment {
            val fragment = ExperienceFragment()
            val args = Bundle()
            args.putInt(ARG_SECTION_NUMBER, sectionNumber)
            fragment.arguments = args
            return fragment
        }
    }

    inner class SkillListAdapter(var skills: ArrayList<Skill>) : BaseAdapter() {

        override fun getItem(p0: Int): Any {
            return skills[p0]
        }

        override fun getItemId(p0: Int): Long {
            return p0.toLong()
        }

        override fun getCount(): Int {
            return skills.count()
        }

        override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
            val li = LayoutInflater.from(context)
            val view = li.inflate(R.layout.skill_list_element,p2,false)

            var name_view = view.skillname
            name_view.text = skills[p0].name

            var desc_view = view.skill_desc
            desc_view.text = skills[p0].description

            var deletebutton = view.deleteIMGView
            deletebutton.setOnClickListener {

                var dialogB = AlertDialog.Builder(context)
                dialogB.setTitle("Wirklich löschen?")
                dialogB.setMessage("Soll der Skill wirklich gelöscht werden?")
                var dialog = dialogB.create()
                dialog.setButton(AlertDialog.BUTTON_POSITIVE,resources.getString(R.string.cancel_dialog_yes),{
                    _, _ ->
                    CharCreationController.playerObject.skills.removeAt(p0)
                    this.notifyDataSetChanged()
                    dialog.dismiss()
                })

                dialog.setButton(AlertDialog.BUTTON_NEGATIVE,resources.getString(R.string.cancel_dialog_no), {
                    _, _ ->
                    dialog.dismiss()
                })
                dialog.show()

            }

            var editbutton = view.editIMGView
            editbutton.setOnClickListener {
                showEditDialog(p0)
                this.notifyDataSetChanged()
            }

            return view
        }

    }
}