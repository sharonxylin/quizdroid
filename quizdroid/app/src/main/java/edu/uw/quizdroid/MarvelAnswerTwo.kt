package edu.uw.quizdroid

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MarvelAnswerTwo : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_marvel_answer_two)
        val intent = getIntent()
        val marvTwoUser = findViewById<TextView>(R.id.marvTwoUser)
        val marvTwoAnswer = findViewById<TextView>(R.id.marvTwoAnswer)
        val marvTwoSummary = findViewById<TextView>(R.id.marvTwoSummary)
        val btnMarvTwoNext = findViewById<Button>(R.id.marvTwoNext)

        //update Text Views
        marvTwoUser.text = "Your Answer: " + intent.getStringExtra("USER")
        marvTwoAnswer.text = "Correct Answer: "+ intent.getStringExtra("ANSWER")
        marvTwoSummary.text = "You have " + intent.getIntExtra("CORRECT_COUNT", -1) + " out of 2 correct"

        btnMarvTwoNext.setOnClickListener{
            val nextIntent = Intent(this, MarvelQuestionThree::class.java)
            nextIntent.putExtra("CORRECT_COUNT", intent.getIntExtra("CORRECT_COUNT", -1))
            startActivity(nextIntent)
        }
    }
}