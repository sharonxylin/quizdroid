package edu.uw.quizdroid

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button

class MainActivity : AppCompatActivity() {

    fun topicBlurb(s1: String, s2: String): String{
        return s1 + "- " + s2
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val app = this.application as QuizApp
        val prefs: SharedPreferences = getSharedPreferences("settings", MODE_PRIVATE)
        //
        if(prefs.contains("application.firstRun")){

        }else{
            val intent = Intent(this, Preferences::class.java)
            startActivity(intent)
        }


        // val pref: SharedPreferences = getSharedPreferences("url", MODE_PRIVATE)
        // val pref = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE).edit()
        // val pref: SharedPreferences = getSharedPreferences("settings", MODE_PRIVATE)
        // val editor = pref.edit()
        /*
        editor.putString("name", "Elena")
        editor.putInt("idName", 12)
        editor.commit()*/



        app.restart()



        val btn0 = findViewById<Button>(R.id.btn0)
        val btn1 = findViewById<Button>(R.id.btn1)
        val btn2 = findViewById<Button>(R.id.btn2)
        val btn3 = findViewById<Button>(R.id.btn3)


        btn0.setText(topicBlurb(app.getTitle(0), app.getShortDescr(0)))
        btn1.setText(topicBlurb(app.getTitle(1), app.getShortDescr(1)))
        btn2.setText(topicBlurb(app.getTitle(2), app.getShortDescr(2)))
        btn3.setText(topicBlurb(app.getTitle(3), app.getShortDescr(3)))

        btn0.setOnClickListener {
            val intent = Intent(this, TopicOverviewActivity:: class.java)
            intent.putExtra("INDEX", 0)
            startActivity(intent)
        }
        btn1.setOnClickListener {
            val intent = Intent(this, TopicOverviewActivity:: class.java)
            intent.putExtra("INDEX", 1)
            startActivity(intent)
        }
        btn2.setOnClickListener {
            val intent = Intent(this, TopicOverviewActivity:: class.java)
            intent.putExtra("INDEX", 2)
            startActivity(intent)
        }
        btn3.setOnClickListener {
            val intent = Intent(this, TopicOverviewActivity:: class.java)
            intent.putExtra("INDEX", 3)
            startActivity(intent)
        }
    }

}