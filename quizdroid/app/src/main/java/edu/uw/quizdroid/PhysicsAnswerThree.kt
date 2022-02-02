package edu.uw.quizdroid

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class PhysicsAnswerThree : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_physics_answer_three)

        val intent = getIntent()
        val physThreeUser = findViewById<TextView>(R.id.physThreeUser)
        val physThreeAnswer = findViewById<TextView>(R.id.physThreeAnswer)
        val physThreeSummary = findViewById<TextView>(R.id.physThreeSummary)
        val btnPhysFinish = findViewById<Button>(R.id.btnPhysFinish)

        //update Text Views
        physThreeUser.text = "Your Answer: " + intent.getStringExtra("USER")
        physThreeAnswer.text = "Correct Answer: "+ intent.getStringExtra("ANSWER")
        physThreeSummary.text = "You have " + intent.getIntExtra("CORRECT_COUNT", -1) + " out of 3 correct"

        btnPhysFinish.setOnClickListener{
            val nextIntent = Intent(this, MainActivity::class.java)
            startActivity(nextIntent)
        }

    }
}