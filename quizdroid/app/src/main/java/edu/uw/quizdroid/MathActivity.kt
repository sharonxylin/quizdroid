package edu.uw.quizdroid

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MathActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_math)
        val btnBeginMath = findViewById<Button>(R.id.beginMath)
        btnBeginMath.setOnClickListener {
            val intent = Intent(this, MathQuestionOne::class.java)
            startActivity(intent)
        }
    }
}