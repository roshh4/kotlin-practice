package com.example.sendsms

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.telephony.SmsManager
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
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

        val sendsms = findViewById<Button>(R.id.button)
        val phno = findViewById<EditText>(R.id.editTextText)
        val msg = findViewById<EditText>(R.id.editTextText2)

        ActivityCompat.requestPermissions(this, arrayOf(android.Manifest.permission.SEND_SMS),1000)

        sendsms.setOnClickListener{
            val phno = phno.text.toString()
            val msg = msg.text.toString()
            val smsManager: SmsManager = SmsManager.getDefault()
            smsManager.sendTextMessage(phno, null, msg, null, null)
            Toast.makeText(this, "Message Sent", Toast.LENGTH_SHORT).show()
        }

    }
}