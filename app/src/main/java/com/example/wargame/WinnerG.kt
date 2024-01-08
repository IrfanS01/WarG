package com.example.wargame

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class WinnerG : AppCompatActivity() {

    lateinit var resultView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_winner_g)

        val winnerTextView = findViewById<TextView>(R.id.resultView)
        val pobjednik = intent.getStringExtra("pobjednik")
        winnerTextView.text="winner is : $pobjednik"


        resultView=findViewById(R.id.resultView)

        val button = findViewById<Button>(R.id.backButton)

        button.setOnClickListener {

            onDestroy()
        }

    }
}