package com.chrisphil.charbuilder.controller

import android.support.v4.app.Fragment
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.Toast
import com.chrisphil.charbuilder.R
import kotlinx.android.synthetic.main.fragment_dice.*
import kotlinx.android.synthetic.main.fragment_dice.view.*

/**
 * Created by Phil on 24.11.2017.
 */
class DiceController : Fragment() {

    val diceMaxCount = 10
    val diceCount: IntArray = intArrayOf(0, 0, 0, 0, 0, 0, 0)

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

        return view
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
            Toast.makeText(context,"Du kannst nur 10 von jedem Würfel haben",Toast.LENGTH_SHORT).show()
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

    }

    private fun displayRollHistory(){

    }
}