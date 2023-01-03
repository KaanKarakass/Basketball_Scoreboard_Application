package com.kaankarakas.basketballscoreboard
import androidx.lifecycle.ViewModel
class ScoreBoardViewModel(team1:String , team2:String): ViewModel() {
    val team1= team1
    val team2 = team2

    var score1 = 0
    var score2 = 0

    fun whoWon():String{
        var message =""
        if(score1>score2)
            message ="Congratulations $team1"
        else if(score2>score1)
            message = "Congratulations $team2"
        else
            message ="Same Points"
        return message
    }
    fun points(team:Int, point:Int){
        if (team == 1){
            score1 += point
        }else{
            score2 += point
        }
    }

}