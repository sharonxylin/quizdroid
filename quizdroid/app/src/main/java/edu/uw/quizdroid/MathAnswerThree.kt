package edu.uw.quizdroid

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MathAnswerThree : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_math_answer_three)

        val intent = getIntent()
        val mathThreeUser = findViewById<TextView>(R.id.mathThreeUser)
        val mathThreeAnswer = findViewById<TextView>(R.id.mathThreeAnswer)
        val mathThreeSummary = findViewById<TextView>(R.id.mathThreeSummary)
        val btnMathFinish = findViewById<Button>(R.id.btnMathFinish)

        //update Text Views
        mathThreeUser.text = "Your Answer: " + intent.getStringExtra("USER")
        mathThreeAnswer.text = "Correct Answer: "+ intent.getStringExtra("ANSWER")
        mathThreeSummary.text = "You have " + intent.getIntExtra("CORRECT_COUNT", -1) + " out of 3 correct"

        btnMathFinish.setOnClickListener{
            val nextIntent = Intent(this, MainActivity::class.java)
            startActivity(nextIntent)
        }
    }
}