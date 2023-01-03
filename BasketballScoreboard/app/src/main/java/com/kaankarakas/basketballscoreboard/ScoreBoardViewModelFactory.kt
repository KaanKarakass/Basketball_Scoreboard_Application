package com.kaankarakas.basketballscoreboard
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import java.lang.IllegalArgumentException
class ScoreBoardViewModelFactory(private val team1:String , private val team2:String):ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(ScoreBoardViewModel::class.java))
            return ScoreBoardViewModel(team1,team2) as T
        throw IllegalArgumentException("Unknown ViewModel")
    }
}