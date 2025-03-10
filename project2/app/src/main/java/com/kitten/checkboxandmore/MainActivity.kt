package com.kitten.checkboxandmore

import android.graphics.Color
import android.os.Bundle
import android.text.Layout
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.RadioButton
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import android.widget.ToggleButton
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.content.res.AppCompatResources
import androidx.constraintlayout.widget.ConstraintLayout
import com.google.android.material.appbar.MaterialToolbar

class MainActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {

    lateinit var result : TextView
    lateinit var male : CheckBox
    lateinit var femail : CheckBox

    lateinit var green : RadioButton
    lateinit var red : RadioButton
    lateinit var yellow : RadioButton
    lateinit var changeColor : Button
    lateinit var layout : ConstraintLayout
    lateinit var mainId : ConstraintLayout

    lateinit var imageViewMain : ImageView
    lateinit var hideImage : ToggleButton

    lateinit var spinnerChoice :  Spinner
    lateinit var textViewChoice : TextView

    lateinit var toolBar : MaterialToolbar

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
        mainId = findViewById(R.id.mainId)

        hideImage = findViewById(R.id.toggleButtonHideImage)
        imageViewMain = findViewById(R.id.imageViewMain)

        spinnerChoice = findViewById(R.id.spinnerChoice)
        textViewChoice = findViewById(R.id.textViewChoice)

        toolBar = findViewById(R.id.toolBar)
        toolBar.overflowIcon = AppCompatResources.getDrawable(this, R.drawable.baseline_more_vert_24)

        toolBar.setNavigationOnClickListener{
            Toast.makeText(applicationContext, "Navigation Icon is clicked", Toast.LENGTH_SHORT).show()
        }

        toolBar.setOnMenuItemClickListener{ item ->

           when(item.itemId){
               R.id.share -> Toast.makeText(applicationContext, "Share Icon is clicked", Toast.LENGTH_SHORT).show()
               R.id.edit -> Toast.makeText(applicationContext, "Edit Icon is clicked", Toast.LENGTH_SHORT).show()
               R.id.settings -> Toast.makeText(applicationContext, "Settings Icon clicked",  Toast.LENGTH_SHORT).show()
               else -> Toast.makeText(applicationContext, "Sign out Icon is clicked", Toast.LENGTH_SHORT).show()
           }
            return@setOnMenuItemClickListener true
        }
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
                mainId.setBackgroundColor(Color.RED)
            } else if (green.isChecked) {
                layout.setBackgroundColor(Color.GREEN)
                mainId.setBackgroundColor(Color.GREEN)
            } else if (yellow.isChecked) {
                layout.setBackgroundColor(Color.YELLOW)
                mainId.setBackgroundColor(Color.YELLOW)
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