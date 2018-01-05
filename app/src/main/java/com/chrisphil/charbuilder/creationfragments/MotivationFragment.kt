package com.chrisphil.charbuilder.creationfragments

import android.app.AlertDialog
import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ListView
import com.chrisphil.charbuilder.R
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

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view : View = inflater!!.inflate(R.layout.char_creation_motivation, container, false)
        val ambitionList : ListView = view.ambition_listView
        val causeList : ListView = view.cause_listView
        val relationList : ListView = view.relationship_listView
        var ambitionArray = loadMotivations("ambition")
        var causeArray = loadMotivations("cause")
        var relationArray = loadMotivations("relation")
        val ambitionAdapter = MotivationsViewAdapter(context,ambitionArray)
        val causeAdapter = MotivationsViewAdapter(context,causeArray)
        val relationAdapter = MotivationsViewAdapter(context,relationArray)
        ambitionList.adapter = ambitionAdapter
        causeList.adapter = causeAdapter
        relationList.adapter = relationAdapter
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

    private fun loadMotivations(motivation : String) : ArrayList<Motivation>{
        val allObligations = ArrayList<Motivation>()
        var id_count = 0L
        val xml = resources.getXml(R.xml.motivations)
        while(xml.eventType != XmlPullParser.END_DOCUMENT){
            if(xml.eventType == XmlPullParser.START_TAG){
                if(xml.name == motivation){

                    val current = Motivation(
                            id_count,
                            xml.getAttributeValue(null,"name"),
                            xml.getAttributeValue(null,"description"),
                            xml.getAttributeValue(null,"text")
                    )
                    allObligations.add(current)
                    id_count++
                }
            }
            xml.next()
        }
        return allObligations
    }

    inner class MotivationsViewAdapter(context: Context, var motivations : ArrayList<Motivation>) : BaseAdapter() {

        override fun getItem(p0: Int): Any {
            return motivations[p0]
        }

        override fun getItemId(p0: Int): Long {
            return motivations[p0].id
        }
        override fun getCount(): Int {
            return motivations.count()
        }

        override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
            val li = LayoutInflater.from(context)
            val view = li.inflate(R.layout.char_creation_listview,p2,false)
            var name_view = view.firstLine
            name_view.text = motivations[p0].name

            var desc_view = view.secondLine
            desc_view.text = motivations[p0].description

            var button = view.icon
            button.setOnClickListener {
                createMotivationsInfoDialog(motivations[p0])
            }
            return view
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
        when(result){
            in 1..10 -> if(!isSecond) selected_motivation.text = getString(R.string.ambition_friendship)
                        else selected_motivation2.text = getString(R.string.ambition_friendship)
            in 11..20 -> if(!isSecond) selected_motivation.text = getString(R.string.ambition_love)
                        else selected_motivation2.text = getString(R.string.ambition_love)
            in 21..30 -> if(!isSecond) selected_motivation.text = getString(R.string.ambition_freedom)
                        else selected_motivation2.text = getString(R.string.ambition_freedom)
            in 31..40 -> if(!isSecond) selected_motivation.text = getString(R.string.ambition_fame)
                        else selected_motivation2.text = getString(R.string.ambition_fame)
            in 41..50 -> if(!isSecond) selected_motivation.text = getString(R.string.ambition_greed)
                        else selected_motivation2.text = getString(R.string.ambition_greed)
            in 51..60 -> if(!isSecond) selected_motivation.text = getString(R.string.ambition_status)
                        else selected_motivation2.text = getString(R.string.ambition_status)
            in 61..70 -> if(!isSecond) selected_motivation.text = getString(R.string.ambition_expertise)
                        else selected_motivation2.text = getString(R.string.ambition_expertise)
            in 71..80 -> if(!isSecond) selected_motivation.text = getString(R.string.ambition_wanderlust_novelty)
                        else selected_motivation2.text = getString(R.string.ambition_wanderlust_novelty)
            in 81..90 -> if(!isSecond) selected_motivation.text = getString(R.string.ambition_power)
                        else selected_motivation2.text = getString(R.string.ambition_power)
            in 91..100 -> if(!isSecond) selected_motivation.text = getString(R.string.ambition_religion_spirituality)
                        else selected_motivation2.text = getString(R.string.ambition_religion_spirituality)
        }
    }

    private fun chooseCause(isSecond : Boolean){
        val result : Int = Random().nextInt(100)+1
        when(result){
            in 1..10 -> if(!isSecond) selected_motivation.text = getString(R.string.cause_religion_spirituality)
                        else selected_motivation2.text = getString(R.string.cause_religion_spirituality)
            in 11..20 -> if(!isSecond) selected_motivation.text = getString(R.string.cause_theweak_charity)
                        else selected_motivation2.text = getString(R.string.cause_theweak_charity)
            in 21..30 -> if(!isSecond) selected_motivation.text = getString(R.string.cause_nonhuman_rights)
                        else selected_motivation2.text = getString(R.string.cause_nonhuman_rights)
            in 31..40 -> if(!isSecond) selected_motivation.text = getString(R.string.cause_local_politics)
                        else selected_motivation2.text = getString(R.string.cause_local_politics)
            in 41..50 -> if(!isSecond) selected_motivation.text = getString(R.string.cause_overthrow_the_empire)
                        else selected_motivation2.text = getString(R.string.cause_overthrow_the_empire)
            in 51..60 -> if(!isSecond) selected_motivation.text = getString(R.string.cause_crime)
                        else selected_motivation2.text = getString(R.string.cause_crime)
            in 61..70 -> if(!isSecond) selected_motivation.text = getString(R.string.cause_emancipation)
                        else selected_motivation2.text = getString(R.string.cause_emancipation)
            in 71..80 -> if(!isSecond) selected_motivation.text = getString(R.string.cause_droid_rights)
                        else selected_motivation2.text = getString(R.string.cause_droid_rights)
            in 81..90 -> if(!isSecond) selected_motivation.text = getString(R.string.cause_capitalism)
                        else selected_motivation2.text = getString(R.string.cause_capitalism)
            in 91..100 -> if(!isSecond) selected_motivation.text = getString(R.string.cause_support_the_empire)
                        else selected_motivation2.text = getString(R.string.cause_support_the_empire)
        }
    }

    private fun chooseRelationship(isSecond : Boolean){
        val result : Int = Random().nextInt(100)+1
        when(result){
            in 1..10 -> if(!isSecond) selected_motivation.text = getString(R.string.relation_place_of_origin)
                        else selected_motivation2.text = getString(R.string.relation_place_of_origin)
            in 11..20 -> if(!isSecond) selected_motivation.text = getString(R.string.relation_pet)
                        else selected_motivation2.text = getString(R.string.relation_pet)
            in 21..30 -> if(!isSecond) selected_motivation.text = getString(R.string.relation_childhood_friend)
                        else selected_motivation2.text = getString(R.string.relation_childhood_friend)
            in 31..40 -> if(!isSecond) selected_motivation.text = getString(R.string.relation_comrades)
                        else selected_motivation2.text = getString(R.string.relation_comrades)
            in 41..50 -> if(!isSecond) selected_motivation.text = getString(R.string.relation_siblings)
                        else selected_motivation2.text = getString(R.string.relation_siblings)
            in 51..60 -> if(!isSecond) selected_motivation.text = getString(R.string.relation_mentor)
                        else selected_motivation2.text = getString(R.string.relation_mentor)
            in 61..70 -> if(!isSecond) selected_motivation.text = getString(R.string.relation_parents)
                        else selected_motivation2.text = getString(R.string.relation_parents)
            in 71..80 -> if(!isSecond) selected_motivation.text = getString(R.string.relation_extended_family_clan)
                        else selected_motivation2.text = getString(R.string.relation_extended_family_clan)
            in 81..90 -> if(!isSecond) selected_motivation.text = getString(R.string.relation_droid_companion)
                        else selected_motivation2.text = getString(R.string.relation_droid_companion)
            in 91..100 -> if(!isSecond) selected_motivation.text = getString(R.string.relation_former_nemesis)
                        else selected_motivation2.text = getString(R.string.relation_former_nemesis)
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
}