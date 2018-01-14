package com.chrisphil.charbuilder.controller

import android.support.v4.app.Fragment
import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.Toast
import com.chrisphil.charbuilder.R
import com.chrisphil.charbuilder.help.DiceHelper
import com.google.gson.Gson
import kotlinx.android.synthetic.main.fragment_dice.*
import kotlinx.android.synthetic.main.fragment_dice.view.*

/**
 * Created by Phil on 24.11.2017.
 */
class DiceController : Fragment() {

    private val diceMaxCount = 6
    private val historyMaxCount = 5

    private var diceCount: IntArray = intArrayOf(0, 0, 0, 0, 0, 0, 0)
    private var rollHistory : Array<RollHistoryEntry> = Array(historyMaxCount){RollHistoryEntry("", DiceHelper.DiceSide(0,0,0,0,0,0,0,0))}

    data class RollHistoryEntry(val time : String,
                                val result : DiceHelper.DiceSide)

    companion object {
        fun newInstance(): DiceController {
            return DiceController()
        }
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view: View = inflater!!.inflate(R.layout.fragment_dice,container,false)

        view.proficiency_button.setOnClickListener {
            onProficiencyDiceButton(context)
        }

        view.challenge_button.setOnClickListener {
            onChallengeDiceButton(context)
        }

        view.boost_button.setOnClickListener {
            onBoostDiceButton(context)
        }

        view.difficulty_button.setOnClickListener {
            onDifficultyDiceButton(context)
        }

        view.force_button.setOnClickListener {
            onForceDiceButton(context)
        }

        view.setback_button.setOnClickListener {
            onSetbackDiceButton(context)
        }

        view.ability_button.setOnClickListener {
            onAbilityDiceButton(context)
        }

        view.roll_dice_button.setOnClickListener {
            rollDice()
        }

        view.roll_history_button.setOnClickListener {
            displayRollHistory()
        }

        rollHistory = loadArrayFromPreference(context,"rollHistory","rollHistoryArray")

        return view
    }

    private fun saveArrayToPreference(context: Context,array: Array<RollHistoryEntry>,prefName : String,stringName : String){
        var settings = context.getSharedPreferences(prefName,0)
        settings.edit().putString(stringName,Gson().toJson(array)).commit()
    }

    private fun loadArrayFromPreference(context: Context,prefName : String,stringName : String) : Array<RollHistoryEntry>{
        var settings = context.getSharedPreferences(prefName,0)
        val arrayJson = settings.getString(stringName,Gson().toJson(rollHistory))
        return Gson().fromJson(arrayJson,rollHistory.javaClass)
    }


    private fun onProficiencyDiceButton(context: Context){
        if(diceCount[0] < diceMaxCount) {
            diceCount[0] += 1
            var diceButton = ImageView(context)
            diceButton.setImageDrawable(context.getDrawable(R.drawable.dice_proficiency))
            diceButton.setOnClickListener {
                diceCount[0] -= 1
                proficiency_dice_list.removeView(diceButton)
            }
            val param = LinearLayout.LayoutParams(100, 100)
            diceButton.layoutParams = param
            proficiency_dice_list.addView(diceButton)
        }else{
            Toast.makeText(context,"Du kannst nur "+ diceMaxCount +" von jedem Würfel haben",Toast.LENGTH_SHORT).show()
        }
    }

    private fun onChallengeDiceButton(context: Context){
        if(diceCount[1] < diceMaxCount) {
            diceCount[1] += 1
            var diceButton = ImageView(context)
            diceButton.setImageDrawable(context.getDrawable(R.drawable.dice_challenge))
            diceButton.setOnClickListener {
                diceCount[1] -= 1
                challenge_dice_list.removeView(diceButton)
            }
            val param = LinearLayout.LayoutParams(100, 100)
            diceButton.layoutParams = param
            challenge_dice_list.addView(diceButton)
        }else{
            Toast.makeText(context,"Du kannst nur "+ diceMaxCount +" von jedem Würfel haben",Toast.LENGTH_SHORT).show()
        }
    }

    private fun onBoostDiceButton(context: Context){
        if(diceCount[2] < diceMaxCount) {
            diceCount[2] += 1
            var diceButton = ImageView(context)
            diceButton.setImageDrawable(context.getDrawable(R.drawable.dice_boost))
            diceButton.setOnClickListener {
                diceCount[2] -= 1
                boost_dice_list.removeView(diceButton)
            }
            val param = LinearLayout.LayoutParams(100, 100)
            diceButton.layoutParams = param
            boost_dice_list.addView(diceButton)
        }else{
            Toast.makeText(context,"Du kannst nur "+ diceMaxCount +" von jedem Würfel haben",Toast.LENGTH_SHORT).show()
        }
    }

    private fun onDifficultyDiceButton(context: Context){
        if(diceCount[3] < diceMaxCount) {
            diceCount[3] += 1
            var diceButton = ImageView(context)
            diceButton.setImageDrawable(context.getDrawable(R.drawable.dice_difficulty))
            diceButton.setOnClickListener {
                diceCount[3] -= 1
                difficulty_dice_list.removeView(diceButton)
            }
            val param = LinearLayout.LayoutParams(100, 100)
            diceButton.layoutParams = param
            difficulty_dice_list.addView(diceButton)
        }else{
            Toast.makeText(context,"Du kannst nur "+ diceMaxCount +" von jedem Würfel haben",Toast.LENGTH_SHORT).show()
        }
    }

    private fun onForceDiceButton(context: Context){
        if(diceCount[4] < diceMaxCount) {
            diceCount[4] += 1
            var diceButton = ImageView(context)
            diceButton.setImageDrawable(context.getDrawable(R.drawable.dice_force))
            diceButton.setOnClickListener {
                diceCount[4] -= 1
                force_dice_list.removeView(diceButton)
            }
            val param = LinearLayout.LayoutParams(100, 100)
            diceButton.layoutParams = param
            force_dice_list.addView(diceButton)
        }else{
            Toast.makeText(context,"Du kannst nur "+ diceMaxCount +" von jedem Würfel haben",Toast.LENGTH_SHORT).show()
        }
    }

    private fun onSetbackDiceButton(context: Context){
        if(diceCount[5] < diceMaxCount) {
            diceCount[5] += 1
            var diceButton = ImageView(context)
            diceButton.setImageDrawable(context.getDrawable(R.drawable.dice_setback))
            diceButton.setOnClickListener {
                diceCount[5] -= 1
                setback_dice_list.removeView(diceButton)
            }
            val param = LinearLayout.LayoutParams(100, 100)
            diceButton.layoutParams = param
            setback_dice_list.addView(diceButton)
        }else{
            Toast.makeText(context,"Du kannst nur "+ diceMaxCount +" von jedem Würfel haben",Toast.LENGTH_SHORT).show()
        }
    }

    private fun onAbilityDiceButton(context: Context){
        if(diceCount[6] < diceMaxCount) {
            diceCount[6] += 1
            var diceButton = ImageView(context)
            diceButton.setImageDrawable(context.getDrawable(R.drawable.dice_ability))
            diceButton.setOnClickListener {
                diceCount[6] -= 1
                ability_dice_list.removeView(diceButton)
            }
            val param = LinearLayout.LayoutParams(100, 100)
            diceButton.layoutParams = param
            ability_dice_list.addView(diceButton)
        }else{
            Toast.makeText(context,"Du kannst nur "+ diceMaxCount +" von jedem Würfel haben",Toast.LENGTH_SHORT).show()
        }
    }

    private fun rollDice(){
        val result = ArrayList<DiceHelper.DiceSide>()
        for(i in diceCount.indices){
            for (d in 1..diceCount[i]){
                when(i){
                    0 -> result.add(DiceHelper.profciciency_die.roll())
                    1 -> result.add(DiceHelper.challenge_die.roll())
                    2 -> result.add(DiceHelper.boost_die.roll())
                    3 -> result.add(DiceHelper.difficulty_die.roll())
                    4 -> result.add(DiceHelper.force_die.roll())
                    5 -> result.add(DiceHelper.setback_die.roll())
                    6 -> result.add(DiceHelper.ability_die.roll())
                }
            }
        }
        val final_result = calculate_result(result)
        Log.d("ROLL","Success: " + final_result.success + " Failure: " + final_result.failure + " Advantage: " + final_result.advantage)
    }

    private fun calculate_result(result: ArrayList<DiceHelper.DiceSide>) : DiceHelper.DiceSide{
        //Pack everything in one DiceSide
        var addedResult : DiceHelper.DiceSide = DiceHelper.DiceSide(0,0,0,0,0,0,0,0)

        for(side in result){
            addedResult.success     += side.success
            addedResult.failure     += side.failure
            addedResult.triumph     += side.triumph
            addedResult.despair     += side.despair
            addedResult.threat      += side.threat
            addedResult.advantage   += side.advantage
            addedResult.lightside   += side.lightside
            addedResult.darkside    += side.darkside
        }

        //Success & Failure
        if(addedResult.success >= addedResult.failure) {
            addedResult.success = addedResult.success - addedResult.failure
            addedResult.failure = 0
        }else{
            addedResult.failure = addedResult.failure - addedResult.success
            addedResult.success = 0
        }

        //Advantage & Threat
        if(addedResult.advantage >= addedResult.threat) {
            addedResult.advantage = addedResult.advantage - addedResult.threat
            addedResult.threat = 0
        }else{
            addedResult.threat = addedResult.threat - addedResult.advantage
            addedResult.advantage = 0
        }

        //Lightside & Darkside
        if(addedResult.lightside >= addedResult.darkside) {
            addedResult.lightside = addedResult.lightside - addedResult.darkside
            addedResult.darkside = 0
        }else{
            addedResult.darkside = addedResult.darkside - addedResult.lightside
            addedResult.lightside = 0
        }

        return addedResult
    }

    private fun displayRollHistory(){

    }

    override fun onStop() {
        super.onStop()
        saveArrayToPreference(context,rollHistory,"rollHistory","rollHistoryArray")
    }
}