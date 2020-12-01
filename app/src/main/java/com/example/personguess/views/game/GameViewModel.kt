package com.example.personguess.views.game

import androidx.lifecycle.ViewModel
import com.example.personguess.data.GameMode
import com.example.personguess.data.People

class GameViewModel : ViewModel() {

	val people = People.getPeople()
	var gameMode = GameMode.PLAYING
	var score = 0
	var currentPerson = ""
	var currentIndex = 0

	override fun onCleared() {
		super.onCleared()
	}

	fun scoreQuestion(correct: Boolean) {
		if (correct) {
			score += 1
		}
		currentIndex += 1
		if (currentIndex < people.size) {
			currentPerson = people[currentIndex]
		} else {
			gameMode = GameMode.DONE
		}

	}

}