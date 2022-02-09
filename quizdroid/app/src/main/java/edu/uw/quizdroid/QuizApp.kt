package edu.uw.quizdroid
import android.util.Log
import android.app.Application

interface TopicRepository {}

data class Quiz(val question: String, val answers: List<String>, val correct: Int) {}

data class Topic(val title:String, val shortDescription: String, val longDescription: String, var quizzes: List<Quiz>){}

class TopicRepo(): TopicRepository{
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

class QuizApp: Application() {
    private var topicRepo = TopicRepo()
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