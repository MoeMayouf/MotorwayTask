package com.mayouf.motorwaytest.presentation

import android.os.Bundle
import android.util.Log
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.addTextChangedListener
import androidx.lifecycle.ViewModelProvider
import com.mayouf.motorwaytest.R

class MotorwayActivity : AppCompatActivity() {

    private var motorwayViewModel: MotorwayViewModel? = null
    private val TAG = "MotorwayActivity "

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Initialising editText and textView to be used by mainActivity
        val etParagraph: EditText = findViewById(R.id.etWords)
        val tvWordCount: TextView = findViewById(R.id.tvWordCount)


        //Providing instance of ViewModel, can be injected instead
        motorwayViewModel = this.run { ViewModelProvider(this)[MotorwayViewModel::class.java] }

        //Initial word count for the text that has been pre-set
        motorwayViewModel?.countWordsFromEditText(etParagraph.text.toString())

        //Text change listener for when the user engages with the EditText
        etParagraph.addTextChangedListener {
            motorwayViewModel?.countWordsFromEditText(etParagraph.text.toString())
        }

        //Observing the result of the liveData when text is changing/changed
        motorwayViewModel?.wordCountLiveData?.observe(this, { wordCount ->
            Log.d(TAG, "Word count is $wordCount")
            tvWordCount.text = "Word count is $wordCount"
        })

    }
}