package edu.us.ischool.weng2k17.lifecounter

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var plusButtons = ArrayList<Button>()
        plusButtons.add(findViewById<Button>(R.id.p1_button_plus))
        plusButtons.add(findViewById(R.id.p2_button_plus))
        plusButtons.add((findViewById(R.id.p3_button_plus)))
        plusButtons.add((findViewById(R.id.p4_button_plus)))

        var minusButtons = ArrayList<Button>()
        minusButtons.add(findViewById(R.id.p1_button_minus))
        minusButtons.add(findViewById(R.id.p2_button_minus))
        minusButtons.add(findViewById(R.id.p3_button_minus))
        minusButtons.add(findViewById(R.id.p4_button_minus))

        var lifeTotals = ArrayList<TextView>()
        lifeTotals.add(findViewById(R.id.p1_life_total))
        lifeTotals.add(findViewById(R.id.p2_life_total))
        lifeTotals.add(findViewById(R.id.p3_life_total))
        lifeTotals.add(findViewById(R.id.p4_life_total))

        var plus5Buttons = ArrayList<Button>()
        plus5Buttons.add(findViewById(R.id.plus5_player1))
        plus5Buttons.add(findViewById(R.id.plus5_player2))
        plus5Buttons.add(findViewById(R.id.plus5_player3))
        plus5Buttons.add(findViewById(R.id.plus5_player4))

        var minus5Buttons = ArrayList<Button>()
        minus5Buttons.add(findViewById(R.id.minus5_player1))
        minus5Buttons.add(findViewById(R.id.minus5_player2))
        minus5Buttons.add(findViewById(R.id.minus5_player3))
        minus5Buttons.add(findViewById(R.id.minus5_player4))

        assignButtonBehavior(lifeTotals , minusButtons, plusButtons, plus5Buttons, minus5Buttons)

    }

    fun assignButtonBehavior(lifeTotals: ArrayList<TextView>, minusButtons: ArrayList<Button>,
                             plusButtons: ArrayList<Button>, plus5Buttons: ArrayList<Button>,
                             minus5Buttons: ArrayList<Button>) {
        for (i in 0..3) {
            val length = lifeTotals[i].text.length
            var count = lifeTotals[i].text.substring(length - 1, length).toInt()
            plusButtons[i].setOnClickListener {
                count++
                lifeTotals[i].setText("Life Total: " + count)
            }

            minusButtons[i].setOnClickListener {
                count--
                lifeTotals[i].setText("Life Total: " + count)
                if (count == 0) {
                    val losingPlayer = findViewById<TextView>(R.id.losing_player)
                    losingPlayer.setText("Player " + (i + 1) + " LOST!")
                }
            }

            plus5Buttons[i].setOnClickListener {
                count+=5
                lifeTotals[i].setText("Life Total: " + count)
            }

            minus5Buttons[i].setOnClickListener {
                count-=5
                lifeTotals[i].setText("Life Total: " + count)
                if (count == 0) {
                    val losingPlayer = findViewById<TextView>(R.id.losing_player)
                    losingPlayer.setText("Player " + (i + 1) + " LOST!")
                }
            }
        }
    }
}
