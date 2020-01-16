package com.example.ice

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    public lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        auth = FirebaseAuth.getInstance()



        tvSignUp.setOnClickListener() {
            val intent = Intent(this, Registration::class.java)
            startActivity(intent)

        }



        buttonLogin.setOnClickListener() {
            startSignin()

        }
    }

    public override fun onStart() {
        super.onStart()
        // Check if user is signed in (non-null) and update UI accordingly.
        val currentUser = auth.currentUser
        updateUI(currentUser)
    }

    private fun updateUI(currentUser: FirebaseUser?){
        if(currentUser != null){
            val intent = Intent(this, Recommendation::class.java)
            startActivity(intent)
        } else {
            Toast.makeText(this, "Login Failed!", Toast.LENGTH_SHORT).show()
        }
    }

    private fun startSignin() {
        val email = editTextEmailLogin.text.toString()
        val password = editTextPasswordLogin.text.toString()

        FirebaseAuth.getInstance().signInWithEmailAndPassword(email, password)
            .addOnCompleteListener {
                if (!it.isSuccessful) {

                    Toast.makeText(this, "Logging in!", Toast.LENGTH_SHORT).show()

                    val user = auth.currentUser
                    updateUI(user)
                } else {
                    Toast.makeText(this, "Login Failed!", Toast.LENGTH_SHORT).show()
                    updateUI(null)
                }

            }

            .addOnFailureListener{
                Toast.makeText(this, "Invalid Email/Password!", Toast.LENGTH_SHORT).show()
            }
    }

}













