package edu.uw.quizdroid

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import java.time.Instant

class Preferences : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_preferences)
        val editor = getSharedPreferences("settings", MODE_PRIVATE).edit()
        val prefURL = findViewById<EditText>(R.id.prefURL)
        val prefMinutes = findViewById<EditText>(R.id.prefMinutes)
        val btnSubmitPreference = findViewById<Button>(R.id.btnSubmitPreference)
        btnSubmitPreference.setOnClickListener {
            editor.putString("prefURL", prefURL.text.toString())
            editor.putInt("prefMinutes", Integer.parseInt(prefMinutes.getText().toString()))
            editor.putString("application.firstRun", Instant.now().toString())
            editor.commit()
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        }
    }
}