package com.chrisphil.charbuilder.help

import java.util.*

/**
 * Created by Phil on 12.01.2018.
 */
class DiceHelper {

    data class DiceSide(val success : Int,
                        val failure : Int,
                        val triumph : Int,
                        val despair : Int,
                        val threat : Int,
                        val advantage : Int,
                        val lightside : Int,
                        val darkside : Int)

    class Dice(val sites : Array<DiceSide>){
        fun getSideCount() : Int {
            return sites.count()
        }

        fun random(range: IntRange) = Random().nextInt(range.last - range.start) + range.start

        fun roll() : DiceSide {
            return sites[random(IntRange(0,sites.count()-1))]
        }
    }


    val proficiency_die = arrayOf(
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

    val challenge_die = arrayOf(
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

    val difficulty_die = arrayOf(
            DiceSide(0,0,0,0,0,0,0,0),
            DiceSide(0,1,0,0,0,0,0,0),
            DiceSide(0,2,0,0,0,0,0,0),
            DiceSide(0,0,0,0,1,0,0,0),
            DiceSide(0,0,0,0,1,0,0,0),
            DiceSide(0,0,0,0,1,0,0,0),
            DiceSide(0,0,0,0,2,0,0,0),
            DiceSide(0,1,0,0,1,0,0,0)
            )

    val force_die = arrayOf(
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

    val ability_die = arrayOf(
            DiceSide(0,0,0,0,0,0,0,0),
            DiceSide(1,0,0,0,0,0,0,0),
            DiceSide(1,0,0,0,0,0,0,0),
            DiceSide(2,0,0,0,0,0,0,0),
            DiceSide(0,0,0,0,0,1,0,0),
            DiceSide(0,0,0,0,0,1,0,0),
            DiceSide(1,0,0,0,0,1,0,0),
            DiceSide(0,0,0,0,0,2,0,0)
            )

    val setback_die = arrayOf(
            DiceSide(0,0,0,0,0,0,0,0),
            DiceSide(0,0,0,0,0,0,0,0),
            DiceSide(0,1,0,0,0,0,0,0),
            DiceSide(0,1,0,0,0,0,0,0),
            DiceSide(0,0,0,0,1,0,0,0),
            DiceSide(0,0,0,0,1,0,0,0)
    )

    val boost_die = arrayOf(
            DiceSide(0,0,0,0,0,0,0,0),
            DiceSide(0,0,0,0,0,0,0,0),
            DiceSide(1,0,0,0,0,0,0,0),
            DiceSide(1,0,0,0,0,1,0,0),
            DiceSide(0,0,0,0,0,2,0,0),
            DiceSide(0,0,0,0,0,1,0,0)
    )
}