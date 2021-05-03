package com.dat.android.gamebit.presentation.main

import android.animation.ValueAnimator
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.dat.android.gamebit.PreferenceProvider
import com.dat.android.gamebit.R
import com.dat.android.gamebit.presentation.highscore.HighscoresActivity
import com.dat.android.gamebit.presentation.main.dialogs.FragmentDialogDefeat
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import kotlin.random.Random

class MainActivity : AppCompatActivity(R.layout.activity_main) {

   var hash = hashMapOf<Int, Float>( Pair(32, -1f), Pair(15, -20f), Pair(19, -30f), Pair(4, -40f), Pair(21, -50f),
                                    Pair(2, -60f), Pair(25, -66f), Pair(17, -76f), Pair(34, -86f), Pair(6, -96f), Pair(27, -106f),
                                    Pair(13, -114f), Pair(36, -124f), Pair(11, -134f), Pair(30, -144f), Pair(8, -154f), Pair(23, -161f),
                                    Pair(10, -171f), Pair(5, -181f), Pair(24, -191f), Pair(16, -201f), Pair(33,-210f), Pair(1, -220f),
                                    Pair(20, -230f), Pair(14, -237f), Pair(31, -247f), Pair(9, -257f), Pair(22, -267f), Pair(18, -277f),
                                    Pair(29, -284f), Pair(7, -294f), Pair(28, -303f), Pair(12, -313f), Pair(35, -323f), Pair(3, -333f),
                                    Pair(26, -341f), Pair(36, -351f))


    var redList = arrayListOf(32, 19, 21, 25, 34, 27, 36, 30, 23, 5, 16, 1, 14, 9, 18, 7, 12, 3)

    var blackList = arrayListOf(15, 4, 2, 17, 6, 13, 11, 8, 10, 24, 33, 20, 31, 22, 29, 28, 35, 26)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        updateUI()
        bindSpinners()
        bindSpinnersNumbers()
        pressBlackButton()
        pressRedButton()



        iv_show_highscoresActivity.setOnClickListener {
            var intentHigh = Intent(this@MainActivity, HighscoresActivity::class.java)
            startActivity(intentHigh)
        }




        /*tv_button_play.setOnClickListener {
            var dialogDefeat = FragmentDialogDefeat()
            dialogDefeat.show(supportFragmentManager, "customDialog")
        }*/ // диалог

        /*var animator = ValueAnimator.ofFloat(0f, 360f)
        animator.addUpdateListener {
            ivRoulete.rotation = it.animatedValue.toString().toFloat()
        }
        animator.start()*/

       // var value = Random.nextInt(5, 10)
      //  var amountRotations = value * 360f


    }

    private fun bindSpinners() {
        val data =
            arrayOf("$50", "$100", "$200", "$300", "$400", "$500", "$1000", "$1500", "$2000")
        npBet.minValue = 1
        npBet.maxValue = data.size
        npBet.displayedValues = data
        npBet.value = 3
        /// "kek,lol,kek,kek" -- split --> array("kek", "lol", "kek", "kek") --> array[1] == "lol"
        /// "$50" -- split("$") --- array( "", "50") --- array[1].toInt

        var value = data[0].split("$")[1].toInt()
    }

    private fun bindSpinnersNumbers() {
        val num =
            arrayOf("1", "2", "3", "4", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15",
                "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29",
                "30", "31", "32", "33", "34", "35", "36", "0" )

        npNumber.minValue = 1
        npNumber.maxValue = num.size
        npNumber.displayedValues = num
        npNumber.value = 3

        var value = num[1]
    }

   private fun pressBlackButton() {

       tv_button_black.setOnClickListener {
           tv_button_black.isSelected = true
           tv_button_red.isSelected = false
       }
    }
    private fun pressRedButton() {
        tv_button_red.setOnClickListener {
            tv_button_black.isSelected = false
            tv_button_red.isSelected = true
        }
    }


    private fun updateUI() {
        var backState = PreferenceProvider.getBackgroundStateSetting()
        when(backState){
            PreferenceProvider.BACKGROUND_BLUE -> {
                iv_background_game.setImageResource(R.drawable.gradient_splash_blue)
            }
            PreferenceProvider.BACKGROUND_GREEN -> {
                iv_background_game.setImageResource(R.drawable.gradient_splash)
            }
            PreferenceProvider.BACKGROUND_RED -> {
                iv_background_game.setImageResource(R.drawable.gradient_splash_red)
            }
        }
    }
}