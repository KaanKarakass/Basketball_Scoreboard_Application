package com.kaankarakas.basketballscoreboard

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.kaankarakas.basketballscoreboard.databinding.FragmentResultBinding

class ResultFragment : Fragment() {
    private var _binding: FragmentResultBinding? = null
    private val binding get() = _binding!!

    lateinit var viewModel: ResultFragmentViewModel
    lateinit var viewModelFactory: ResultFragmentViewModelFactory
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding =FragmentResultBinding.inflate(inflater, container, false)
        val view =binding.root

        val result = ResultFragmentArgs.fromBundle(requireArguments()).wonTeam

        viewModelFactory = ResultFragmentViewModelFactory(result)
        viewModel = ViewModelProvider(this, viewModelFactory)
            .get(ResultFragmentViewModel::class.java)

        binding.wonLost.text = viewModel.result

        binding.newMatchButton.setOnClickListener {
            view.findNavController()
                .navigate(R.id.action_resultFragment_to_welcomeFragment)
        }

        return view
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding =null
    }

}