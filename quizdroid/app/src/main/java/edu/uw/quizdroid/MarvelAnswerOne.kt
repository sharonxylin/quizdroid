package edu.uw.quizdroid

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MarvelAnswerOne : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_marvel_answer_one)
        val intent = getIntent()
        val marvOneUser = findViewById<TextView>(R.id.marvOneUser)
        val marvOneAnswer = findViewById<TextView>(R.id.marvOneAnswer)
        val marvOneSummary = findViewById<TextView>(R.id.marvOneSummary)
        val btnMarvOneNext = findViewById<Button>(R.id.marvOneNext)

        //update TextViews
        marvOneUser.text = "Your Answer: " + intent.getStringExtra("USER")
        marvOneAnswer.text = "Correct Answer: "+ intent.getStringExtra("ANSWER")
        marvOneSummary.text = "You have " + intent.getIntExtra("CORRECT_COUNT", -1) + " out of 1 correct"

        btnMarvOneNext.setOnClickListener{
            val nextIntent = Intent(this, MarvelQuestionTwo::class.java)
            nextIntent.putExtra("CORRECT_COUNT", intent.getIntExtra("CORRECT_COUNT", -1))
            startActivity(nextIntent)
        }
    }
}