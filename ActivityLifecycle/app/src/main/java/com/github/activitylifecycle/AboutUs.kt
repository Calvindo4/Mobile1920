package com.github.activitylifecycle

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.util.Log
import android.widget.Toast

class AboutUs: AppCompatActivity() {

    val TAG="About Us"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        Log.d(TAG, "inside Oncreate")
        Toast.makeText(this,"You are under about us",Toast.LENGTH_LONG).show()
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG,"In Onstart")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG,"In Onstop")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG,"In Onpause")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG,"In Ondestroy")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(TAG,"In Onrestart")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG,"In Onresume")
    }
}