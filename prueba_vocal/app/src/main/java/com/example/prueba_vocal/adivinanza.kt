package com.example.prueba_vocal

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class adivinanza : AppCompatActivity() {

    private val words = listOf("ELEPHANT", "IGUANA", "UNICORN", "ALLIGATOR", "OCTOPUS")
    private var selectedWord = ""
    private var displayedWord = ""
    private var incorrectLetters = ""
    private var remainingAttempts = 6

    private lateinit var tvWord: TextView
    private lateinit var tvIncorrectLetters: TextView
    private lateinit var etLetter: EditText
    private lateinit var btnSubmit: Button
    private lateinit var tvWordLength: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_adivinanza)

        tvWord = findViewById(R.id.tvWord)
        tvIncorrectLetters = findViewById(R.id.tvIncorrectLetters)
        etLetter = findViewById(R.id.etLetter)
        btnSubmit = findViewById(R.id.btnSubmit)
        tvWordLength = findViewById(R.id.tvWordLength)

        startNewGame()

        btnSubmit.setOnClickListener {
            val letter = etLetter.text.toString().toUpperCase()
            if (letter.isNotEmpty() && letter.length == 1) {
                if (selectedWord.contains(letter)) {
                    updateDisplayedWord(letter)
                } else {
                    incorrectLetters += "$letter "
                    tvIncorrectLetters.text = "Incorrect Letters: $incorrectLetters"
                    remainingAttempts--
                }

                etLetter.text.clear()

                if (displayedWord == selectedWord) {
                    Toast.makeText(this, "You win!", Toast.LENGTH_LONG).show()
                    startNewGame()
                } else if (remainingAttempts == 0) {
                    Toast.makeText(this, "You lose! The word was $selectedWord", Toast.LENGTH_LONG).show()
                    startNewGame()
                }
            } else {
                Toast.makeText(this, "Please enter a single letter", Toast.LENGTH_SHORT).show()
            }
        }

    }

    private fun startNewGame() {
        selectedWord = words.random()
        displayedWord = "_".repeat(selectedWord.length)
        incorrectLetters = ""
        remainingAttempts = 6

        tvWord.text = displayedWord
        tvIncorrectLetters.text = "Incorrect Letters: $incorrectLetters"
        tvWordLength.text = "Word Length: ${selectedWord.length}"
    }

    private fun buildDisplayedWord(word: String): String {
        val displayed = StringBuilder()
        for (char in word) {
            displayed.append(" ")
        }
        return displayed.toString()
    }

    private fun updateDisplayedWord(letter: String) {
        val newDisplayedWord = StringBuilder(displayedWord)

        for (i in selectedWord.indices) {
            if (selectedWord[i].toString() == letter) {
                newDisplayedWord.setCharAt(i, letter.first())
            }
        }

        displayedWord = newDisplayedWord.toString()
        tvWord.text = displayedWord
    }

}