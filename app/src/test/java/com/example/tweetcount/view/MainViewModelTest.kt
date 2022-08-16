package com.example.tweetcount.view

import junit.framework.Assert.assertEquals
import org.junit.Rule
import org.junit.Test
import androidx.arch.core.executor.testing.InstantTaskExecutorRule


internal class MainViewModelTest {

    @get:Rule
    var instantExecutorRule = InstantTaskExecutorRule()



    @Test
    fun testClearFunction() {
        val viewModel = MainViewModel()

        //test init values
        assertEquals(viewModel.counter.value, 0)
        assertEquals(viewModel.remaing.value, 280)
        assertEquals(viewModel.tweet.value, "")

        viewModel.tweet.value = "hello world"
        viewModel.counter.value = viewModel.tweet.value!!.length
        viewModel.remaing.value = 290 - viewModel.counter.value!!
        viewModel.clearText()


        assertEquals(viewModel.counter.value, 0)
        assertEquals(viewModel.remaing.value, 280)
        assertEquals(viewModel.tweet.value, "")

    }
}