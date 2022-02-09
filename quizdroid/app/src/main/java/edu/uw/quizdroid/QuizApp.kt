package edu.uw.quizdroid
import android.util.Log
import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import org.json.JSONArray
import java.io.File
import java.io.FileInputStream
import java.io.InputStream

interface TopicRepository{

}

data class Quiz(val question: String, val answers: List<String>, val correct: Int) {}

data class Topic(val title:String, val shortDescription: String, val longDescription: String, var quizzes: List<Quiz>){}

class oldTopicRepo(): TopicRepository{
    var topics: List<Topic> =  mutableListOf(
        // val a1: String, val a2: String, val a3: String, val a4: String,
        Topic("Math", "algebra + geometry", "Testing your knowledge on algebra and geometry! 3 questions in total", mutableListOf(
            Quiz("1 + 1", mutableListOf("2", "0", "-2", "1"), 0),
            Quiz("3 - 0", mutableListOf("0", "3", "-1", "-3"), 1),
            Quiz("4 * 150 ", mutableListOf("20", "600", "4150", "-3"), 1))),
        Topic("Seattle", "206", "Testing your knowledge on the 206! 3 questions in total", mutableListOf(
            Quiz("Area Code", mutableListOf("206", "111", "999", "133"), 0),
            Quiz("Closest Link Station to UW Tower", mutableListOf("UW Stadium", "Northgate", "U District", "Roosevelt"), 2),
            Quiz("Which one of the following is a building at UW?", mutableListOf("PPM", "NGW", "000", "MGH"), 3))),
        Topic("Physics","momentum + force + motion", "Testing your knowledge on momentum, force, and motion! 3 questions in total", mutableListOf(
            Quiz("PHYS course code for Introduction to Physics though Inquiry at UW ", mutableListOf("101", "112", "102", "211"), 0),
            Quiz("PHYS course code for Mechanics (four credits) at UW ", mutableListOf("114", "333","102","103"), 0),
            Quiz("PHYS course code for Electromagnetism at UW",mutableListOf("111", "102", "122", "106"), 2))),
        Topic("Marvel","captain america + iron man + hulk", "Testing your knowledge on captain america, iron man, and hulk! 3 questions in total", mutableListOf(
            Quiz("Which one of the following is a super hero from Marvel?", mutableListOf("Captain America", "Jay Inslee", "Baymax", "Elsa"), 0),
            Quiz("Which one of the following is a super hero from Marvel?", mutableListOf("Dash", "Hulk","Frozone","Batman"), 1),
            Quiz("Which one of the following is a super hero from Marvel?",mutableListOf("Jack-J", "Wonder Woman", "Black Panthers", "Superman"), 2)
        ))
    )
}

/*fun readJSON(jsonFile: InputStream): String{
    var formatted: String = ""
    try {
        formatted = jsonFile.bufferedReader().use{it.readText()}
    } catch (ex:Exception){
        ex.printStackTrace()
    }
    return formatted
}*/


class JSONTopicRepo(): TopicRepository{
    val topics: List<Topic> = mutableListOf<Topic>()
    /*val file: File = File("edu/uw/quizdroid/data/questions.json") // from somewhere
    val bytes = inputStream.readBytes()
    file.writeBytes(bytes)
*/
    /*
    FileInputStream in = openFileInput("filename.txt");
    InputStreamReader inputStreamReader = new InputStreamReader(in);
    BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
    StringBuilder sb = new StringBuilder();
    String line;
    while ((line = bufferedReader.readLine()) != null) {
        sb.append(line);
    }
    inputStreamReader.close();*/
    /*
    Context.openFileInput("edu/uw/quizdroid/data/questions.json").use { stream ->
        val text = stream.bufferedReader().use {
            it.readText()
        }
        Log.i("TAG", "LOADED: $text")
    }*/

    //val questions = JSONArray("${readJSON(assets.open("quizdroid/app/src/main/java/edu/uw/quizdroid/data/questions.json"))}")
    // var formatted: String = ""
    //contentResolver.openInputStream("edu/uw/quizdroid/data/questions.json")!!.bufferedReader().use {it.readText() }
   /* try {
        formatted = jsonFile.bufferedReader().use{it.readText()}
    } catch (ex:Exception){
        ex.printStackTrace()
    }
    return formatted
*/

    // questions - questions.json
    /* for (i in 0..(questions.length()-1)) {
        val title = questions.getJSONObject(i).get("Title") as String
        val shortDescr = questions.getJSONObject(i).get("desc") as String
        val longDescr = questions.getJSONObject(i).get("desc") as String
        val topicQuestions =  questions.getJSONObject(i).getJSONArray("questions")
        val formattedTopicQuestions = mutableListOf<Quiz>()
        for (i in 0..(topicQuestions.length()-1)){
            val question = topicQuestions.getJSONObject(i).get("title") as String
            val correct = topicQuestions.getJSONObject(i).get("answer").toInt() - 1 as Integer
            val answers = topicQuestions.getJSONObject(i).get("answers")
            formattedTopicQuestions.add(Quiz(question, answers, correct))
        }
        topics.add(Topic(title, shortDescr, longDescr, formattedTopicQuestions))
    }*/
}

class QuizApp: Application() {
    private var topicRepo = oldTopicRepo()
    private var curr = 0
    private var correct = 0

    override fun onCreate() {
        super.onCreate()
        Log.i("QuizApp", "Quiz App Launched")
    }

    fun getTitle(index: Int): String{
        return topicRepo.topics[index].title
    }
    fun getShortDescr(index: Int): String{
        return topicRepo.topics[index].shortDescription
    }
    fun getLongDescr(index: Int): String{
        return topicRepo.topics[index].longDescription
    }
    fun getCurr(): Int {
        return curr
    }
    fun getCorrect(): Int{
        return correct
    }
    fun currIncrement(){
        if(curr<3) {
            curr++
        }
    }
    fun correctIncrement(){
        if(correct<3) {
            correct++
        }
    }
    fun restart(){
        curr = 0
        correct = 0
    }
    fun getCurrQuestion(index: Int, curr: Int): String{
        return topicRepo.topics[index].quizzes[curr].question
    }
    fun getAnswer(index: Int, curr: Int, ans: Int): String{
        return topicRepo.topics[index].quizzes[curr].answers[ans]
    }
    fun getCorrectAnswer(index: Int, curr: Int): String{
        val correctIndex = topicRepo.topics[index].quizzes[curr].correct
        return topicRepo.topics[index].quizzes[curr].answers[correctIndex]
    }


}