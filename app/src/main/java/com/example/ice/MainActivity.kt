package com.example.ice

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_registration.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        tvSignUp.setOnClickListener() {
            val intent = Intent(this, Registration::class.java)
            startActivity(intent)

        }



        buttonLogin.setOnClickListener() {

            val intent = Intent(this, Recommendation::class.java)
            startActivity(intent)

            val email = editTextEmailLogin.text.toString()
            val password = editTextPasswordReg.text.toString()




            FirebaseAuth.getInstance().signInWithEmailAndPassword(email, password)
                .addOnCompleteListener {
                    if (it.isSuccessful) {

                        Toast.makeText(this, "Logging in!", Toast.LENGTH_SHORT).show()
                    }

                }
                .addOnFailureListener{
                    Toast.makeText(this, "Invalid Email/Password!", Toast.LENGTH_SHORT).show()
                }

        }


    }
}
