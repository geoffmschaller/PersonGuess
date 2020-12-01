package com.example.personguess.views.results

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.personguess.databinding.ResultsFragmentBinding

class ResultsFragment : Fragment() {

	companion object {
		fun newInstance() = ResultsFragment()
	}

	private lateinit var viewModel: ResultsViewModel
	private lateinit var binding: ResultsFragmentBinding

	override fun onCreateView(
		inflater: LayoutInflater, container: ViewGroup?,
		savedInstanceState: Bundle?
	): View {
		viewModel = ViewModelProvider(
			this,
			ResultsViewModelFactory(ResultsFragmentArgs.fromBundle(requireArguments()).score)
		).get(ResultsViewModel::class.java)
		binding = ResultsFragmentBinding.inflate(inflater, container, false)
		return binding.root
	}

	override fun onActivityCreated(savedInstanceState: Bundle?) {
		super.onActivityCreated(savedInstanceState)

		binding.score.text = viewModel.finalScore.toString()
	}

}