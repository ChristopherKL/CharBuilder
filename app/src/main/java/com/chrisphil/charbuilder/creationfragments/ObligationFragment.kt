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
import com.chrisphil.charbuilder.interfaces.OnDataPass
import kotlinx.android.synthetic.main.char_creation_obligation.*
import kotlinx.android.synthetic.main.char_creation_obligation.view.*
import kotlinx.android.synthetic.main.char_creation_listview.view.*
import org.xmlpull.v1.XmlPullParser
import java.util.Random

/**
 * Created by Christopher on 04.12.2017.
 */
class ObligationFragment : Fragment() {

    data class Obligation(
        val id : Long,
        val name : String,
        val description : String,
        val text : String
    )

    lateinit var dataPass : OnDataPass

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view : View = inflater!!.inflate(R.layout.char_creation_obligation, container, false)
        val list : ListView = view.obligation_listView
        var obligationArray = loadObligations()
        val adapter = ObligationsViewAdapter(context,obligationArray)
        list.adapter = adapter
        view.random_obligation_button.setOnClickListener{
            val obligationResult : Int = Random().nextInt(100)+1
            when(obligationResult) {
                in 1..96 -> chooseObligation(obligationResult)
                in 97..100 -> chooseTwoObligations()
            }
        }
        return view
    }

    private fun loadObligations() : ArrayList<Obligation>{
        val allObligations = ArrayList<Obligation>()
        var id_count = 0L
        val xml = resources.getXml(R.xml.obligations)
        while(xml.eventType != XmlPullParser.END_DOCUMENT){
            if(xml.eventType == XmlPullParser.START_TAG){
                if(xml.name == "obligation"){

                    val current = Obligation(
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

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        dataPass = context as OnDataPass
    }

    private fun chooseObligation(result : Int){
        when(result){
            in 1..8 -> selected_obligation.text = getString(R.string.obligation_addiction)
            in 9..16 -> selected_obligation.text = getString(R.string.obligation_betrayal)
            in 17..24 -> selected_obligation.text = getString(R.string.obligation_blackmail)
            in 25..32 -> selected_obligation.text = getString(R.string.obligation_bounty)
            in 33..40 -> selected_obligation.text = getString(R.string.obligation_criminal)
            in 41..48 -> selected_obligation.text = getString(R.string.obligation_debt)
            in 49..56 -> selected_obligation.text = getString(R.string.obligation_dutybound)
            in 57..64 -> selected_obligation.text = getString(R.string.obligation_family)
            in 65..72 -> selected_obligation.text = getString(R.string.obligation_favor)
            in 73..80 -> selected_obligation.text = getString(R.string.obligation_oath)
            in 81..88 -> selected_obligation.text = getString(R.string.obligation_obsession)
            in 89..96 -> selected_obligation.text = getString(R.string.obligation_responsibility)
        }
    }

    private fun chooseTwoObligations(){

    }

    override fun onDestroyView() {
        dataPass.onDataPass("TODO")
        super.onDestroyView()
    }

    inner class ObligationsViewAdapter(context: Context, var obligations : ArrayList<Obligation>) : BaseAdapter() {

        override fun getItem(p0: Int): Any {
            return obligations[p0]
        }

        override fun getItemId(p0: Int): Long {
            return obligations[p0].id
        }
        override fun getCount(): Int {
            return obligations.count()
        }

        override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
            val li = LayoutInflater.from(context)
            val view = li.inflate(R.layout.char_creation_listview,p2,false)
            var name_view = view.firstLine
            name_view.text = obligations[p0].name

            var desc_view = view.secondLine
            desc_view.text = obligations[p0].description

            var button = view.icon
            button.setOnClickListener {
                createObligationsInfoDialog(obligations[p0])
            }
            return view
        }

    }

    private fun createObligationsInfoDialog(obligation : Obligation){
        var dialogBuilder = AlertDialog.Builder(context)
        dialogBuilder.setMessage(obligation.text)
                .setTitle(obligation.name)
        val dialog = dialogBuilder.create()
        dialog.setButton(AlertDialog.BUTTON_NEUTRAL,getString(R.string.dialog_ok),{
            _, _ ->
            dialog.dismiss()
        })
        dialog.show()
    }

    companion object {

        private val ARG_SECTION_NUMBER = "section_number"

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        fun newInstance(sectionNumber: Int): ObligationFragment {
            val fragment = ObligationFragment()
            val args = Bundle()
            args.putInt(ARG_SECTION_NUMBER, sectionNumber)
            fragment.arguments = args
            return fragment
        }
    }
}