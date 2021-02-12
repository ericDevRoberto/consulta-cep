package com.project.consultcep.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.project.consultcep.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        actionBar?.hide()
    }
}