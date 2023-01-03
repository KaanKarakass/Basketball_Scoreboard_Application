package com.kaankarakas.basketballscoreboard

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModel
import androidx.navigation.findNavController
import com.google.android.material.snackbar.Snackbar
import com.kaankarakas.basketballscoreboard.databinding.FragmentWelcomeBinding

class WelcomeFragment : Fragment() {
    private var _binding: FragmentWelcomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentWelcomeBinding.inflate(inflater, container , false)
        val view = binding.root

        binding.nextButton.setOnClickListener {
            val team1 = binding.firstTeam.text.toString()
            val team2 = binding.secondTeam.text.toString()

            if(team1.isEmpty() || team2.isEmpty()){
                Snackbar.make(it,"You must enter team names",Snackbar.LENGTH_LONG).show()
            }
            else{
                val action = WelcomeFragmentDirections.actionWelcomeFragmentToScoreBoardFragment(team1, team2)
                view.findNavController().navigate(action)
            }
        }
        return view
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding =null
    }

}