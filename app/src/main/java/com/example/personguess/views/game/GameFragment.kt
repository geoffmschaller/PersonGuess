package com.example.personguess.views.game

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.example.personguess.R
import com.example.personguess.data.GameMode
import com.example.personguess.databinding.GameFragmentBinding

class GameFragment : Fragment() {

	companion object {
		fun newInstance() = GameFragment()
	}

	private lateinit var viewModel: GameViewModel
	private lateinit var binding: GameFragmentBinding


	override fun onCreateView(
		inflater: LayoutInflater, container: ViewGroup?,
		savedInstanceState: Bundle?
	): View {
		binding = GameFragmentBinding.inflate(inflater, container, false)
		return binding.root
	}

	override fun onActivityCreated(savedInstanceState: Bundle?) {
		super.onActivityCreated(savedInstanceState)
		viewModel = ViewModelProvider(this).get(GameViewModel::class.java)

		binding.passButton.setOnClickListener {
			viewModel.scoreQuestion(false)
		}

		binding.nextButton.setOnClickListener {
			viewModel.scoreQuestion(true)
		}

		viewModel.currentPerson.observe(viewLifecycleOwner, Observer { newPerson ->
			binding.personName.text = newPerson
		})

		viewModel.gameMode.observe(viewLifecycleOwner, Observer { newGameMode ->
			if (newGameMode == GameMode.DONE) {
				findNavController().navigate(R.id.action_gameFragment_to_resultsFragment)
			}
		})
	}

}