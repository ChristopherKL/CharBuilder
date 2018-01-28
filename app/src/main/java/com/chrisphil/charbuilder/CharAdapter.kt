package com.chrisphil.charbuilder

import android.app.AlertDialog
import android.content.Intent
import android.content.Context
import android.view.ViewGroup
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.chrisphil.charbuilder.controller.CharDetailsController
import com.chrisphil.charbuilder.help.PdfExport
import kotlinx.android.synthetic.main.char_list.view.*
import kotlinx.android.synthetic.main.char_list_longclick_dialog.view.*

/**
 * Created by Phil on 09.11.2017.
 */
class CharAdapter (private val charList:ArrayList<Player>,val context: Context ) :  RecyclerView.Adapter<CharAdapter.CharViewHolder>(){

    override fun getItemCount(): Int {
        return charList.size
    }

    override fun onBindViewHolder(holder: CharViewHolder, position: Int) {
        val ci : Player = MainNavigationDrawer.characterList.get(position)
        holder.vName.text = ci.name
        holder.vSpecies.text = ci.species
        holder.vBeruf.text = ci.career
        holder.vSpec.text = ci.specialization
        when(ci.species){
            "Droide" -> holder.vSpeciesImage.setImageResource(R.drawable.droide_trans)
            "Gand" -> holder.vSpeciesImage.setImageResource(R.drawable.gand_trans)
            "Rodianer" -> holder.vSpeciesImage.setImageResource(R.drawable.rodian_trans)
            "Twi'lek" -> holder.vSpeciesImage.setImageResource(R.drawable.twi_lek)
            "Trandoshaner" -> holder.vSpeciesImage.setImageResource(R.drawable.trandoshan)
            "Mensch" -> holder.vSpeciesImage.setImageResource(R.drawable.human_trans)
            "Bothaner" -> holder.vSpeciesImage.setImageResource(R.drawable.bothan_trans)
            "Wookiee" -> holder.vSpeciesImage.setImageResource(R.drawable.wookie_trans)
        }

        holder.itemView.setOnClickListener {
            CharDetailsController.playerObject = ci
            CharDetailsController.currentPlayerID = position
            val intent = Intent(context,CharDetailsController::class.java)
            context.startActivity(intent)
        }

        holder.itemView.setOnLongClickListener {
            Log.d("Test","Du geiler Drücker")
            var dialogBuilder = AlertDialog.Builder(context)
            var view = LayoutInflater.from(context).inflate(R.layout.char_list_longclick_dialog,null)
            dialogBuilder.setView(view)
            var dialog = dialogBuilder.create()
            view.deleteButton.setOnClickListener {
                MainNavigationDrawer.characterList.removeAt(position)
                this.notifyDataSetChanged()
                Toast.makeText(context,"Charakter gelöscht",Toast.LENGTH_LONG)
                dialog.dismiss()
            }
            view.exportPDFButton.setOnClickListener {
                PdfExport.exportPlayerPdf(ci)
                dialog.dismiss()
            }
            dialog.setButton("Abbrechen", {
                _, _ ->
                dialog.dismiss()
            })
            dialog.show()
            true
        }

    }

    override fun  onCreateViewHolder(viewGroup: ViewGroup, i : Int) : CharViewHolder {
        val itemView : View = LayoutInflater.from(viewGroup.context).inflate(R.layout.char_list,viewGroup,false)
        return CharViewHolder(itemView)
    }

    class CharViewHolder constructor(v: View) : RecyclerView.ViewHolder(v) {
        val vName : TextView = v.charName
        val vSpecies : TextView = v.charSpezies
        val vBeruf : TextView = v.charBeruf
        val vSpec : TextView = v.charSpec
        val vSpeciesImage : ImageView = v.species_picture
    }
}