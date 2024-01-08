package com.example.wargame
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlin.random.Random

class MainActivity : AppCompatActivity() {


    lateinit var card1: ImageView
    lateinit var card2: ImageView

    lateinit var n_player1: TextView
    lateinit var n_player2: TextView

    lateinit var n_war: TextView

    lateinit var n_deal: Button

    lateinit var random: Random

    var player1 = 0
    var player2 = 0

    var brojPoenaIgrac1 = 0
    var brojPoenaIgrac2 = 0

    var cardsArray = intArrayOf(
        R.drawable.hearts2,
        R.drawable.hearts3,
        R.drawable.hearts4,
        R.drawable.hearts5,
        R.drawable.hearts6,
        R.drawable.hearts7,
        R.drawable.hearts8,
        R.drawable.hearts9,
        R.drawable.hearts10,
        R.drawable.hearts12,
        R.drawable.hearts13,
        R.drawable.hearts14,
        R.drawable.hearts15
    )


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        random = Random

        //init objects
        card1 = findViewById(R.id.iv_card1)
        card2 = findViewById(R.id.iv_card2)

        card1.setImageResource(R.drawable.card_back)
        card2.setImageResource(R.drawable.card_back)

        n_player1 = findViewById(R.id.tv_player1)
        n_player2 = findViewById(R.id.tv_player2)

        n_war = findViewById(R.id.tv_war)
        n_war.visibility = View.INVISIBLE

        n_deal = findViewById(R.id.b_deal)
        n_deal.setOnClickListener {
            //hide war label
            n_war.visibility = View.INVISIBLE

            //generate cards
            val card1 = random.nextInt(cardsArray.size)
            val card2 = random.nextInt(cardsArray.size)

            //set images
            setCardImage(card1, this.card1)
            setCardImage(card2, this.card2)

            //compare teh cards
            if (card1 > card2) {
                player1++
                n_player1.text = "Player 1: $player1"
            } else if (card1 < card2) {
                player2++
                n_player2.text = "Player 2: $player2"
            } else {
                //show war label
                n_war.visibility = View.VISIBLE
            }





            if (player1 >= 15) {
                val intent = Intent(this, WinnerG::class.java)
                intent.putExtra("pobjednik", "Igrač 1")
                startActivity(intent)
            } else if (player2 >= 15) {
                val intent = Intent(this, WinnerG::class.java)
                intent.putExtra("pobjednik", "Igrač 2")
                startActivity(intent)
            }

        }


    }


    private fun setCardImage(number: Int, image: ImageView) {
        image.setImageResource(cardsArray[number])
    }


}
