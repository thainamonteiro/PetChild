package com.example.petchild3.UI

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.petchild3.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import kotlinx.android.synthetic.main.activity_login_with_email.*


class LoginWithEmail : AppCompatActivity(){


    private lateinit var mAuth : FirebaseAuth


    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_with_email)

        mAuth = FirebaseAuth.getInstance()


    }

    override fun onStart() {
        super.onStart()

        //FirebaseUser
    }

    fun signInWithEmail(view: View){

        var email = etEmail.text.toString()
        var password = etSenha.text.toString()
        mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(this) { task ->

            if (task.isSuccessful){


            }
        }

    }





}

