package edu.uw.quizdroid

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.util.Log
import android.widget.Button
import java.io.BufferedReader
import java.io.File
import java.io.InputStream
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL
import kotlin.concurrent.thread

/*

The application should create some background operation (Thread, AlarmManager or Service)
that will (eventually) attempt to download a JSON file containing the questions from the
server every "N" minutes/hours. For now, pop a Toast message displaying the URL that will
eventually be hit. Make sure this URL is what's defined in the Preferences.

The background operation should now attempt to download the JSON file specified in the
Preferences URL. Save this data to a local file as questions.json. Make sure that this file
always remains in a good state--if the download fails or is interrupted, the previous file
should remain in place.

If I am currently offline (in Airplane mode or in a no-bars area) the application should
display a message telling me I have no access to the Internet. If I am in airplane mode,
it should ask if I want to turn airplane mode off and take me to the Settings activity to
do so. If I simply have no signal, it should just punt gracefully with a nice error message.

If the download of the questions fails, the application should tell me and ask if I want to
retry or quit the application and try again later.


*
* */



class MainActivity : AppCompatActivity() {

    fun topicBlurb(s1: String, s2: String): String{
        return s1 + "- " + s2
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val app = this.application as QuizApp
        val prefs: SharedPreferences = getSharedPreferences("settings", MODE_PRIVATE)
        var temp = ""

        //prefs.edit().clear().commit()
        if(prefs.contains("application.firstRun")){
            Log.i("MAIN", prefs.getInt("prefMinutes", 0)!!.toString())
            //write to local file
            val t =  thread {
                val server = URL(prefs.getString("prefURL", "")!!)
                val client: HttpURLConnection = server.openConnection() as HttpURLConnection
                client.requestMethod = "GET"




                val outputFilePath = applicationContext.filesDir.toString() + "/questions.json"

                Log.i("here", outputFilePath)

                client.inputStream.copyTo(File(outputFilePath).outputStream())

                val result = BufferedReader(InputStreamReader(client.inputStream))
                var inputLine: String?
                /*while(result.readLine().also{inputLine=it}!=null)
                    // temp += inputLine!!.toString()
                    //temp.plus(inputLine!!.toString())
                    Log.i("here", inputLine!!.toString())
                    // File("data/questions.json").outputStream().use{}*/
                result.close()

                Log.i("here", File(outputFilePath).reader().toString())
            }
        }else{
            val intent = Intent(this, Preferences::class.java)
            startActivity(intent)
        }
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