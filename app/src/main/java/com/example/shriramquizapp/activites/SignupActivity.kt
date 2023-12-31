package com.example.shriramquizapp.activites

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.shriramquizapp.R
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_signup.*

class SignupActivity : AppCompatActivity() {

    lateinit var firebaseAuth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)
        firebaseAuth= FirebaseAuth.getInstance()

        btnSignUp.setOnClickListener {
            signUpUser()
        }
        btnLogin.setOnClickListener{
            val intent=Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }


    }

    private fun signUpUser(){
        val email=etEmailAddress.text.toString();
        val password=etPassword.text.toString();
        val confirmPassword=etConfirmPassword.text.toString();
        if (email.isBlank() || password.isBlank() || confirmPassword.isBlank()) {
            Toast.makeText(this, "Email and Password can't be blank", Toast.LENGTH_SHORT).show()
            return
        }

        if (password != confirmPassword) {
            Toast.makeText(this, "Password and Confirm Password do not match", Toast.LENGTH_SHORT)
                .show()
            return
        }


        firebaseAuth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener(this){
                if(it.isSuccessful){

                    Toast.makeText(this,"New Registration Successful", Toast.LENGTH_SHORT).show()
                    val intent=Intent(this, LoginActivity::class.java)
                    startActivity(intent)
                    finish()
                }
                else{
                    Toast.makeText(this,"Error in user creation",Toast.LENGTH_SHORT).show()
                }
            }

    }

}