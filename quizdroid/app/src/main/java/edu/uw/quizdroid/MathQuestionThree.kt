package edu.uw.quizdroid

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup

class MathQuestionThree : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_math_question_three)

        val options = findViewById<RadioGroup>(R.id.mathQuestionThreeRadioOptions)
        val btnSubmit = findViewById<Button>(R.id.btnsubmitMathQuestionThree)
        //submit button toggle
        options.setOnCheckedChangeListener({ radioGroup, i ->
            btnSubmit.setEnabled(true)
        })

        btnSubmit.setOnClickListener {
            val intent = Intent(this, MathAnswerThree::class.java)
            val user = findViewById<RadioButton>(options.checkedRadioButtonId).text.toString()
            val answer = findViewById<RadioButton>(R.id.mathQuestionThreeCorrect).text.toString()
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