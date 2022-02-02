package edu.uw.quizdroid

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MathAnswerTwo : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_math_answer_two)
        val intent = getIntent()
        val mathTwoUser = findViewById<TextView>(R.id.mathTwoUser)
        val mathTwoAnswer = findViewById<TextView>(R.id.mathTwoAnswer)
        val mathTwoSummary = findViewById<TextView>(R.id.mathTwoSummary)
        val btnMathTwoNext = findViewById<Button>(R.id.mathTwoNext)

        //update Text Views
        mathTwoUser.text = "Your Answer: " + intent.getStringExtra("USER")
        mathTwoAnswer.text = "Correct Answer: "+ intent.getStringExtra("ANSWER")
        mathTwoSummary.text = "You have " + intent.getIntExtra("CORRECT_COUNT", -1) + " out of 2 correct"

        btnMathTwoNext.setOnClickListener{
            val nextIntent = Intent(this, MathQuestionThree::class.java)
            nextIntent.putExtra("CORRECT_COUNT", intent.getIntExtra("CORRECT_COUNT", -1))
            startActivity(nextIntent)
        }
    }
}