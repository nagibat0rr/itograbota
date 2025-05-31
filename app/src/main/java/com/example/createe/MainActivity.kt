package com.example.createe

import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.view.View
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private val colors = listOf(
        Color.parseColor("#800080"),
        Color.BLUE,
        Color.GREEN
    )
    private var currentColorIndex = 0

    private var currentNumber = 7

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val colorSquare = findViewById<View>(R.id.colorSquare)
        val buttonChangeColor = findViewById<Button>(R.id.buttonChangeColor)

        val editTextNumber = findViewById<EditText>(R.id.editTextNumber)
        val buttonChangeNumber = findViewById<Button>(R.id.buttonChangeNumber)

        colorSquare.setBackgroundColor(colors[currentColorIndex])

        buttonChangeColor.setOnClickListener {
            currentColorIndex = (currentColorIndex + 1) % colors.size
            colorSquare.setBackgroundColor(colors[currentColorIndex])
        }

        editTextNumber.setText(currentNumber.toString())

        buttonChangeNumber.setOnClickListener {
            currentNumber += 7
            if (currentNumber > 49) {
                currentNumber = 7
            }
            editTextNumber.setText(currentNumber.toString())
        }
    }
}