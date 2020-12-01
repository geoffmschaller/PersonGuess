package com.example.personguess.data

object People {
	private val peopleList = arrayListOf<String>()

	init {
		peopleList.add("Albert Einstein")
		peopleList.add("Sir Isaac Newton")
		peopleList.add("Werner Heisenberg")
		peopleList.add("Werner Von Brown")
	}

	fun getPeople(): ArrayList<String> {
		return peopleList
	}
}