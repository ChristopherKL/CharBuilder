package com.chrisphil.charbuilder.creationfragments

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseExpandableListAdapter
import com.chrisphil.charbuilder.R
import kotlinx.android.synthetic.main.char_creation_career.view.*
import kotlinx.android.synthetic.main.char_creation_career_child_item.view.*
import kotlinx.android.synthetic.main.char_creation_career_group_item.view.*
import org.xmlpull.v1.XmlPullParser


class CareerFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view : View = inflater!!.inflate(R.layout.char_creation_career, container, false)

        var careers = loadCareers()
        view.career_list.setAdapter(CareerListAdapter(context,careers))

        return view
    }

    data class Career(val id : Long,
                      val name : String,
                      val subclass1 : String,
                      val subclass1ID : Long,
                      val subclass2 : String,
                      val subclass2ID : Long,
                      val subclass3 : String,
                      val subclass3ID : Long)


    private fun loadCareers() : ArrayList<Career>{
        val allCareers = ArrayList<Career>()
        var id_count = 0L
        val xml = resources.getXml(R.xml.career)
        while(xml.eventType != XmlPullParser.END_DOCUMENT){
            if(xml.eventType == XmlPullParser.START_TAG){
                if(xml.name == "career"){

                    val current = Career(
                            id_count,                                                   //ID
                            xml.getAttributeValue(null, "name"),               //Name
                            xml.getAttributeValue(null, "subclass1"),          //First Subclass
                            id_count*10+1,
                            xml.getAttributeValue(null, "subclass2"),          //Second Subclass
                            id_count*10+2,
                            xml.getAttributeValue(null, "subclass3"),           //Third Subclass
                            id_count*10+3
                    )
                    allCareers.add(current)
                    id_count++
                }
            }
            xml.next()
        }
        return allCareers
    }

    inner class CareerListAdapter(context : Context,var careers : ArrayList<Career>) : BaseExpandableListAdapter() {
        override fun getGroup(p0: Int): Any {
            return careers[p0]
        }

        override fun isChildSelectable(p0: Int, p1: Int): Boolean {
            return true
        }

        override fun hasStableIds(): Boolean {
            return true
        }

        override fun getChild(p0: Int, p1: Int): Any {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        override fun getGroupId(p0: Int): Long {
            return careers[p0].id
        }

        override fun getChildId(p0: Int, p1: Int): Long {
            when(p1){
                0 -> return careers[p0].subclass1ID
                1 -> return careers[p0].subclass2ID
                2 -> return careers[p0].subclass3ID
            }
            return careers[p0].subclass1ID
        }

        override fun getChildrenCount(p0: Int): Int {
            return 3 //Every Career has 3 subclasses no more no less
        }

        override fun isEmpty(): Boolean {
            return careers.isEmpty()
        }

        override fun getChildView(p0: Int, p1: Int, p2: Boolean, p3: View?, p4: ViewGroup?): View {
            val li = LayoutInflater.from(context)
            val view = li.inflate(R.layout.char_creation_career_child_item,p4,false)
            when(p1){
                0 -> view.career_subtype.text = careers[p0].subclass1
                1 -> view.career_subtype.text = careers[p0].subclass2
                2 -> view.career_subtype.text = careers[p0].subclass3
            }

            return view
        }

        override fun getGroupView(p0: Int, p1: Boolean, p2: View?, p3: ViewGroup?): View {
            val li = LayoutInflater.from(context)
            val view = li.inflate(R.layout.char_creation_career_group_item,p3,false)
            view.career_name.text = careers[p0].name
            return view
        }

        override fun getGroupCount(): Int {
            return careers.size
        }

    }


    companion object {

        private val ARG_SECTION_NUMBER = "section_number"

        fun newInstance(sectionNumber: Int): CareerFragment {
            val fragment = CareerFragment()
            val args = Bundle()
            args.putInt(ARG_SECTION_NUMBER, sectionNumber)
            fragment.arguments = args
            return fragment
        }
    }
}