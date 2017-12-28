package com.chrisphil.charbuilder.creationfragments

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ListView
import android.widget.TextView
import com.chrisphil.charbuilder.R
import org.xmlpull.v1.XmlPullParser

/**
 * Created by Christopher on 04.12.2017.
 */
class SpeciesFragment : Fragment() {

    data class Species(val id : Long,
                       val name : String,
                       val description : String,
                       val brawn : Int,
                       val agility : Int,
                       val intellect : Int,
                       val cunning : Int,
                       val willpower : Int,
                       val presence : Int,
                       val wound_threshold : String,
                       val strain_threshold : String,
                       val start_exp : Int,
                       val special : String)

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view : View = inflater!!.inflate(R.layout.char_creation_species, container, false);
        val liste : ListView = view.findViewById(R.id.listview)
        var species = loadSpecies()

        val adapter = SpeciesViewAdapter(context,species)

        liste.adapter = adapter

        return view;
    }

    private fun loadSpecies() : ArrayList<Species>{
        val allSpecies = ArrayList<Species>()
        var id_count = 0L
        val xml = resources.getXml(R.xml.species)
        while(xml.eventType != XmlPullParser.END_DOCUMENT){
            if(xml.eventType == XmlPullParser.START_TAG){
                if(xml.name == "species"){

                    val current = Species(
                            id_count,                                                               //ID
                            xml.getAttributeValue(null,"name"),                            //Name
                            xml.getAttributeValue(null,"description"),                     //Description
                            xml.getAttributeValue(null,"brawn_stat").toInt(),              //Brawn
                            xml.getAttributeValue(null,"agility_stat").toInt(),            //Agility
                            xml.getAttributeValue(null,"intellect_stat").toInt(),          //Intellect
                            xml.getAttributeValue(null,"cunning_stat").toInt(),            //Cunning
                            xml.getAttributeValue(null,"willpower_stat").toInt(),          //Willpower
                            xml.getAttributeValue(null,"presence_stat").toInt(),           //Presence
                            xml.getAttributeValue(null,"wound_threshold"),                 //Wound Threshold
                            xml.getAttributeValue(null,"strain_threshold"),                //Strain Threshold
                            xml.getAttributeValue(null,"starting_exp").toInt(),            //Start Exp
                            xml.getAttributeValue(null,"special")                          //Special
                            )
                    allSpecies.add(current)
                    id_count++
                }
            }
            xml.next()
        }
        return allSpecies
    }


    inner class SpeciesViewAdapter(context: Context, var species: ArrayList<Species>) : BaseAdapter() {

        override fun getItem(p0: Int): Any {
            return species[p0]
        }

        override fun getItemId(p0: Int): Long {
            return species[p0].id
        }

        override fun getCount(): Int {
            return species.count();
        }

        override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
            val li = LayoutInflater.from(context)
            val view = li.inflate(R.layout.char_creation_listview,p2,false)
            var name_view = view.findViewById<TextView>(R.id.firstLine)
            name_view.text = species[p0].name
            var desc_view = view.findViewById<TextView>(R.id.secondLine)
            desc_view.text = species[p0].description
            return view;
        }

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
        fun newInstance(sectionNumber: Int): SpeciesFragment {
            val fragment = SpeciesFragment()
            val args = Bundle()
            args.putInt(ARG_SECTION_NUMBER, sectionNumber)
            fragment.arguments = args
            return fragment
        }
    }

}