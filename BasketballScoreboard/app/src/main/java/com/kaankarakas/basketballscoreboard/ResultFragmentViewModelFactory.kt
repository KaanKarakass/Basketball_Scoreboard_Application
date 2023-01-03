package com.kaankarakas.basketballscoreboard
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import java.lang.IllegalArgumentException
class ResultFragmentViewModelFactory (private val wonTeam: String):ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T{
        if(modelClass.isAssignableFrom(ResultFragmentViewModel::class.java))
            return ResultFragmentViewModel(wonTeam) as T
        throw IllegalArgumentException("Unknown ViewModel")
    }
}