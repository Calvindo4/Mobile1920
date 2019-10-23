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
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController
import com.example.android.navigation.MyApplication
import com.example.android.navigation.R
import com.example.android.navigation.databinding.FragmentGameBinding
import com.example.android.navigation.Story
import timber.log.Timber

class GameFragment : Fragment() {

    override fun onAttach(context: Context) {
        super.onAttach(context)

        Timber.d(MyApplication.ON_ATTACH_CALLED)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onDestroy(savedInstanceState)

        Timber.d(MyApplication.ON_CREATE_CALLED)
    }

    data class Question(
            val text: String,
            val answers: List<String>)

    // The first answer is the correct one.  We randomize the answers before showing the text.
    // All questions must have four answers.  We'd want these to contain references to string
    // resources so we could internationalize. (Or better yet, don't define the questions in code...)
    private val questions: MutableList<Question> = mutableListOf(
            Question(text = "When you enter this room, you see a torch, a water filled bowl, a small rock, and a iron fan around you. in front of you is a door, but with a fire symbol. You tried to open it with all your might, but to no avail, you failed yo open it. You look at things around you, and what will you do?",
                    answers = listOf("Throw the bowl to the door to make it wet", "Burn the door with the torch", "Throw the small rock to the center of the door", "Blow some wind to the door with the iron fan")),
            Question(text = "Ahead, there is some intersection consists of four directions: northwest, northeast, southeast, and southwest. You then see a sign that reads: when the sun rises, wait until the sun sets. while doing so, see the directions of it, and look for the direction in the evening. Which route will you take?",
                    answers = listOf("Northeast", "Northwest", "Southwest", "Southeast")),
            Question(text = "In this room, there is two doors, each at left and right, and two stairs, heading above and below. Next to you is a tablet that reads: 51420518 2085 19201-91819 2016 1-193514-4, and behind it is some engraving that reads: 1 is a, 4 is d, 9 is i, et cetera. Which path will you take?",
                    answers = listOf("Stairs to below", "Left Door", "Stairs to above", "Right Door")),
            Question(text = "Around you is some colored buttons such as of red, green, blue, and yellow buttons in a corridor. In the end of the corridor, you see 4 doors with different colors: purple, orange, cyan, and brown. above the doors are some engraving that says: combine the colors to open the door, but only the bright skies in the day know the true path. Which buttons will you press, and what door will you open and enter?",
                    answers = listOf("The green and blue buttons, then open the cyan door", "The red and blue buttons, then open the purple door", "The red and yellow buttons, then open the orange door", "The red and green buttons, then open the brown door")),
            Question(text = "When you entering this room, you read some engravings on the walls that says: follow the bats, then take the least taken route. suddenly group of bats flies around you, and flies to an specified path. You decided to follow the bats, but it turns out that the room have some intersections, each leads to far left, left, right, and far right corridors. Then these bats divide their groups, the biggest group goes to the far left corridor, the large group goes to the right corridor, the small group goes to the far right corridor, and only a handful of bats goes to the left corridor. Which corridor will you choose?",
                    answers = listOf("Far left corridor", "Right corridor", "Far right corridor", "Left corridor")),
            Question(text = "You entered a long, large corridor, but it's way too dark. However, you see some bright powder tracks at the ground, and you decided to follow these tracks. These track abruptly stops midway, and next to you is some wooden sticks. How can you find the end of the corridor?",
                    answers = listOf("Stick some of these bright powders to the wooden stick as makeshift torch", "using the wooden stick to vibrate the ground and explore using reverberation", "Throw some wooden sticks to see how far is the corridor", "connect every sticks possible to create a big, long stick")),
            Question(text = "You entered a room with 8 steel torches around you, and in front of you is a big, tough door that was too tight to open. around these torches is some sort of things such as rusted swords, giant paper fans, and acid bottles. What will you do to open the door?",
                    answers = listOf("Extinguish all torches using paper fans", "Break all torches with rusted swords", "Pry open the door using rusted swords", " try throwing the acid bottles to destroy the door")),
            Question(text = "There is a room with five buttons, each labeled with snake, grass, hopper, eagle, and frog images. next to you is a locked door. What button sequence will you make to open the door?",
                    answers = listOf("Grass, snake, frog, hopper, eagle", "Grass, Hopper, frog, snake, eagle", "Grass, eagle, hopper, snake, frog", "Grass, Hopper, snake, frog, eagle")),
            Question(text = "You entered a corridor, but it's blocked by several boulders. The only things that you see beside these boulders are ropes, sticks, and stones with various shapes. What will you do to clear these boulders out of your way?",
                    answers = listOf("Use the ropes to pull these boulders away", "Using sticks to lever out these boulders", "Combine things around you to make a makeshift pickaxe", "Try to breaking the boulders with these stones")),
            Question(text = "This room have some divided paths, one leading to the left, one forward path, one leading to right, and a descending staircase. There are an engraving in the center of the room that says: etak eth ywa ot eht olweb. Which path will you take?",
                    answers = listOf("The forward path", "The left path", "The right Path", "The descending stairs"))
    )

    lateinit var currentQuestion: Question
    lateinit var answers: MutableList<String>
    private var answerValue = 0
    private var questionIndex = 0
    private val numQuestions = Math.min((questions.size + 1) / 1, 10)

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        // Inflate the layout for this fragment
        val binding = DataBindingUtil.inflate<FragmentGameBinding>(
                inflater, R.layout.fragment_game, container, false)

        // Shuffles the questions and sets the question index to the first question.
        randomizeQuestions()

        // Bind this fragment class to the layout
        binding.game = this
        binding.lifecycleOwner = this

        // Set the onClickListener for the submitButton
        binding.submitButton.setOnClickListener @Suppress("UNUSED_ANONYMOUS_PARAMETER")
        { view: View ->
            val checkedId = binding.questionRadioGroup.checkedRadioButtonId
            // Do nothing if nothing is checked (id == -1)
            if (-1 != checkedId) {
                var answerIndex = 0
                when (checkedId) {
                    R.id.firstAnswerRadioButton -> answerIndex = 0
                    R.id.secondAnswerRadioButton -> answerIndex = 1
                    R.id.thirdAnswerRadioButton -> answerIndex = 2
                    R.id.fourthAnswerRadioButton -> answerIndex = 3
                }

                // The first answer in the original question is always the correct one, so if our
                // answer matches, we have the correct answer.
                when (currentQuestion) {
                    questions[0] -> when(answerIndex) {
                        0 -> {
                            currentQuestion = questions[1]
                            answers = currentQuestion.answers.toMutableList()
                        }
                    }
                    // Advance to the next question
                    if (questionIndex < numQuestions) {
                        currentQuestion = questions[questionIndex]
                        setQuestion()
                        binding.invalidateAll()
                    }
                    else if (answerValue > 15){
                        // Game over! A wrong answer sends us to the gameOverFragment.
                        view.findNavController().navigate(R.id.action_gameFragment_to_gameOverFragment)
                    }
                    else if (answerValue > 7 && answerValue < 15){
                        // We've... won? Navigate to the gameNotWinFragment.
                        view.findNavController().navigate(R.id.action_gameFragment_to_GameNotWonFragment)
                    } else {
                        // We've won!  Navigate to the gameWonFragment.
                        view.findNavController().navigate(R.id.action_gameFragment_to_gameWonFragment3)
                    }
                } else {
                    answerValue ++
                }
            }
        }
        Timber.d(MyApplication.ON_CREATE_VIEW__CALLED)
        binding.invalidateAll()
        return binding.root
    }

    // randomize the questions and set the first question
    private fun randomizeQuestions() {
        questions.shuffle()
        questionIndex = 0
        setQuestion()
    }

    // Sets the question and randomizes the answers.  This only changes the data, not the UI.
    // Calling invalidateAll on the FragmentGameBinding updates the data.
    private fun setQuestion() {
        currentQuestion = questions[questionIndex]
        // randomize the answers into a copy of the array
        answers = currentQuestion.answers.toMutableList()
        answers.shuffle()
        (activity as AppCompatActivity).supportActionBar?.title = getString(R.string.title_android_trivia_question, questionIndex + 1, numQuestions)
    }

    override fun onStart() {
        super.onStart()

        Timber.d(MyApplication.ON_START_CALLED)
    }

    override fun onPause() {
        super.onPause()

        Timber.d(MyApplication.ON_PAUSE_CALLED)
    }

    override fun onStop() {
        super.onStop()

        Timber.d(MyApplication.ON_STOP_CALLED)
    }

    override fun onDestroyView() {
        super.onDestroyView()

        Timber.d(MyApplication.ON_DESTROY_VIEW__CALLED)
    }

    override fun onDetach() {
        super.onDetach()

        Timber.d(MyApplication.ON_DETACH_CALLED)
    }
}
