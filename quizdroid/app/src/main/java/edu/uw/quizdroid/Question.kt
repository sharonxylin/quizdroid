package edu.uw.quizdroid

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView

class Question : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_question)

        val question = findViewById<TextView>(R.id.question)
        val a0 = findViewById<RadioButton>(R.id.a0)
        val a1 = findViewById<RadioButton>(R.id.a1)
        val a2 = findViewById<RadioButton>(R.id.a2)
        val a3 = findViewById<RadioButton>(R.id.a3)
        val options = findViewById<RadioGroup>(R.id.questionRadioOptions)
        val btnSubmit = findViewById<Button>(R.id.btnsubmitResponse)

        var intent = getIntent()
        val app = this.application as QuizApp
        var curr = app.getCurr()
        var index = intent.getIntExtra("INDEX", -1)

        //set texts
        question.setText(app.getTitle(index) + " Question " + (curr+1) + ": " + app.getCurrQuestion(index, curr))
        a0.setText(app.getAnswer(index, curr, 0))
        a1.setText(app.getAnswer(index, curr, 1))
        a2.setText(app.getAnswer(index, curr, 2))
        a3.setText(app.getAnswer(index, curr, 3))

        //submit button toggle
        options.setOnCheckedChangeListener({radioGroup, i ->
            btnSubmit.setEnabled(true)
        })

        btnSubmit.setOnClickListener{
            val nextIntent = Intent(this, Answer::class.java)
            val user = findViewById<RadioButton>(options.checkedRadioButtonId).text.toString()
            val correct = app.getCorrectAnswer(index, curr)
            if(user==correct){
                app.correctIncrement()
            }
            app.currIncrement()
            nextIntent.putExtra("INDEX", index)
            nextIntent.putExtra("USER", user)
            nextIntent.putExtra("CORRECT", correct)
            startActivity(nextIntent)
        }

    }
}