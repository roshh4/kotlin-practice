package com.example.sdcard

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.io.*

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

        val save = findViewById<Button>(R.id.save)
        val load = findViewById<Button>(R.id.load)
        val rollno = findViewById<EditText>(R.id.rollno)
        val name = findViewById<EditText>(R.id.name)
        val cgpa = findViewById<EditText>(R.id.cgpa)

        save.setOnClickListener {
            val r = rollno.text.toString()
            val n = name.text.toString()
            val c = cgpa.text.toString()

            val file = File(getExternalFilesDir(null), "student.txt")
            val outputStream = FileOutputStream(file, false)
            outputStream.write("$r, $n, $c".toByteArray())
            outputStream.close()

            rollno.text.clear()
            name.text.clear()
            cgpa.text.clear()

        }

        load.setOnClickListener {
            val file = File(getExternalFilesDir(null), "student.txt")
            val inputStream = FileInputStream(file)
            val inputStreamReader = InputStreamReader(inputStream)
            val BufferedReader = BufferedReader(inputStreamReader)
            val line : String = BufferedReader.readLine()
            val parts = line.split(",")
            rollno.setText(parts[0])
            name.setText(parts[1])
            cgpa.setText(parts[2])
            inputStream.close()
        }

    }
}