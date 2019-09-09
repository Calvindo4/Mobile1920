package com.github.loremgenerator

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.*
import androidx.databinding.DataBindingUtil
import com.github.loremgenerator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val myData: MyData = MyData("Created by me")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        val spinnerCheck = findViewById<Spinner>(R.id.spinner)
        binding.myData = myData

        val ipsumList = getResources().getStringArray(R.array.droplist)
        binding.creatorButton.setOnClickListener {
            pickCreatorName(it)
        }
        binding.creatorText.setOnClickListener {
            changeCreatorName(it)
        }

        if(spinnerCheck != null) {
            val arrayAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, ipsumList)
            binding.spinner.adapter = arrayAdapter

            binding.spinner.onItemSelectedListener = object: AdapterView.OnItemSelectedListener {
                override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long) {
                    if (position == 0) {
                        binding.loremText.text = getString(R.string.lorem_text)
                    }
                    if (position == 1) {
                        binding.loremText.text = getString(R.string.lorem_text2)
                    }
                    if (position == 2) {
                        binding.loremText.text = getString(R.string.lorem_text3)
                    }
                }
                override fun onNothingSelected(parent: AdapterView<*>) {
                    //nothing
                }
            }
        }
    }

    private fun pickCreatorName(view: View) {
        binding.apply {
            myData?.creator = creatorFill.text.toString()
            invalidateAll()
            creatorFill.visibility = View.GONE
            creatorButton.visibility = View.GONE
            creatorText.visibility = View.VISIBLE
        }
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken,0)
    }

    private fun changeCreatorName(view: View) {
        binding.apply{
            creatorText.visibility = View.GONE
            creatorFill.visibility = View.VISIBLE
            creatorButton.visibility = View.VISIBLE
            creatorFill.requestFocus()
        }
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.showSoftInput(binding.creatorFill, 0)
    }
}
