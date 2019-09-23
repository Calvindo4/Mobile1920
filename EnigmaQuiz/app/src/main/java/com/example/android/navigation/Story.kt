package com.example.android.navigation

import android.app.Application

class Story: Application() {
    data class Question(
            val text: String,
            val answers: List<String>)

    // The first answer is the correct one.  We randomize the answers before showing the text.
    // All questions must have four answers.  We'd want these to contain references to string
    // resources so we could internationalize. (Or better yet, don't define the questions in code...)
    val questions: List<Question> = mutableListOf(
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

}