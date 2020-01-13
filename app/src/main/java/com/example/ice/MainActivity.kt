package com.example.ice

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_registration.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvSignUp.setOnClickListener(){
            val intent = Intent(this, Registration::class.java)
            startActivity(intent)

        }



        buttonLogin.setOnClickListener(){
            val intent = Intent(this, Recommendation::class.java)
            startActivity(intent)

        }

    }
}
