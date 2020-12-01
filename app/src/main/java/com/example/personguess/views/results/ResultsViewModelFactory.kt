package com.example.personguess.views.results

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import java.lang.IllegalArgumentException

class ResultsViewModelFactory(private val finalScore: Int) : ViewModelProvider.Factory {
	override fun <T : ViewModel?> create(modelClass: Class<T>): T {
		if (modelClass.isAssignableFrom(ResultsViewModel::class.java)) {
			return ResultsViewModel(finalScore) as T
		}
		throw IllegalArgumentException("Unknown ViewModel Class")
	}
}