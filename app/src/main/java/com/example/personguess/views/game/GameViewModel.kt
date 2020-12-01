package com.example.personguess.views.game

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.personguess.data.GameMode
import com.example.personguess.data.People

class GameViewModel : ViewModel() {

	val people = People.getPeople()
	var currentIndex = 0
	var score = 0

	var gameMode = MutableLiveData<GameMode>(GameMode.PLAYING)
	var currentPerson = MutableLiveData<String>(people[currentIndex])

	override fun onCleared() {
		super.onCleared()
	}

	fun scoreQuestion(correct: Boolean) {
		if (correct) {
			score += 1
		}
		currentIndex += 1
		if (currentIndex < people.size) {
			currentPerson.value = people[currentIndex]
		} else {
			gameMode.value = GameMode.DONE
		}
	}

}