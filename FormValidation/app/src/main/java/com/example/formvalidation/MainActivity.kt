package com.example.formvalidation

import android.content.Intent
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

        val login = findViewById<Button>(R.id.button)
        val clear = findViewById<Button>(R.id.button2)
        val username = findViewById<EditText>(R.id.editTextText)
        val pin = findViewById<EditText>(R.id.editTextText2)

        fun isValidUsername(username: String): Boolean {
            return username.matches(Regex("^[a-zA-Z0-9]+$"))
        }

        fun isValidPin ( pin: String) : Boolean {
            return pin.matches(Regex("^[0-9]+$"))
        }


        login.setOnClickListener {
            if(isValidUsername(username.text.toString()) && isValidPin(pin.text.toString())){
                val intent = Intent(this, SuccessPage::class.java)
                startActivity(intent)
            }
        }

        clear.setOnClickListener {
            username.text.clear()
            pin.text.clear()
        }
    }
}