package com.kitten.checkboxandmore

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.CheckBox
import android.widget.CompoundButton
import android.widget.ImageView
import android.widget.RadioButton
import android.widget.Spinner
import android.widget.TextView
import android.widget.ToggleButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.transition.Visibility

class MainActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {

    lateinit var result : TextView
    lateinit var male : CheckBox
    lateinit var femail : CheckBox

    lateinit var green : RadioButton
    lateinit var red : RadioButton
    lateinit var yellow : RadioButton
    lateinit var changeColor : Button
    lateinit var layout : ConstraintLayout

    lateinit var imageViewMain : ImageView
    lateinit var hideImage : ToggleButton

    lateinit var spinnerChoice :  Spinner
    lateinit var textViewChoice : TextView

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

        hideImage = findViewById(R.id.toggleButtonHideImage)
        imageViewMain = findViewById(R.id.imageViewMain)

        spinnerChoice = findViewById(R.id.spinnerChoice)
        textViewChoice = findViewById(R.id.textViewChoice)

        male.setOnClickListener {
            if (male.isChecked) {
                result.setText("Your gender is male")
                femail.isChecked = false
            } else {
                result.setText("What is your gender?")
            }
        }
        femail.setOnClickListener {
            if (femail.isChecked) {
                result.text = "Your gender is female"
                male.isChecked = false
            } else {
                result.text = "What is your gender?"
            }
        }
        changeColor.setOnClickListener {
            if (red.isChecked) {
                layout.setBackgroundColor(Color.RED)
            } else if (green.isChecked) {
                layout.setBackgroundColor(Color.GREEN)
            } else if (yellow.isChecked) {
                layout.setBackgroundColor(Color.YELLOW)
            }
        }

        hideImage.setOnCheckedChangeListener { compoundButton, isChecked ->
            if (isChecked) {
                imageViewMain.visibility = View.INVISIBLE
            } else {
                imageViewMain.visibility = View.VISIBLE
            }
        }
        spinnerChoice.onItemSelectedListener = this
        var arrayAdapter = ArrayAdapter.createFromResource(
            this,
            R.array.choice,
            android.R.layout.simple_spinner_item
        )
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        spinnerChoice.adapter = arrayAdapter
    }

    override fun onItemSelected(
        parent: AdapterView<*>?,
        view: View?,
        position: Int,
        id: Long
    ) {
        var choice = parent!!.getItemAtPosition(position).toString()
        textViewChoice.text = "Your choice is to...$choice"
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {
        TODO("Not yet implemented")
    }
}