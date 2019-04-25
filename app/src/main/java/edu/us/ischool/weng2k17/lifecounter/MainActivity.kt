package edu.us.ischool.weng2k17.lifecounter

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

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

        assignButtonBehavior(lifeTotals , minusButtons, plusButtons)

    }

    fun assignButtonBehavior(lifeTotals: ArrayList<TextView>, minusButtons: ArrayList<Button>, plusButtons: ArrayList<Button>) {
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
                    Toast.makeText(this, "Player " + i + " LOSES!", Toast.LENGTH_LONG).show()
                }
            }
        }
    }
}
