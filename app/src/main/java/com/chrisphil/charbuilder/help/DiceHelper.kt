package com.chrisphil.charbuilder.help

import java.util.*

/**
 * Created by Phil on 12.01.2018.
 */
class DiceHelper {


    data class DiceSide(var success : Int,
                        var failure : Int,
                        var triumph : Int,
                        var despair : Int,
                        var threat : Int,
                        var advantage : Int,
                        var lightside : Int,
                        var darkside : Int)

    class Dice(val sites : Array<DiceSide>){
        fun getSideCount() : Int {
            return sites.count()
        }

        fun random(range: IntRange) = Random().nextInt(range.last - range.start) + range.start

        fun roll() : DiceSide {
            return sites[random(IntRange(0,sites.count()))]
        }
    }

    companion object {

        private val proficiency_die_array = arrayOf(
                DiceSide(0,0,0,0,0,0,0,0),
                DiceSide(1,0,0,0,0,0,0,0),
                DiceSide(1,0,0,0,0,0,0,0),
                DiceSide(2,0,0,0,0,0,0,0),
                DiceSide(2,0,0,0,0,0,0,0),
                DiceSide(0,0,0,0,0,1,0,0),
                DiceSide(1,0,0,0,0,1,0,0),
                DiceSide(1,0,0,0,0,1,0,0),
                DiceSide(1,0,0,0,0,1,0,0),
                DiceSide(0,0,0,0,0,2,0,0),
                DiceSide(0,0,0,0,0,2,0,0),
                DiceSide(0,0,1,0,0,0,0,0)
        )

        private val challenge_die_array = arrayOf(
                DiceSide(0,0,0,0,0,0,0,0),
                DiceSide(0,1,0,0,0,0,0,0),
                DiceSide(0,1,0,0,0,0,0,0),
                DiceSide(0,2,0,0,0,0,0,0),
                DiceSide(0,2,0,0,0,0,0,0),
                DiceSide(0,0,0,0,1,0,0,0),
                DiceSide(0,0,0,0,1,0,0,0),
                DiceSide(0,1,0,0,1,0,0,0),
                DiceSide(0,1,0,0,1,0,0,0),
                DiceSide(0,0,0,0,2,0,0,0),
                DiceSide(0,0,0,0,2,0,0,0),
                DiceSide(0,0,0,1,0,0,0,0)
        )

        private val difficulty_die_array = arrayOf(
                DiceSide(0,0,0,0,0,0,0,0),
                DiceSide(0,1,0,0,0,0,0,0),
                DiceSide(0,2,0,0,0,0,0,0),
                DiceSide(0,0,0,0,1,0,0,0),
                DiceSide(0,0,0,0,1,0,0,0),
                DiceSide(0,0,0,0,1,0,0,0),
                DiceSide(0,0,0,0,2,0,0,0),
                DiceSide(0,1,0,0,1,0,0,0)
        )

        private val force_die_array = arrayOf(
                DiceSide(0,0,0,0,0,0,0,1),
                DiceSide(0,0,0,0,0,0,0,1),
                DiceSide(0,0,0,0,0,0,0,1),
                DiceSide(0,0,0,0,0,0,0,1),
                DiceSide(0,0,0,0,0,0,0,1),
                DiceSide(0,0,0,0,0,0,0,1),
                DiceSide(0,0,0,0,0,0,0,1),
                DiceSide(0,0,0,0,0,0,0,2),
                DiceSide(0,0,0,0,0,0,1,0),
                DiceSide(0,0,0,0,0,0,1,0),
                DiceSide(0,0,0,0,0,0,2,0),
                DiceSide(0,0,0,0,0,0,2,0),
                DiceSide(0,0,0,0,0,0,2,0)
        )

        private val ability_die_array = arrayOf(
                DiceSide(0,0,0,0,0,0,0,0),
                DiceSide(1,0,0,0,0,0,0,0),
                DiceSide(1,0,0,0,0,0,0,0),
                DiceSide(2,0,0,0,0,0,0,0),
                DiceSide(0,0,0,0,0,1,0,0),
                DiceSide(0,0,0,0,0,1,0,0),
                DiceSide(1,0,0,0,0,1,0,0),
                DiceSide(0,0,0,0,0,2,0,0)
        )

        private val setback_die_array = arrayOf(
                DiceSide(0,0,0,0,0,0,0,0),
                DiceSide(0,0,0,0,0,0,0,0),
                DiceSide(0,1,0,0,0,0,0,0),
                DiceSide(0,1,0,0,0,0,0,0),
                DiceSide(0,0,0,0,1,0,0,0),
                DiceSide(0,0,0,0,1,0,0,0)
        )

        private val boost_die_array = arrayOf(
                DiceSide(0,0,0,0,0,0,0,0),
                DiceSide(0,0,0,0,0,0,0,0),
                DiceSide(1,0,0,0,0,0,0,0),
                DiceSide(1,0,0,0,0,1,0,0),
                DiceSide(0,0,0,0,0,2,0,0),
                DiceSide(0,0,0,0,0,1,0,0)
        )

        val profciciency_die = Dice(proficiency_die_array)
        val challenge_die = Dice(challenge_die_array)
        val difficulty_die = Dice(difficulty_die_array)
        val force_die = Dice(force_die_array)
        val ability_die = Dice(ability_die_array)
        val setback_die = Dice(setback_die_array)
        val boost_die = Dice(boost_die_array)
    }
}