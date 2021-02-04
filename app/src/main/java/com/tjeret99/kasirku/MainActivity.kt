package com.tjeret99.kasirku


import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {


    private lateinit var button: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button = findViewById(R.id.LoginButton)
        button.setOnClickListener{

            intent = Intent(this, MenuActivity::class.java)
            startActivity(intent)
        }

    }


}