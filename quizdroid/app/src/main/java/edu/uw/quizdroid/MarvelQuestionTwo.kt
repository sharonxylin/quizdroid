package edu.uw.quizdroid

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup

class MarvelQuestionTwo : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_marvel_question_two)

        val options = findViewById<RadioGroup>(R.id.marvQuestionTwoRadioOptions)
        val btnSubmit = findViewById<Button>(R.id.btnsubmitMarvQuestionTwo)
        //submit button toggle
        options.setOnCheckedChangeListener({ radioGroup, i ->
            btnSubmit.setEnabled(true)
        })

        btnSubmit.setOnClickListener {
            val intent = Intent(this, MarvelAnswerTwo::class.java)
            val user = findViewById<RadioButton>(options.checkedRadioButtonId).text.toString()
            val answer = findViewById<RadioButton>(R.id.marvQuestionTwoCorrect).text.toString()
            var correctCount = getIntent().getIntExtra("CORRECT_COUNT", -1)
            if (user == answer) {
                correctCount++
            }
            intent.putExtra("USER", user)
            intent.putExtra("ANSWER", answer)
            intent.putExtra("CORRECT_COUNT", correctCount)
            startActivity(intent)
        }
    }
}