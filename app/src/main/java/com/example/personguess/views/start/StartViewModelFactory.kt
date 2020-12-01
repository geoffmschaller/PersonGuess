package com.example.personguess.views.start

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import java.lang.IllegalArgumentException

class StartViewModelFactory() : ViewModelProvider.Factory {
	override fun <T : ViewModel?> create(modelClass: Class<T>): T {
		if (modelClass.isAssignableFrom(StartViewModel::class.java)) {
			return StartViewModel() as T
		}
		throw IllegalArgumentException("Unknown ViewModel")
	}
}