package edu.uw.quizdroid

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MarvelActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_marvel)
        val btnBeginMarv = findViewById<Button>(R.id.beginMarv)
        btnBeginMarv.setOnClickListener {
            val intent = Intent(this, MarvelQuestionOne::class.java)
            startActivity(intent)
        }
    }
}