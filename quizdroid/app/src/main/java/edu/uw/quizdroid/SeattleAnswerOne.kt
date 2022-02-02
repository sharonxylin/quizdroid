package edu.uw.quizdroid

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class SeattleAnswerOne : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_seattle_answer_one)


        val intent = getIntent()
        val seaOneUser = findViewById<TextView>(R.id.seaOneUser)
        val seaOneAnswer = findViewById<TextView>(R.id.seaOneAnswer)
        val seaOneSummary = findViewById<TextView>(R.id.seaOneSummary)
        val btnSeaOneNext = findViewById<Button>(R.id.seaOneNext)

        //update TextViews
        seaOneUser.text = "Your Answer: " + intent.getStringExtra("USER")
        seaOneAnswer.text = "Correct Answer: "+ intent.getStringExtra("ANSWER")
        seaOneSummary.text = "You have " + intent.getIntExtra("CORRECT_COUNT", -1) + " out of 1 correct"

        btnSeaOneNext.setOnClickListener{
            val nextIntent = Intent(this, SeattleQuestionTwo::class.java)
            nextIntent.putExtra("CORRECT_COUNT", intent.getIntExtra("CORRECT_COUNT", -1))
            startActivity(nextIntent)
        }
    }
}