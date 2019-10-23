package com.example.android.navigation

import android.app.Application
import timber.log.Timber

class MyApplication: Application() {
    companion object {
        val MAIN_MENU = "Main Menu"
        val TRY_AGAIN = "Try Again"
        val CONTINUE = "Continue"

        val questions: List<Story.Question> = mutableListOf(
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

        var LOG_PREFIX = "[TIMBER LOGGING] : "

        var ON_CREATE_CALLED = LOG_PREFIX + "onCreate() Called!"
        var ON_START_CALLED = LOG_PREFIX + "onStart() Called!"
        var ON_RESUME_CALLED = LOG_PREFIX + "onResume() Called!"
        var ON_PAUSE_CALLED = LOG_PREFIX + "onPause() Called!"
        var ON_STOP_CALLED = LOG_PREFIX + "onStop() Called!"
        var ON_DESTROY_CALLED = LOG_PREFIX + "onDestroy() Called!"
        var ON_RESTART_CALLED = LOG_PREFIX + "onRestart() Called!"
        var ON_ATTACH_CALLED = LOG_PREFIX + "onAttach() Called!"
        var ON_DETACH_CALLED = LOG_PREFIX + "onDetach() Called!"
        var ON_CREATE_VIEW__CALLED = LOG_PREFIX + "onCreateView() Called!"
        var ON_DESTROY_VIEW__CALLED = LOG_PREFIX + "onDestroyView() Called!"
    }

    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
    }
}