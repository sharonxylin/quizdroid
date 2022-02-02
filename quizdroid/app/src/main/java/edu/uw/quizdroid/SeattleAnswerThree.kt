package edu.uw.quizdroid

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class SeattleAnswerThree : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_seattle_answer_three)

        val intent = getIntent()
        val seaThreeUser = findViewById<TextView>(R.id.seaThreeUser)
        val seaThreeAnswer = findViewById<TextView>(R.id.seaThreeAnswer)
        val seaThreeSummary = findViewById<TextView>(R.id.seaThreeSummary)
        val btnSeaFinish = findViewById<Button>(R.id.btnSeaFinish)

        //update Text Views
        seaThreeUser.text = "Your Answer: " + intent.getStringExtra("USER")
        seaThreeAnswer.text = "Correct Answer: "+ intent.getStringExtra("ANSWER")
        seaThreeSummary.text = "You have " + intent.getIntExtra("CORRECT_COUNT", -1) + " out of 3 correct"

        btnSeaFinish.setOnClickListener{
            val nextIntent = Intent(this, MainActivity::class.java)
            startActivity(nextIntent)
        }
    }
}