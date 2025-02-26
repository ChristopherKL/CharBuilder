package com.chrisphil.charbuilder.creationfragments

import android.app.AlertDialog
import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.*
import android.widget.AbsListView.CHOICE_MODE_SINGLE
import android.widget.BaseAdapter
import android.widget.ListView
import com.chrisphil.charbuilder.R
import com.chrisphil.charbuilder.controller.CharCreationController
import com.chrisphil.charbuilder.interfaces.OnDataPass
import kotlinx.android.synthetic.main.char_creation_listview.view.*
import kotlinx.android.synthetic.main.char_creation_species.*
import kotlinx.android.synthetic.main.char_creation_species.view.*
import org.xmlpull.v1.XmlPullParser

class SpeciesFragment : Fragment() {

    lateinit var dataPass : OnDataPass

    data class Species(val id : Long,
                       val name : String,
                       val description : String,
                       val brawn : Int,
                       val agility : Int,
                       val intellect : Int,
                       val cunning : Int,
                       val willpower : Int,
                       val presence : Int,
                       val wound_threshold : Int,
                       val strain_threshold : Int,
                       val start_exp : Int,
                       val special : String)

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view : View = inflater!!.inflate(R.layout.char_creation_species, container, false)
        val liste : ListView = view.listview

        liste.choiceMode = CHOICE_MODE_SINGLE

        var species = loadSpecies()

        val adapter = SpeciesViewAdapter(context,species)
        liste.adapter = adapter

        if(CharCreationController.playerObject.species != "") {
            view.currentSpecies.text = CharCreationController.playerObject.species
        }

        liste.setOnItemClickListener{
            _, _, position, _ ->
            CharCreationController.playerObject.species = species[position].name
            CharCreationController.playerObject.brawn = species[position].brawn
            CharCreationController.playerObject.agility = species[position].agility
            CharCreationController.playerObject.intellect = species[position].intellect
            CharCreationController.playerObject.cunning = species[position].cunning
            CharCreationController.playerObject.willpower = species[position].willpower
            CharCreationController.playerObject.presence = species[position].presence
            CharCreationController.playerObject.woundThreshold = species[position].wound_threshold + species[position].brawn
            CharCreationController.playerObject.strainThreshold = species[position].strain_threshold + species[position].willpower
            CharCreationController.playerObject.experience = species[position].start_exp
            view.currentSpecies.text = species[position].name
        }

        return view
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
                            xml.getAttributeValue(null,"wound_threshold").toInt(),         //Wound Threshold
                            xml.getAttributeValue(null,"strain_threshold").toInt(),        //Strain Threshold
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
            return species.count()
        }

        override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
            val li = LayoutInflater.from(context)
            val view = li.inflate(R.layout.char_creation_listview,p2,false)

            var name_view = view.firstLine
            name_view.text = species[p0].name

            var desc_view = view.secondLine
            desc_view.text = species[p0].description

            var button = view.icon
            button.setOnClickListener {
                createSpeciesInfoDialog(species[p0])
            }
            return view
        }

    }

    fun createSpeciesInfoDialog(species : Species){
        var dialogBuilder = AlertDialog.Builder(context)

        dialogBuilder.setTitle(resources.getString(R.string.species_info_dialog_title))
                .setMessage(species.special)

        val b = dialogBuilder.create()
        b.show()

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

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        dataPass = context as OnDataPass
    }

    override fun onDestroyView() {
        dataPass.onDataPass(listview.selectedItemId.toString()) //TODO: Real Item instead of id
        super.onDestroyView()
    }

}