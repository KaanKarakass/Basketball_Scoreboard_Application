package com.kaankarakas.basketballscoreboard

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.kaankarakas.basketballscoreboard.databinding.FragmentScoreBoardBinding



class ScoreBoardFragment : Fragment() {
    private var _binding: FragmentScoreBoardBinding? = null
    private val binding get() = _binding!!

    lateinit var viewModel: ScoreBoardViewModel
    lateinit var viewModelFactory: ScoreBoardViewModelFactory
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentScoreBoardBinding.inflate(inflater, container , false)
        val view = binding.root

        val team1 = ScoreBoardFragmentArgs.fromBundle(requireArguments()).team1
        val team2 = ScoreBoardFragmentArgs.fromBundle(requireArguments()).team2

        viewModelFactory = ScoreBoardViewModelFactory(team1,team2)
        viewModel = ViewModelProvider(this, viewModelFactory)
            .get(ScoreBoardViewModel::class.java)

        teamNames()
        updateScreen()

     // for first team
        binding.firstPoint3.setOnClickListener {
            viewModel.points(1,3)
            updateScreen()
        }
        binding.firstPoint2.setOnClickListener {
            viewModel.points(1,2)
            updateScreen()
        }
        binding.firstFree.setOnClickListener {
            viewModel.points(1,1)
            updateScreen()
        }

        // for second team
        binding.secondPoint3.setOnClickListener {
            viewModel.points(2,3)
            updateScreen()
        }
        binding.secondPoint2.setOnClickListener {
            viewModel.points(2,2)
            updateScreen()
        }
        binding.secondFree.setOnClickListener {
            viewModel.points(2,1)
            updateScreen()
        }

        //game Over
        binding.endButton.setOnClickListener {
            val action = ScoreBoardFragmentDirections
                .actionScoreBoardFragmentToResultFragment(viewModel.whoWon())
            view.findNavController().navigate(action)
        }
        return view
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding =null
    }
    fun teamNames(){
        binding.team1.text =viewModel.team1
        binding.team2.text=viewModel.team2
    }
    fun updateScreen()
    {
        binding.firstPoint.text = viewModel.score1.toString()
        binding.secondPoint.text =viewModel.score2.toString()
    }



}