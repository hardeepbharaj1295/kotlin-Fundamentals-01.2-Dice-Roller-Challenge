package com.daemonvision.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button: Button = findViewById(R.id.roll_button)
        val countUp: Button = findViewById(R.id.count_up)
        val reset: Button = findViewById(R.id.reset)
        val resultText: TextView = findViewById(R.id.result_text)

        button.setOnClickListener {
            rollDice()
        }

        countUp.setOnClickListener {
            val result = resultText.text.toString()
            if (result == resources.getString(R.string.dice_role))
            {
                result_text.text = "1"
            }
            else if (result != "6")
            {
                val data = resultText.text.toString().toInt() + 1
                result_text.text = data.toString()
            }
        }

        reset.setOnClickListener {
            result_text.text = "0"
        }
    }

    private fun rollDice()
    {
        val randomInt = Random().nextInt(6) + 1
        result_text.text = randomInt.toString()
        Toast.makeText(this,"Button Clicked",Toast.LENGTH_SHORT).show()
    }

}
