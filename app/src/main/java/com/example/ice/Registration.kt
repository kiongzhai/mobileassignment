package com.example.ice

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_registration.*

class Registration : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)

        btnDoneSignUp.setOnClickListener(){
            performRegister()

        }
        textViewHaveAccount.setOnClickListener(){
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }

    private fun performRegister(){

        val email = editTextEmailReg.text.toString()
        val password = editTextPasswordReg.text.toString()

        if(editTextPasswordReg.text.toString().isEmpty()){
            editTextPasswordReg.error = "Please enter your password"
            editTextPasswordReg.requestFocus()
            return
        }
        if(editTextEmailReg.text.toString().isEmpty()){
            editTextEmailReg.error = "Please enter an email"
            editTextEmailReg.requestFocus()
            return
        }

        FirebaseAuth.getInstance().createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener{
                if (!it.isSuccessful)


                return@addOnCompleteListener
                //else if successful
                Toast.makeText(this, "User Created", Toast.LENGTH_SHORT).show()
                saveUserToFirebaseDatabase()

                startActivity(Intent(this, MainActivity::class.java))
                finish()
            }
            .addOnFailureListener{
                Log.d("Registration", "Failed to create user : ${it.message}")
                Toast.makeText(this, "Failed to create user", Toast.LENGTH_SHORT).show()


            }
    }
    private fun saveUserToFirebaseDatabase() {


        val uid = FirebaseAuth.getInstance().uid ?: ""
        val ref = FirebaseDatabase.getInstance().getReference("/user/$uid")


        val user = User(uid, editTextFirstName.text.toString(), editTextSurname.text.toString(), editTextUsernameReg.text.toString(), editTextPasswordReg.text.toString(), editTextEmailReg.text.toString(), editTextMobileNum.text.toString())
        ref.setValue(user)
    }


}

class User(val uid : String ,val firstname : String, val surname : String, val username : String, val password : String,  val email : String, val mobileno : String )

