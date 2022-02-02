package edu.uw.quizdroid

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class PhysicsAnswerOne : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_physics_answer_one)
        val intent = getIntent()
        val physOneUser = findViewById<TextView>(R.id.physOneUser)
        val physOneAnswer = findViewById<TextView>(R.id.physOneAnswer)
        val physOneSummary = findViewById<TextView>(R.id.physOneSummary)
        val btnPhysOneNext = findViewById<Button>(R.id.physOneNext)

        //update TextViews
        physOneUser.text = "Your Answer: " + intent.getStringExtra("USER")
        physOneAnswer.text = "Correct Answer: "+ intent.getStringExtra("ANSWER")
        physOneSummary.text = "You have " + intent.getIntExtra("CORRECT_COUNT", -1) + " out of 1 correct"

        btnPhysOneNext.setOnClickListener{
            val nextIntent = Intent(this, PhysicsQuestionTwo::class.java)
            nextIntent.putExtra("CORRECT_COUNT", intent.getIntExtra("CORRECT_COUNT", -1))
            startActivity(nextIntent)
        }
    }
}