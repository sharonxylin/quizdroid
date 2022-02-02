package edu.uw.quizdroid

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.RadioGroup
import android.widget.TextView

class MathAnswerOne : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_math_answer_one)
        val intent = getIntent()
        val mathOneUser = findViewById<TextView>(R.id.mathOneUser)
        val mathOneAnswer = findViewById<TextView>(R.id.mathOneAnswer)
        val mathOneSummary = findViewById<TextView>(R.id.mathOneSummary)
        val btnMathOneNext = findViewById<Button>(R.id.mathOneNext)

        //update TextViews
        mathOneUser.text = "Your Answer: " + intent.getStringExtra("USER")
        mathOneAnswer.text = "Correct Answer: "+ intent.getStringExtra("ANSWER")
        mathOneSummary.text = "You have " + intent.getIntExtra("CORRECT_COUNT", -1) + " out of 1 correct"

        btnMathOneNext.setOnClickListener{
            val nextIntent = Intent(this, MathQuestionTwo::class.java)
            nextIntent.putExtra("CORRECT_COUNT", intent.getIntExtra("CORRECT_COUNT", -1))
            startActivity(nextIntent)
        }
    }

}