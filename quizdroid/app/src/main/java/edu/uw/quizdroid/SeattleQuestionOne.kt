package edu.uw.quizdroid

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup

class SeattleQuestionOne : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_seattle_question_one)
        val options = findViewById<RadioGroup>(R.id.seaQuestionOneRadioOptions)
        val btnSubmit = findViewById<Button>(R.id.btnsubmitSeaQuestionOne)
        //submit button toggle
        options.setOnCheckedChangeListener({radioGroup, i ->
            btnSubmit.setEnabled(true)
        })

        btnSubmit.setOnClickListener{
            val intent = Intent(this, SeattleAnswerOne::class.java)
            val user = findViewById<RadioButton>(options.checkedRadioButtonId).text.toString()
            val answer = findViewById<RadioButton>(R.id.seaQuestionOneCorrect).text.toString()
            var correctCount = 0
            if(user==answer){
                correctCount++
            }
            intent.putExtra("USER", user)
            intent.putExtra("ANSWER", answer)
            intent.putExtra("CORRECT_COUNT", correctCount)
            startActivity(intent)
        }
    }
}