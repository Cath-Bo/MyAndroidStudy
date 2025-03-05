package com.kitten.buttons

import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    lateinit var textHello : TextView
    lateinit var buttonHello : Button
    lateinit var buttonBye : Button
    lateinit var buttonOk : Button
    lateinit var editTextName : EditText
    lateinit var editTextPassword: EditText
    lateinit var image : ImageView
    lateinit var name : String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textHello = findViewById(R.id.textHello)
        buttonHello = findViewById(R.id.buttonHello)
        buttonBye = findViewById(R.id.buttonBye)

        buttonHello.setOnClickListener{
            textHello.setBackgroundColor(Color.GREEN)
            name = editTextName.text.toString()
            textHello.setText("hello, $name")
            buttonBye.setBackgroundColor(Color.YELLOW)
           // buttonHello.setText("Click me!")
            //buttonHello.setBackgroundColor(Color.RED)
            buttonBye.setText("click me!!")
        }

        buttonBye.setOnClickListener{
            name = editTextName.text.toString()
            textHello.setText("Bye, $name")
            buttonBye.setText("Bye-bye")
            buttonHello.setText("Click me!!")
            buttonHello.setBackgroundColor(Color.parseColor("#8BC34A"))
            textHello.setBackgroundColor(Color.parseColor("#8BC34A"))
        }

        buttonOk = findViewById(R.id.buttonOk)
        editTextName = findViewById(R.id.editTextName)
        editTextPassword = findViewById(R.id.editTextPassword)
        image = findViewById(R.id.imageViewExample)

        buttonOk.setOnClickListener{
            image.setImageResource(R.drawable.image_for_my_pet_proj_2)

        }


    }
}