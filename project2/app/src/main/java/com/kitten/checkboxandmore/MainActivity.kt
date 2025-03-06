package com.kitten.checkboxandmore

import android.os.Bundle
import android.widget.CheckBox
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    lateinit var result : TextView
    lateinit var male : CheckBox
    lateinit var femail : CheckBox


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        result = findViewById(R.id.TextViewResult)
        male = findViewById(R.id.CheckBoxMale)
        femail = findViewById(R.id.checkBoxFemale)

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

    }
}