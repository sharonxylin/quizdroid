package edu.uw.quizdroid

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btnMath = findViewById<Button>(R.id.btnMath)
        val btnSea = findViewById<Button>(R.id.btnSea)
        val btnPhys = findViewById<Button>(R.id.btnPhys)
        val btnMarv = findViewById<Button>(R.id.btnMarv)

        btnMath.setOnClickListener {
            val intent = Intent(this,MathActivity::class.java)
            startActivity(intent)
        }
        btnSea.setOnClickListener {
            val intent = Intent(this,SeattleActivity::class.java)
            startActivity(intent)
        }
        btnPhys.setOnClickListener {
            val intent = Intent(this,PhysicsActivity::class.java)
            startActivity(intent)
        }
        btnMarv.setOnClickListener {
            val intent = Intent(this,MarvelActivity::class.java)
            startActivity(intent)
        }
    }
}