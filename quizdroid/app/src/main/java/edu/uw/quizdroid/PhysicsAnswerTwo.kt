package edu.uw.quizdroid

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class PhysicsAnswerTwo : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_physics_answer_two)
        val intent = getIntent()
        val physTwoUser = findViewById<TextView>(R.id.physTwoUser)
        val physTwoAnswer = findViewById<TextView>(R.id.physTwoAnswer)
        val physTwoSummary = findViewById<TextView>(R.id.physTwoSummary)
        val btnPhysTwoNext = findViewById<Button>(R.id.physTwoNext)

        //update Text Views
        physTwoUser.text = "Your Answer: " + intent.getStringExtra("USER")
        physTwoAnswer.text = "Correct Answer: "+ intent.getStringExtra("ANSWER")
        physTwoSummary.text = "You have " + intent.getIntExtra("CORRECT_COUNT", -1) + " out of 2 correct"

        btnPhysTwoNext.setOnClickListener{
            val nextIntent = Intent(this, PhysQuestionThree::class.java)
            nextIntent.putExtra("CORRECT_COUNT", intent.getIntExtra("CORRECT_COUNT", -1))
            startActivity(nextIntent)
        }
    }
}