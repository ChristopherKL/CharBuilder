package com.chrisphil.charbuilder.creationfragments

import android.app.AlertDialog
import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseExpandableListAdapter
import com.chrisphil.charbuilder.R
import kotlinx.android.synthetic.main.char_creation_career_group_item.view.*
import kotlinx.android.synthetic.main.char_creation_motivation.*
import kotlinx.android.synthetic.main.char_creation_motivation.view.*
import kotlinx.android.synthetic.main.char_creation_listview.view.*
import org.xmlpull.v1.XmlPullParser
import java.util.Random

/**
 * Created by Christopher on 04.12.2017.
 */
class MotivationFragment : Fragment() {

    data class Motivation(
        val id : Long,
        val name : String,
        val description : String,
        val text : String
    )

    data class MotivationGroup(
        val id : Long,
        val name : String,
        val motivationArray : ArrayList<Motivation>
    )

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view : View = inflater!!.inflate(R.layout.char_creation_motivation, container, false)

        val ambitionArray = loadMotivations("ambition",0L)
        val ambitionGroup = MotivationGroup(0L, getString(R.string.ambition),ambitionArray)

        val causeArray = loadMotivations("cause",1L)
        val causeGroup = MotivationGroup(1L,getString(R.string.cause),causeArray)

        val relationArray = loadMotivations("relation",3L)
        val relationshipGroup = MotivationGroup(2L, getString(R.string.relationship),relationArray)

        var motivationGroupArray : ArrayList<MotivationGroup> = ArrayList()
        motivationGroupArray.add(ambitionGroup)
        motivationGroupArray.add(causeGroup)
        motivationGroupArray.add(relationshipGroup)

        view.motivation_list.setAdapter(MotivationListAdapter(context,motivationGroupArray))

        view.motivation_list.setOnChildClickListener { _, _, groupPosition, childPosition, _ ->
            view.selected_motivation.text = motivationGroupArray[groupPosition].motivationArray[childPosition].name
            view.selected_motivation2.text = ""
            false
        }

        view.random_motivation_button.setOnClickListener{
            val motivationResult : Int = Random().nextInt(10)+1
            when(motivationResult) {
                in 1..3 -> chooseAmbition(false)
                in 4..6 -> chooseCause(false)
                in 7..9 -> chooseRelationship(false)
                10 -> chooseTwoMotivations()
            }
        }
        return view
    }

    private fun loadMotivations(motivation : String, groupID : Long) : ArrayList<Motivation>{
        val allMotivations = ArrayList<Motivation>()
        var idCount = groupID*10
        val xml = resources.getXml(R.xml.motivations)
        while(xml.eventType != XmlPullParser.END_DOCUMENT){
            if(xml.eventType == XmlPullParser.START_TAG){
                if(xml.name == motivation){

                    val current = Motivation(
                            idCount,
                            xml.getAttributeValue(null,"name"),
                            xml.getAttributeValue(null,"description"),
                            xml.getAttributeValue(null,"text")
                    )
                    allMotivations.add(current)
                    idCount++
                }
            }
            xml.next()
        }
        return allMotivations
    }

    inner class MotivationListAdapter(context : Context,var motivationGroup : ArrayList<MotivationGroup>) : BaseExpandableListAdapter() {
        override fun getGroup(p0: Int): Any {
            return motivationGroup[p0]
        }

        override fun isChildSelectable(p0: Int, p1: Int): Boolean {
            return true
        }

        override fun hasStableIds(): Boolean {
            return true
        }

        override fun getChild(p0: Int, p1: Int): Any {
            when(p1) {
                0 -> return motivationGroup[p0].motivationArray[0]
                1 -> return motivationGroup[p0].motivationArray[1]
                2 -> return motivationGroup[p0].motivationArray[2]
                3 -> return motivationGroup[p0].motivationArray[3]
                4 -> return motivationGroup[p0].motivationArray[4]
                5 -> return motivationGroup[p0].motivationArray[5]
                6 -> return motivationGroup[p0].motivationArray[6]
                7 -> return motivationGroup[p0].motivationArray[7]
                8 -> return motivationGroup[p0].motivationArray[8]
                9 -> return motivationGroup[p0].motivationArray[9]
            }
            return motivationGroup[p0].motivationArray[0]
        }

        override fun getGroupId(p0: Int): Long {
            return motivationGroup[p0].id
        }

        override fun getChildId(p0: Int, p1: Int): Long {
            when(p1){
                0 -> return motivationGroup[p0].motivationArray[0].id
                1 -> return motivationGroup[p0].motivationArray[1].id
                2 -> return motivationGroup[p0].motivationArray[2].id
                3 -> return motivationGroup[p0].motivationArray[3].id
                4 -> return motivationGroup[p0].motivationArray[4].id
                5 -> return motivationGroup[p0].motivationArray[5].id
                6 -> return motivationGroup[p0].motivationArray[6].id
                7 -> return motivationGroup[p0].motivationArray[7].id
                8 -> return motivationGroup[p0].motivationArray[8].id
                9 -> return motivationGroup[p0].motivationArray[9].id
            }
            return motivationGroup[p0].motivationArray[0].id
        }

        override fun getChildrenCount(p0: Int): Int {
            return motivationGroup[p0].motivationArray.size
        }

        override fun isEmpty(): Boolean {
            return motivationGroup.isEmpty()
        }

        override fun getChildView(p0: Int, p1: Int, p2: Boolean, p3: View?, p4: ViewGroup?): View {
            val li = LayoutInflater.from(context)
            val view = li.inflate(R.layout.char_creation_listview,p4,false)
            when(p1){
                0 -> {view.firstLine.text = motivationGroup[p0].motivationArray[0].name
                    view.secondLine.text = motivationGroup[p0].motivationArray[0].description
                    view.icon.setOnClickListener{createMotivationsInfoDialog(motivationGroup[p0].motivationArray[0])}}
                1 -> {view.firstLine.text = motivationGroup[p0].motivationArray[1].name
                    view.secondLine.text = motivationGroup[p0].motivationArray[1].description
                    view.icon.setOnClickListener{createMotivationsInfoDialog(motivationGroup[p0].motivationArray[1])}}
                2 -> {view.firstLine.text = motivationGroup[p0].motivationArray[2].name
                    view.secondLine.text = motivationGroup[p0].motivationArray[2].description
                    view.icon.setOnClickListener{createMotivationsInfoDialog(motivationGroup[p0].motivationArray[2])}}
                3 -> {view.firstLine.text = motivationGroup[p0].motivationArray[3].name
                    view.secondLine.text = motivationGroup[p0].motivationArray[3].description
                    view.icon.setOnClickListener{createMotivationsInfoDialog(motivationGroup[p0].motivationArray[3])}}
                4 -> {view.firstLine.text = motivationGroup[p0].motivationArray[4].name
                    view.secondLine.text = motivationGroup[p0].motivationArray[4].description
                    view.icon.setOnClickListener{createMotivationsInfoDialog(motivationGroup[p0].motivationArray[4])}}
                5 -> {view.firstLine.text = motivationGroup[p0].motivationArray[5].name
                    view.secondLine.text = motivationGroup[p0].motivationArray[5].description
                    view.icon.setOnClickListener{createMotivationsInfoDialog(motivationGroup[p0].motivationArray[5])}}
                6 -> {view.firstLine.text = motivationGroup[p0].motivationArray[6].name
                    view.secondLine.text = motivationGroup[p0].motivationArray[6].description
                    view.icon.setOnClickListener{createMotivationsInfoDialog(motivationGroup[p0].motivationArray[6])}}
                7 -> {view.firstLine.text = motivationGroup[p0].motivationArray[7].name
                    view.secondLine.text = motivationGroup[p0].motivationArray[7].description
                    view.icon.setOnClickListener{createMotivationsInfoDialog(motivationGroup[p0].motivationArray[7])}}
                8 -> {view.firstLine.text = motivationGroup[p0].motivationArray[8].name
                    view.secondLine.text = motivationGroup[p0].motivationArray[8].description
                    view.icon.setOnClickListener{createMotivationsInfoDialog(motivationGroup[p0].motivationArray[8])}}
                9 -> {view.firstLine.text = motivationGroup[p0].motivationArray[9].name
                    view.secondLine.text = motivationGroup[p0].motivationArray[9].description
                    view.icon.setOnClickListener{createMotivationsInfoDialog(motivationGroup[p0].motivationArray[9])}}
            }

            return view
        }

        override fun getGroupView(p0: Int, p1: Boolean, p2: View?, p3: ViewGroup?): View {
            val li = LayoutInflater.from(context)
            val view = li.inflate(R.layout.char_creation_career_group_item,p3,false)
            view.career_name.text = motivationGroup[p0].name
            return view
        }

        override fun getGroupCount(): Int {
            return motivationGroup.size
        }

    }

    private fun createMotivationsInfoDialog(motivation : Motivation){
        var dialogBuilder = AlertDialog.Builder(context)
        dialogBuilder.setMessage(motivation.text)
                     .setTitle(motivation.name)
        val dialog = dialogBuilder.create()
        dialog.setButton(AlertDialog.BUTTON_NEUTRAL,getString(R.string.dialog_ok),{
            _, _ ->
            dialog.dismiss()
        })
        dialog.show()
    }

    private fun chooseAmbition(isSecond : Boolean){
        val result : Int = Random().nextInt(100)+1
        when(result) {
            in 1..10 -> if (!isSecond) {
                selected_motivation.text = getString(R.string.ambition_friendship)
                selected_motivation2.text = ""
                } else selected_motivation2.text = getString(R.string.ambition_friendship)
            in 11..20 -> if (!isSecond) {
                selected_motivation.text = getString(R.string.ambition_love)
                selected_motivation2.text = ""
                } else selected_motivation2.text = getString(R.string.ambition_love)
            in 21..30 -> if (!isSecond) {
                selected_motivation.text = getString(R.string.ambition_freedom)
                selected_motivation2.text = ""
                } else selected_motivation2.text = getString(R.string.ambition_freedom)
            in 31..40 -> if (!isSecond) {
                selected_motivation.text = getString(R.string.ambition_fame)
                selected_motivation2.text = ""
                } else selected_motivation2.text = getString(R.string.ambition_fame)
            in 41..50 -> if (!isSecond) {
                selected_motivation.text = getString(R.string.ambition_greed)
                selected_motivation2.text = ""
                } else selected_motivation2.text = getString(R.string.ambition_greed)
            in 51..60 -> if (!isSecond) {
                selected_motivation.text = getString(R.string.ambition_status)
                selected_motivation2.text = ""
                } else selected_motivation2.text = getString(R.string.ambition_status)
            in 61..70 -> if (!isSecond) {
                selected_motivation.text = getString(R.string.ambition_expertise)
                selected_motivation2.text = ""
                } else selected_motivation2.text = getString(R.string.ambition_expertise)
            in 71..80 -> if (!isSecond) {
                selected_motivation.text = getString(R.string.ambition_wanderlust_novelty)
                selected_motivation2.text = ""
                } else selected_motivation2.text = getString(R.string.ambition_wanderlust_novelty)
            in 81..90 -> if (!isSecond) {
                selected_motivation.text = getString(R.string.ambition_power)
                selected_motivation2.text = ""
                } else selected_motivation2.text = getString(R.string.ambition_power)
            in 91..100 -> if (!isSecond) {
                selected_motivation.text = getString(R.string.ambition_religion_spirituality)
                } else selected_motivation2.text = getString(R.string.ambition_religion_spirituality)
        }
    }

    private fun chooseCause(isSecond : Boolean){
        val result : Int = Random().nextInt(100)+1
        when(result) {
            in 1..10 -> if (!isSecond) {
                selected_motivation.text = getString(R.string.cause_religion_spirituality)
                selected_motivation2.text = ""
            } else selected_motivation2.text = getString(R.string.cause_religion_spirituality)
            in 11..20 -> if (!isSecond) {
                selected_motivation.text = getString(R.string.cause_theweak_charity)
                selected_motivation2.text = ""
            } else selected_motivation2.text = getString(R.string.cause_theweak_charity)
            in 21..30 -> if (!isSecond) {
                selected_motivation.text = getString(R.string.cause_nonhuman_rights)
                selected_motivation2.text = ""
            } else selected_motivation2.text = getString(R.string.cause_nonhuman_rights)
            in 31..40 -> if (!isSecond) {
                selected_motivation.text = getString(R.string.cause_local_politics)
                selected_motivation2.text = ""
            } else selected_motivation2.text = getString(R.string.cause_local_politics)
            in 41..50 -> if (!isSecond) {
                selected_motivation.text = getString(R.string.cause_overthrow_the_empire)
                selected_motivation2.text = ""
            } else selected_motivation2.text = getString(R.string.cause_overthrow_the_empire)
            in 51..60 -> if (!isSecond) {
                selected_motivation.text = getString(R.string.cause_crime)
                selected_motivation2.text = ""
            } else selected_motivation2.text = getString(R.string.cause_crime)
            in 61..70 -> if (!isSecond) {
                selected_motivation.text = getString(R.string.cause_emancipation)
                selected_motivation2.text = ""
            } else selected_motivation2.text = getString(R.string.cause_emancipation)
            in 71..80 -> if (!isSecond) {
                selected_motivation.text = getString(R.string.cause_droid_rights)
                selected_motivation2.text = ""
            } else selected_motivation2.text = getString(R.string.cause_droid_rights)
            in 81..90 -> if (!isSecond) {
                selected_motivation.text = getString(R.string.cause_capitalism)
                selected_motivation2.text = ""
                } else selected_motivation2.text = getString(R.string.cause_capitalism)
            in 91..100 -> if(!isSecond) selected_motivation.text = getString(R.string.cause_support_the_empire)
                        else selected_motivation2.text = getString(R.string.cause_support_the_empire)
        }
    }

    private fun chooseRelationship(isSecond : Boolean){
        val result : Int = Random().nextInt(100)+1
        when(result) {
            in 1..10 -> if (!isSecond) {
                selected_motivation.text = getString(R.string.relation_place_of_origin)
                selected_motivation2.text = ""
            } else selected_motivation2.text = getString(R.string.relation_place_of_origin)
            in 11..20 -> if (!isSecond) {
                selected_motivation.text = getString(R.string.relation_pet)
                selected_motivation2.text = ""
            } else selected_motivation2.text = getString(R.string.relation_pet)
            in 21..30 -> if (!isSecond) {
                selected_motivation.text = getString(R.string.relation_childhood_friend)
                selected_motivation2.text = ""
            } else selected_motivation2.text = getString(R.string.relation_childhood_friend)
            in 31..40 -> if (!isSecond) {
                selected_motivation.text = getString(R.string.relation_comrades)
                selected_motivation2.text = ""
                } else selected_motivation2.text = getString(R.string.relation_comrades)
            in 41..50 -> if(!isSecond) {
                selected_motivation.text = getString(R.string.relation_siblings)
                selected_motivation2.text = ""
                } else selected_motivation2.text = getString(R.string.relation_siblings)
            in 51..60 -> if(!isSecond) {
                selected_motivation.text = getString(R.string.relation_mentor)
                selected_motivation2.text = ""
                } else selected_motivation2.text = getString(R.string.relation_mentor)
            in 61..70 -> if(!isSecond) {
                selected_motivation.text = getString(R.string.relation_parents)
                selected_motivation2.text = ""
                } else selected_motivation2.text = getString(R.string.relation_parents)
            in 71..80 -> if(!isSecond) {
                selected_motivation.text = getString(R.string.relation_extended_family_clan)
                selected_motivation2.text = ""
                } else selected_motivation2.text = getString(R.string.relation_extended_family_clan)
            in 81..90 -> if(!isSecond) {
                selected_motivation.text = getString(R.string.relation_droid_companion)
                selected_motivation2.text = ""
                } else selected_motivation2.text = getString(R.string.relation_droid_companion)
            in 91..100 -> if(!isSecond) {
                selected_motivation.text = getString(R.string.relation_former_nemesis)
                selected_motivation2.text = ""
                } else selected_motivation2.text = getString(R.string.relation_former_nemesis)
        }
    }

    private fun chooseTwoMotivations(){
        val result : Int = Random().nextInt(3)
        when(result){
            0 -> chooseAmbition(false)
            1 -> chooseCause(false)
            2 -> chooseRelationship(false)
        }

        val result2 : Int = Random().nextInt(2)
        if(result == 0){
            if(result2 == 0){
                chooseCause(true)
            }
            else{
                chooseRelationship(true)
            }
        }
        else if(result == 1){
            if(result2 == 0){
                chooseAmbition(true)
            }
            else{
                chooseRelationship(true)
            }
        }
        else{
            if(result2 == 0){
                chooseAmbition(true)
            }
            else{
                chooseCause(true)
            }
        }
    }

    companion object {

        private val ARG_SECTION_NUMBER = "section_number"

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        fun newInstance(sectionNumber: Int): MotivationFragment {
            val fragment = MotivationFragment()
            val args = Bundle()
            args.putInt(ARG_SECTION_NUMBER, sectionNumber)
            fragment.arguments = args
            return fragment
        }
    }
}