package com.chrisphil.charbuilder

import android.view.ViewGroup
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView
import android.widget.TextView;

/**
 * Created by Phil on 09.11.2017.
 */
class CharAdapter (private val charList:List<CharInfo> ) :  RecyclerView.Adapter<CharAdapter.CharViewHolder>(){

    override fun getItemCount(): Int {
        return charList.size
    }

    override fun onBindViewHolder(holder: CharViewHolder, position: Int) {
        val ci : CharInfo = charList.get(position)
        holder.vName.text = ci.name
        holder.vRPG.text = ci.rpg
    }

    override fun  onCreateViewHolder(viewGroup: ViewGroup, i : Int) : CharViewHolder {
        val itemView : View = LayoutInflater.from(viewGroup.context).inflate(R.layout.char_list,viewGroup,false)
        return CharViewHolder(itemView)
    }

    class CharViewHolder constructor(v: View) : RecyclerView.ViewHolder(v) {
        val vImage : ImageView  = v.findViewById(R.id.charPicture)
        val vName : TextView = v.findViewById(R.id.charName)
        val vRPG : TextView = v.findViewById(R.id.charRuleset)
    }
}