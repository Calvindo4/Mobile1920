package com.example.android.navigation

import android.app.Application

class Story: Application() {
    data class Question(
            val text: String,
            val answers: List<String>
    )
}