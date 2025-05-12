package com.example.buttonfontmanipulation

import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val increasefont = findViewById<Button>(R.id.increasefont)
        val changecolor = findViewById<Button>(R.id.changecolor)
        val changebackground = findViewById<Button>(R.id.changebackground)
        val edText = findViewById<TextView>(R.id.edText)


        increasefont.setOnClickListener {
            edText.setTextSize(40F)
        }

        changecolor.setOnClickListener{
            edText.setTextColor(Color.BLUE)
        }

        changebackground.setOnClickListener{
            edText.setBackgroundColor(Color.RED)
        }

    }
}