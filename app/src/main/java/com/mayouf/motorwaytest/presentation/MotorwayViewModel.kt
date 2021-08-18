package com.mayouf.motorwaytest.presentation

import androidx.lifecycle.ViewModel
import com.mayouf.motorwaytest.utils.SingleLiveEvent
import com.mayouf.motorwaytest.utils.countWords

class MotorwayViewModel : ViewModel() {
    //Created SingleLiveEvent to avoid multiple instance of the liveData being sent to the view
    val wordCountLiveData: SingleLiveEvent<String> = SingleLiveEvent<String>()

    //Implemented Extension Function to calculate the number of words
    fun countWordsFromEditText(textFromParagraph: String?) {
        wordCountLiveData.postValue(textFromParagraph?.countWords().toString())
    }

}