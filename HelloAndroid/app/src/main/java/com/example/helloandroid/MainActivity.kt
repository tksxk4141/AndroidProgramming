package com.example.helloandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    var count = 0

    override fun onCreate(dat: Bundle?) {
        super.onCreate(dat)
        setContentView(R.layout.activity_main)

        var tv = findViewById<Button>(R.id.button)
        tv.text = "학번 1791078"

        tv.setOnClickListener{
            tv.text="Test "+count
            count++
        }


    }

    override fun onDestroy(){
        super.onDestroy()
        println("destroyed")
    }
}