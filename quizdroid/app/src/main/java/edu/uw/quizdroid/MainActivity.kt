package edu.uw.quizdroid

import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.content.SharedPreferences
import android.net.ConnectivityManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.provider.Settings
import android.util.Log
import android.widget.Button
import android.widget.Toast
import java.io.*
import java.net.HttpURLConnection
import java.net.URL
import kotlin.concurrent.thread



class MainActivity : AppCompatActivity() {

    fun topicBlurb(s1: String, s2: String): String{
        return s1 + "- " + s2
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val prefs: SharedPreferences = getSharedPreferences("settings", MODE_PRIVATE)

        //prefs.edit().clear().commit()
        val airplane = Settings.System.getInt(applicationContext.contentResolver,
            Settings.Global.AIRPLANE_MODE_ON, 0)
        if(airplane!=0){
            Toast.makeText(this, "No Connection - Turn Airplane Mode Off", Toast.LENGTH_SHORT).show()
            Log.i("Main", "No Connection - Turn Airplane Mode Off")
        }else{
            val connectivityManager = applicationContext.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            if(connectivityManager.activeNetworkInfo?.isConnectedOrConnecting==false){
                Toast.makeText(this, "No Connection", Toast.LENGTH_SHORT).show()
                Log.i("Main", "No Connection")
            }

        }

        if(prefs.contains("application.firstRun")){
            val t =  thread {
                val server = URL(prefs.getString("prefURL", "")!!)
                val client: HttpURLConnection = server.openConnection() as HttpURLConnection
                client.requestMethod = "GET"

                val outputFilePath = applicationContext.filesDir.toString() + "/questions.json"
                val url = prefs.getString("prefURL", "")
                Handler(Looper.getMainLooper()).post {
                    Toast.makeText(this, "Downloading JSON File from $url", Toast.LENGTH_SHORT).show()
                }
                try {
                    client.inputStream.copyTo(File(outputFilePath).outputStream())
                    Handler(Looper.getMainLooper()).post {
                        Toast.makeText(this, "JSON file got downloaded successfully", Toast.LENGTH_SHORT).show()
                        val app = this.application as QuizApp
                        app.restart()
                        val btn0 = findViewById<Button>(R.id.btn0)
                        val btn1 = findViewById<Button>(R.id.btn1)
                        val btn2 = findViewById<Button>(R.id.btn2)

                        btn0.setText(topicBlurb(app.getTitle(0), app.getShortDescr(0)))
                        btn1.setText(topicBlurb(app.getTitle(1), app.getShortDescr(1)))
                        btn2.setText(topicBlurb(app.getTitle(2), app.getShortDescr(2)))

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
                    }


                } catch(e: FileNotFoundException){
                    Handler(Looper.getMainLooper()).post {
                        prefs.edit().clear().commit()
                        Toast.makeText(this, "Failed to download JSON file", Toast.LENGTH_SHORT).show()
                        val intent = Intent(this, Preferences::class.java)
                        startActivity(intent)
                    }
                }
            }
        }else{
            val intent = Intent(this, Preferences::class.java)
            startActivity(intent)
        }
    }

}