package edu.uw.quizdroid

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class PhysicsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_physics)
        val btnBeginPhys = findViewById<Button>(R.id.beginPhys)
        btnBeginPhys.setOnClickListener {
            val intent = Intent(this, PhysicsQuestionOne::class.java)
            startActivity(intent)
        }


    }
}