package com.example.ice

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_recommendation.*

class Recommendation : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recommendation)



        btnHC1.setOnClickListener(){
            val intent = Intent(this, Comparison::class.java)
            startActivity(intent)
            overridePendingTransition(0, 0);
        }

        btnCC1.setOnClickListener(){
            val intent = Intent(this, Check::class.java)
            startActivity(intent)
            overridePendingTransition(0, 0);
        }


        }



    }
