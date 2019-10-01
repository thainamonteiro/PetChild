package com.example.petchild3.UI

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.petchild3.R
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_forgot_password.*

class ForgotPasswordActivity : AppCompatActivity() {
    private val TAG = "ForgotPasswordActivity"

    private lateinit var etEmail: EditText
    private lateinit var btnSubmit: Button

    //Firebase references
    private lateinit var mAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forgot_password)
        initialise()
    }

    private fun initialise() {
        mAuth = FirebaseAuth.getInstance()
    }

    private  fun sendPasswordResetEmail(){
        val email = et_email.text.toString()
        if(!TextUtils.isEmpty(email)){
            mAuth.sendPasswordResetEmail(email)
                .addOnCompleteListener{
                    if (it.isSuccessful){
                        val message = "E-mail enviado"
                        Log.d(TAG,message)
                        Toast.makeText(this,message,Toast.LENGTH_LONG).show()
                        updateUI()
                    }else {
                        Log.w(TAG, it.exception!!.message!!)
                        Toast.makeText(this, "Nenhum usuário encontrado com este email.", Toast.LENGTH_SHORT).show()
                    }
                }
        }else {
            Toast.makeText(this, "Enter Email", Toast.LENGTH_SHORT).show()
        }

    }

    private fun updateUI() {
        val intent = Intent(this@ForgotPasswordActivity, RegisterActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        startActivity(intent)
    }


}