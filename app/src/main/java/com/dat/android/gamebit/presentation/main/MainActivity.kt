package com.dat.android.gamebit.presentation.main

import android.animation.Animator
import android.animation.ValueAnimator
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.dat.android.gamebit.PreferenceProvider
import com.dat.android.gamebit.R
import com.dat.android.gamebit.presentation.highscore.HighscoresActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.random.Random

class MainActivity : AppCompatActivity(R.layout.activity_main) {


    var hash = hashMapOf<Int, Float>(
        Pair(32, -1f),
        Pair(15, -20f),
        Pair(19, -30f),
        Pair(4, -40f),
        Pair(21, -50f),
        Pair(2, -60f),
        Pair(25, -66f),
        Pair(17, -76f),
        Pair(34, -86f),
        Pair(6, -96f),
        Pair(27, -106f),
        Pair(13, -114f),
        Pair(36, -124f),
        Pair(11, -134f),
        Pair(30, -144f),
        Pair(8, -154f),
        Pair(23, -161f),
        Pair(10, -171f),
        Pair(5, -181f),
        Pair(24, -191f),
        Pair(16, -201f),
        Pair(33, -210f),
        Pair(1, -220f),
        Pair(20, -230f),
        Pair(14, -237f),
        Pair(31, -247f),
        Pair(9, -257f),
        Pair(22, -267f),
        Pair(18, -277f),
        Pair(29, -284f),
        Pair(7, -294f),
        Pair(28, -303f),
        Pair(12, -313f),
        Pair(35, -323f),
        Pair(3, -333f),
        Pair(26, -341f),
        Pair(36, -351f)
    )


    var redList = hashSetOf(32, 19, 21, 25, 34, 27, 36, 30, 23, 5, 16, 1, 14, 9, 18, 7, 12, 3)

    var blackList = hashSetOf(15, 4, 2, 17, 6, 13, 11, 8, 10, 24, 33, 20, 31, 22, 29, 28, 35, 26)

    val num =
        arrayOf(
            "1", "2", "3", "4", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15",
            "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29",
            "30", "31", "32", "33", "34", "35", "36", "0"
        )

    val data =
        arrayOf("$50", "$100", "$200", "$300", "$400", "$500", "$1000", "$1500", "$2000")

    val RED = 0
    val BLACK = 1
    val GREEN = 2

    var currentRouletValue = -1
    var currentRouletColor = -1

    var userValue = -1
    var userColor = -1


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        updateUI()
        bindSpinners()
        bindSpinnersNumbers()
        iv_show_highscoresActivity.setOnClickListener {
            var intentHigh = Intent(this@MainActivity, HighscoresActivity::class.java)
            startActivity(intentHigh)
        }


        tv_button_play.setOnClickListener {
            rullAnimation()
        }


        /*tv_button_play.setOnClickListener {
            var dialogDefeat = FragmentDialogDefeat()
            dialogDefeat.show(supportFragmentManager, "customDialog")
        }*/ // диалог


    }

    private fun rullAnimation() {
        var amountFullRotation = Random.nextInt(6, 10)

        currentRouletValue = Random.nextInt(0, 37)
        currentRouletColor = getCurrentColor(currentRouletValue)

        var roulleteValueDegree = hash[currentRouletValue]
        var fullDegree = amountFullRotation * 360 + roulleteValueDegree!!

        userValue = num[npNumber.value - 1].toInt()
        userColor = getCurrentColor(userValue)


        var animator = ValueAnimator.ofFloat(0f, fullDegree)
        animator.duration = 5_000L

        animator.addUpdateListener {
            ivRoulete.rotation = it.animatedValue.toString().toFloat()
        }

        animator.addListener(object : Animator.AnimatorListener {
            override fun onAnimationRepeat(p0: Animator?) {
            }

            override fun onAnimationEnd(p0: Animator?) {
                animator.removeAllListeners()
                makeResults()
            }

            override fun onAnimationCancel(p0: Animator?) {
            }

            override fun onAnimationStart(p0: Animator?) {
            }
        })

        animator.start()

    }

    private fun makeResults() {
        if (userValue == 0) {
            if (currentRouletValue == userValue){
                Toast.makeText(this, "X5", Toast.LENGTH_LONG).show()
            }else{
                Toast.makeText(this, "lost bet", Toast.LENGTH_LONG).show()
            }
        } else {
            when {
                currentRouletValue == userValue -> {
                    Toast.makeText(this, "X3", Toast.LENGTH_LONG).show()
                }
                currentRouletColor == userColor -> {
                    Toast.makeText(this, "X2", Toast.LENGTH_LONG).show()
                }
                else -> {
                    Toast.makeText(this, "lost bet", Toast.LENGTH_LONG).show()
                }
            }
        }
    }

    private fun getCurrentColor(value: Int): Int {
        return when {
            redList.contains(value) -> {
                RED
            }
            blackList.contains(value) -> {
                BLACK
            }
            else -> {
                GREEN
            }
        }
    }

    private fun bindSpinners() {

        npBet.minValue = 1
        npBet.maxValue = data.size
        npBet.displayedValues = data
        npBet.value = 3
        /// "kek,lol,kek,kek" -- split --> array("kek", "lol", "kek", "kek") --> array[1] == "lol"
        /// "$50" -- split("$") --- array( "", "50") --- array[1].toInt

        var value = data[0].split("$")[1].toInt()
    }

    private fun bindSpinnersNumbers() {
        npNumber.minValue = 1
        npNumber.maxValue = num.size
        npNumber.displayedValues = num
        npNumber.value = 3

        npNumber.setOnValueChangedListener { _, _, newVal ->
            Log.e("LOL", "$newVal")
            when(getCurrentColor(num[newVal - 1].toInt())){
                RED -> {
                    tv_button_red.isSelected = true
                    tv_button_black.isSelected = false
                }
                BLACK -> {
                    tv_button_red.isSelected = false
                    tv_button_black.isSelected = true
                }
                else -> {
                    tv_button_red.isSelected = false
                    tv_button_black.isSelected = false
                }
            }
        }
    }




    private fun updateUI() {
        var backState = PreferenceProvider.getBackgroundStateSetting()
        when (backState) {
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
        tv_button_red.isSelected = true
    }
}