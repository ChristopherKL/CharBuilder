package com.chrisphil.charbuilder.creationfragments

import android.support.v7.app.AlertDialog
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.chrisphil.charbuilder.R
import android.widget.BaseAdapter
import android.widget.Toast
import com.chrisphil.charbuilder.controller.CharDetailsController
import kotlinx.android.synthetic.main.char_creation_specialization_edit_dialog.view.*
import kotlinx.android.synthetic.main.skill_list_element.view.*

class ExperienceDetailFragment : Fragment() {

    data class Skill(var name : String,
                     var description : String)

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var view = inflater!!.inflate(R.layout.char_creation_specialization, container, false)

        view.skillList.adapter = SkillListAdapter(CharDetailsController.playerObject.skills)

        view.add_skill_button.setOnClickListener {
            if(view.tw_skill.text.toString() != "" && view.et_skill_desc.text.toString() != ""){
                CharDetailsController.playerObject.skills.add(Skill(view.tw_skill.text.toString(),view.et_skill_desc.text.toString()))
                view.tw_skill.text.clear()
                view.et_skill_desc.text.clear()
            }else{
                Toast.makeText(context,"Name und Beschreibung dürfen nicht leer sein",Toast.LENGTH_SHORT).show()
            }
        }
        return view
    }

    private fun showEditDialog(num : Int){
        var builder = AlertDialog.Builder(context)
        var dialogView = layoutInflater.inflate(R.layout.char_creation_specialization_edit_dialog,null)
        builder.setView(dialogView)
        var dialog = builder.create()

        dialogView.et_skill_namedg.setText(CharDetailsController.playerObject.skills[num].name)
        dialogView.et_skill_descdg.setText(CharDetailsController.playerObject.skills[num].description)

        dialogView.completeSkillButton.setOnClickListener {
            if(dialogView.et_skill_namedg.text.toString() != "" && dialogView.et_skill_descdg.text.toString() != ""){
                CharDetailsController.playerObject.skills[num].name = dialogView.et_skill_namedg.text.toString()
                CharDetailsController.playerObject.skills[num].description = dialogView.et_skill_descdg.text.toString()
                dialog.dismiss()
            }else{
                Toast.makeText(context,"Name und Beschreibung dürfen nicht leer sein",Toast.LENGTH_SHORT)
            }
        }

        dialog.show()
    }

    companion object {

        private const val ARG_SECTION_NUMBER = "section_number"

        fun newInstance(sectionNumber: Int): ExperienceDetailFragment {
            val fragment = ExperienceDetailFragment()
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
                    CharDetailsController.playerObject.skills.removeAt(p0)
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