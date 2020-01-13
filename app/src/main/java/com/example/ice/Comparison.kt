package com.example.ice

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_comparison.*

class Comparison : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_comparison)

        btnRecommendation2.setOnClickListener(){
            val intent = Intent(this, Recommendation::class.java)
            startActivity(intent)
            overridePendingTransition(0, 0);
        }

        btnCC2.setOnClickListener(){
            val intent = Intent(this, Check::class.java)
            startActivity(intent)
            overridePendingTransition(0, 0);
        }
    }
}
