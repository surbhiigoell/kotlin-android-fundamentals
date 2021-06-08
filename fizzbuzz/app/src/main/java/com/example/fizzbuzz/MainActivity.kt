package com.example.fizzbuzz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var counter: Int = 1

        while (counter >=100)
        {
            if (counter%3 == 0 && counter%5 == 0)
                Log.d("number", "FizzBuzz")
            else if (counter%5 == 0)
                Log.d("number","Buzz")
            else if (counter%3 == 0)
                Log.d("number","Fizz")
            else
                Log.d("number", counter.toString())
            counter +=1
        }
    }
}