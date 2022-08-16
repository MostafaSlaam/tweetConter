package com.example.tweetcount.view

import android.text.Editable
import android.text.TextWatcher
import androidx.databinding.ObservableField
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {


    var counter = MutableLiveData(0)
    var remaing = MutableLiveData(280)
    var tweet: MutableLiveData<String> = MutableLiveData("")
    val searchKeywordValidationListener = object : TextWatcher {

        override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

        }

        override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

        }

        override fun afterTextChanged(p0: Editable?) {
            remaing.value = remaing.value!! - (p0!!.length - counter.value!!)
            counter.value = p0?.length

        }
    }


    var postTweetState = MutableLiveData(false)


    fun clearText() {
        tweet.value = ""
        counter.value = 0
        remaing.value = 280
    }

    fun postTweet() {
        postTweetState.value = tweet.value!!.isNotEmpty()
    }
}