/*
 * Copyright 2018, The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.android.navigation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.android.navigation.databinding.FragmentGameBinding
import kotlinx.android.synthetic.main.fragment_game.*

class GameFragment : Fragment() {
    data class Question(
            val text: String,
            val answers: List<String>)

    // The first answer is the correct one.  We randomize the answers before showing the text.
    // All questions must have four answers.  We'd want these to contain references to string
    // resources so we could internationalize. (Or better yet, don't define the questions in code...)
    private val questions: MutableList<Question> = mutableListOf(
            Question(text = "See, Listen, Smell, _____, Touch ",
                    answers = listOf("Taste", "Eat", "Bite", "Swallow")),
            Question(text = "b, B, KB, MB, __, __, __, EB, ZB, YB",
                    answers = listOf("GB, TB, PB", "BB, CB, DB", "3B, 2B, HB", "WB, FB, XB")),
            Question(text = "31-14 251721 1851-4 208919? (1=a, 2=b,...)",
                    answers = listOf("25519", "2381-20", "821-8", "1-1878")),
            Question(text = "emordnilad-non?",
                    answers = listOf("Skis", "Taco cat", "Race car", "Kayak")),
            Question(text = "d+h*b? (a=1, b=2,...)",
                    answers = listOf("u", "x", "q", "l")),
            Question(text = "The current president: ___",
                    answers = listOf("VII", "VIII", "IV", "VI")),
            Question(text = "SOS = Save Our?",
                    answers = listOf("Soul", "Song", "Sign", "Safe")),
            Question(text = "2+2 = Pisces, 3+3 = Papillon, 6+6 = ?",
                    answers = listOf("Spade", "Heart", "Club", "Diamond")),
            Question(text = "Which one isn't a vertebrae?",
                    answers = listOf("Phasmatodea", "Canidae", "Cristatus", "Selachimorpha")),
            Question(text = "Which one isn't extinct yet??",
                    answers = listOf("Nautilus", "Anomalocaris", "Trilobite", "Dunkleosteus")),
            Question(text = "wwwwwww?",
                    answers = listOf("Japanese","Chinese","Korean","Indonesian")),
            Question(text = "Which one isn't fit in the category below?",
                    answers = listOf("French","Poland","Austria","Croatia")),
            Question(text = "Nintendon't?",
                    answers = listOf("Cinos","Oiram","Knil","Uhcakip")),
            Question(text = "Imagine something bad is happening here, which number will you call on your cellphone?",
                    answers = listOf("112","110","118","113")),
            Question(text = "The 13 strategies from Arts of War is made by?",
                    answers = listOf("Sun Tzu","Sun Bin","Pang Juan","Xian Han"))
    )



    lateinit var currentQuestion: Question
    lateinit var answers: MutableList<String>
    private var questionIndex = 0
    private val numQuestions = Math.min((questions.size + 1) / 1, 15)

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        // Inflate the layout for this fragment
        val binding = DataBindingUtil.inflate<FragmentGameBinding>(
                inflater, R.layout.fragment_game, container, false)

        // Shuffles the questions and sets the question index to the first question.
        randomizeQuestions()

        // Bind this fragment class to the layout
        binding.game = this

        // Set the onClickListener for the submitButton
        binding.submitButton.setOnClickListener @Suppress("UNUSED_ANONYMOUS_PARAMETER")
        { view: View ->
            val checkedId = binding.questionRadioGroup.checkedRadioButtonId

            // Do nothing if nothing is checked (id == -1)
            if (-1 != checkedId) {
                var answerIndex = 0
                when (checkedId) {
                    R.id.secondAnswerRadioButton -> answerIndex = 1
                    R.id.thirdAnswerRadioButton -> answerIndex = 2
                    R.id.fourthAnswerRadioButton -> answerIndex = 3
                }
                when (currentQuestion) {
                    questions[0] -> when(answerIndex) {
                        0 -> {
                                currentQuestion = questions[1]
                                answers = currentQuestion.answers.toMutableList()
                        }
                    }
                    questions[1] -> when(answerIndex) {
                        0 -> {
                            currentQuestion = questions[2]
                            answers = currentQuestion.answers.toMutableList()
                        }
                    }
                }
                binding.invalidateAll()
                // The first answer in the original question is always the correct one, so if our
                // answer matches, we have the correct answer.

                if (answers[answerIndex] == currentQuestion.answers[0]) {
                    questionIndex++
                    // Advance to the next question
                    if (questionIndex < numQuestions) {
                        currentQuestion = questions[questionIndex]
                        setQuestion()
                        binding.invalidateAll()
                    } else {
                        // We've won!  Navigate to the gameWonFragment.
                        view.findNavController().navigate(R.id.action_gameFragment_to_gameWonFragment3)
                    }
                } else {
                    // Game over! A wrong answer sends us to the gameOverFragment.
                    view.findNavController().navigate(R.id.action_gameFragment_to_gameOverFragment)
                }


            }
        }
        return binding.root
    }

    // randomize the questions and set the first question
    private fun randomizeQuestions() {
        questions.shuffle()
        questionIndex = 0
        setQuestion()
    }

    private fun startGame() {
        currentQuestion = questions[0]
    }

    // Sets the question and randomizes the answers.  This only changes the data, not the UI.
    // Calling invalidateAll on the FragmentGameBinding updates the data.
    private fun setQuestion() {
        currentQuestion = questions[questionIndex]
        // randomize the answers into a copy of the array
        answers = currentQuestion.answers.toMutableList()
        answers.shuffle()
    }
}
