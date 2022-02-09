package edu.uw.quizdroid

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView

class TopicOverviewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_topic_overview)

        val app = this.application as QuizApp
        var topicOverviewTitle = findViewById<TextView>(R.id.topicOverviewTitle)
        var topicOverviewLongDescr = findViewById<TextView>(R.id.topicOverviewLongDescr)
        var intent = getIntent()
        var index = intent.getIntExtra("INDEX", -1)

        topicOverviewTitle.setText(app.getTitle(index))
        topicOverviewLongDescr.setText(app.getLongDescr(index))

        var btnBeginQuiz = findViewById<Button>(R.id.beginQuiz)
        btnBeginQuiz.setOnClickListener{
            var intent = Intent(this, Question::class.java)
            intent.putExtra("INDEX", index)
            startActivity(intent)
        }





        /*
        val btnBeginMarv = findViewById<Button>(R.id.beginMarv)
        btnBeginMarv.setOnClickListener {
            val intent = Intent(this, MarvelQuestionOne::class.java)
            startActivity(intent)
        }*/
    }
}