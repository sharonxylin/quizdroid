package edu.uw.quizdroid

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class SeattleAnswerTwo : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_seattle_answer_two)

        val intent = getIntent()
        val seaTwoUser = findViewById<TextView>(R.id.seaTwoUser)
        val seaTwoAnswer = findViewById<TextView>(R.id.seaTwoAnswer)
        val seaTwoSummary = findViewById<TextView>(R.id.seaTwoSummary)
        val btnSeaTwoNext = findViewById<Button>(R.id.seaTwoNext)

        //update Text Views
        seaTwoUser.text = "Your Answer: " + intent.getStringExtra("USER")
        seaTwoAnswer.text = "Correct Answer: "+ intent.getStringExtra("ANSWER")
        seaTwoSummary.text = "You have " + intent.getIntExtra("CORRECT_COUNT", -1) + " out of 2 correct"

        btnSeaTwoNext.setOnClickListener{
            val nextIntent = Intent(this, SeattleQuestionThree::class.java)
            nextIntent.putExtra("CORRECT_COUNT", intent.getIntExtra("CORRECT_COUNT", -1))
            startActivity(nextIntent)
        }
    }
}