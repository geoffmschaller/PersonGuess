package com.example.personguess.views.start

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.personguess.R
import com.example.personguess.databinding.StartFragmentBinding

class StartFragment : Fragment() {

	companion object {
		fun newInstance() = StartFragment()
	}

	private lateinit var viewModel: StartViewModel
	lateinit var binding: StartFragmentBinding

	override fun onCreateView(
		inflater: LayoutInflater, container: ViewGroup?,
		savedInstanceState: Bundle?

	): View {
		viewModel = ViewModelProvider(this, StartViewModelFactory()).get(StartViewModel::class.java)
		binding = StartFragmentBinding.inflate(inflater, container, false)
		return binding.root
	}

	override fun onActivityCreated(savedInstanceState: Bundle?) {
		super.onActivityCreated(savedInstanceState)
		binding.startButton.setOnClickListener {
			findNavController().navigate(R.id.action_startFragment_to_gameFragment)
		}
	}

}