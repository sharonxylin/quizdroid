package edu.uw.quizdroid

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class SeattleActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_seattle)
        val btnBeginSea = findViewById<Button>(R.id.beginSea)
        btnBeginSea.setOnClickListener {
            val intent = Intent(this, SeattleQuestionOne::class.java)
            startActivity(intent)
        }
    }
}