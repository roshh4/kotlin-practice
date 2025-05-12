package com.example.calc

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
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

        val editText = findViewById<EditText>(R.id.editTextText)
        val button1 = findViewById<Button>(R.id.button1)
        val button2 = findViewById<Button>(R.id.button2)
        val button3 = findViewById<Button>(R.id.button3)
        val buttonadd = findViewById<Button>(R.id.buttonadd)
        val button4 = findViewById<Button>(R.id.button4)
        val button5 = findViewById<Button>(R.id.button5)
        val button6 = findViewById<Button>(R.id.button6)
        val buttonsub = findViewById<Button>(R.id.buttonsub)
        val button7 = findViewById<Button>(R.id.button7)
        val button8 = findViewById<Button>(R.id.button8)
        val button9 = findViewById<Button>(R.id.button9)
        val buttonmul = findViewById<Button>(R.id.buttonmul)
        val buttondec = findViewById<Button>(R.id.buttondec)
        val button0 = findViewById<Button>(R.id.button0)
        val button1eq = findViewById<Button>(R.id.button1eq)
        val buttondiv = findViewById<Button>(R.id.buttondiv)

        button1.setOnClickListener {
            editText.append("1")
        }
        button2.setOnClickListener {
            editText.append("2")
        }
        button3.setOnClickListener {
            editText.append("3")
        }
        buttonadd.setOnClickListener {
            editText.append("+")
        }
        button4.setOnClickListener {
            editText.append("4")
        }
        button5.setOnClickListener {
            editText.append("5")
        }
        button6.setOnClickListener {
            editText.append("6")
        }
        buttonsub.setOnClickListener {
            editText.append("-")
        }
        button7.setOnClickListener {
            editText.append("7")
        }
        button8.setOnClickListener {
            editText.append("8")
        }
        button9.setOnClickListener {
            editText.append("9")
        }
        buttonmul.setOnClickListener {
            editText.append("*")
        }
        buttondec.setOnClickListener {
            editText.append(".")
        }
        button0.setOnClickListener {
            editText.append("0")
        }
        button1eq.setOnClickListener {
            editText.append("=")
        }
        buttondiv.setOnClickListener {
            editText.append("/")
        }

    }
}