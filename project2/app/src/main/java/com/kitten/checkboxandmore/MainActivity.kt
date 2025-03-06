package com.kitten.checkboxandmore

import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.RadioButton
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    lateinit var result : TextView
    lateinit var male : CheckBox
    lateinit var femail : CheckBox

    lateinit var green : RadioButton
    lateinit var red : RadioButton
    lateinit var yellow : RadioButton
    lateinit var changeColor : Button
    lateinit var layout : ConstraintLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        result = findViewById(R.id.TextViewResult)
        male = findViewById(R.id.CheckBoxMale)
        femail = findViewById(R.id.checkBoxFemale)

        green = findViewById(R.id.green)
        yellow = findViewById(R.id.yellow)
        red = findViewById(R.id.red)

        changeColor = findViewById(R.id.buttonChangeColor)
        layout = findViewById(R.id.constraintLayout)

        male.setOnClickListener{
            if(male.isChecked) {
                result.setText("Your gender is male")
                femail.isChecked = false
            }
            else{
                result.setText("What is your gender?")
            }
        }
        femail.setOnClickListener{
            if(femail.isChecked){
                result.text = "Your gender is female"
                male.isChecked = false
            }
            else{
                result.text = "What is your gender?"
            }
        }
        changeColor.setOnClickListener{
            if(red.isChecked){
                layout.setBackgroundColor(Color.RED)
            }
            else if(green.isChecked){
                layout.setBackgroundColor(Color.GREEN)
            }
            else if(yellow.isChecked){
                layout.setBackgroundColor(Color.YELLOW)
            }
        }

    }
}