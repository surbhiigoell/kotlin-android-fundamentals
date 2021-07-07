package com.example.android.guesstheword.screens.game

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class GameViewModel : ViewModel() {

    // The current word
    private var _word = MutableLiveData<String>()
    val word: LiveData<String>
    get() = _word

    // The current score
    private var _score = MutableLiveData<Int>()
    val score: LiveData<Int>
    get() = _score

    //event which triggers the end of the game
    private val _eventGameFinished = MutableLiveData<Boolean>()
    val eventGameFinished: LiveData<Boolean>
    get() = _eventGameFinished

    // The list of words - the front of the list is the next word to guess
    lateinit var wordList: MutableList<String>


    init {
        _word.value = ""
        _score.value = 0
        resetList()
        nextWord()
        Log.i("GameViewModel", "GameViewModel created!")
    }

    override fun onCleared() {
        super.onCleared()
        Log.i("GameViewModel", "GameViewModel destroyed!")
    }

    /**
     * Resets the list of words and randomizes the order
     */
    private fun resetList() {
        wordList = mutableListOf(
            "queen",
            "hospital",
            "basketball",
            "cat",
            "change",
            "snail",
            "soup",
            "calendar",
            "sad",
            "desk",
            "guitar",
            "home",
            "railway",
            "zebra",
            "jelly",
            "car",
            "crow",
            "trade",
            "bag",
            "roll",
            "bubble"
        )
        wordList.shuffle()
    }

    /**
     * Moves to the next word in the list
     */
    private fun nextWord() {
        if (wordList.isEmpty()) {
            onGameFinish()
        } else {
            //Select and remove a word from the list
            _word.value = wordList.removeAt(0)
        }
    }

    /** Method for the game completed event **/

    fun onGameFinish() {
        _eventGameFinished.value = true
    }

    /**Method for the game completed event **/

    fun onGameFinishComplete() {
        _eventGameFinished.value = false
    }

    /** Methods for buttons presses **/

    fun onSkip() {
        _score.value = (this.score.value)?.minus(1)
        nextWord()
    }

    fun onCorrect() {
        _score.value = (this.score.value)?.plus(1)
        nextWord()
    }
}