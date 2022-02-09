package edu.uw.quizdroid

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class Answer : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_answer)

        val app = this.application as QuizApp
        val intent = getIntent()
        var index = intent.getIntExtra("INDEX", -1)
        var curr = app.getCurr()
        var correct = app.getCorrect()

        val answer = findViewById<TextView>(R.id.answer)
        val answerUser = findViewById<TextView>(R.id.answerUser)
        val answerCorrect = findViewById<TextView>(R.id.answerCorrect)
        val answerSummary = findViewById<TextView>(R.id.answerSummary)
        val btnNext = findViewById<Button>(R.id.answerNext)

        //set texts
        answer.setText(app.getTitle(index) + ": " + "Question " + (curr) + " Answer")
        answerUser.setText("Your Answer: " + intent.getStringExtra("USER"))
        answerCorrect.setText("Correct Answer: "+ intent.getStringExtra("CORRECT"))
        answerSummary.setText("You have " + correct + " out of " + curr + " correct")
        if(curr != 3){
            btnNext.setText("Next")
            btnNext.setOnClickListener{
                val nextIntent = Intent(this, Question:: class.java)
                nextIntent.putExtra("INDEX", index)
                startActivity(nextIntent)
            }
        //if last question
        }else{
            btnNext.setText("Finish")
            btnNext.setOnClickListener{
                val nextIntent = Intent(this, MainActivity:: class.java)
                nextIntent.putExtra("INDEX", index)
                startActivity(nextIntent)
            }

        }



        /*
        *
        *

        btnMarvOneNext.setOnClickListener{
            val nextIntent = Intent(this, MarvelQuestionTwo::class.java)
            nextIntent.putExtra("CORRECT_COUNT", intent.getIntExtra("CORRECT_COUNT", -1))
            startActivity(nextIntent)
        }
        * */
    }
}