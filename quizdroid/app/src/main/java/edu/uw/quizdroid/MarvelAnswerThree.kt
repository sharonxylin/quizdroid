package edu.uw.quizdroid

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MarvelAnswerThree : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_marvel_answer_three)

        val intent = getIntent()
        val marvThreeUser = findViewById<TextView>(R.id.marvThreeUser)
        val marvThreeAnswer = findViewById<TextView>(R.id.marvThreeAnswer)
        val marvThreeSummary = findViewById<TextView>(R.id.marvThreeSummary)
        val btnMarvFinish = findViewById<Button>(R.id.btnMarvFinish)

        //update Text Views
        marvThreeUser.text = "Your Answer: " + intent.getStringExtra("USER")
        marvThreeAnswer.text = "Correct Answer: "+ intent.getStringExtra("ANSWER")
        marvThreeSummary.text = "You have " + intent.getIntExtra("CORRECT_COUNT", -1) + " out of 3 correct"

        btnMarvFinish.setOnClickListener{
            val nextIntent = Intent(this, MainActivity::class.java)
            startActivity(nextIntent)
        }
    }
}