package com.example.petchild3.UI

import android.app.ProgressDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.google.firebase.database.DatabaseReference


import kotlinx.android.synthetic.main.activity_create_account.*
import com.google.firebase.auth.FirebaseAuth
import android.text.TextUtils
import android.util.Log
import android.widget.EditText
import android.widget.Toast
import com.example.petchild3.Database.DB_Controller
import com.example.petchild3.R
import com.google.firebase.database.FirebaseDatabase


class CreateAccount : AppCompatActivity() {



    private lateinit var mProgressBar: ProgressDialog


    private lateinit var mDataBaseReference:DatabaseReference
    private lateinit var mDatabase: FirebaseDatabase
    private lateinit var mAuth: FirebaseAuth



    private val TAG = "CreateAccount"


    //global variables
    private lateinit var firstName: String
    private lateinit var lastName: String
    private lateinit var email: String
    private lateinit var password: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_account)


        mProgressBar = ProgressDialog(this)

        mDatabase = FirebaseDatabase.getInstance()

        mDataBaseReference = mDatabase.reference.child("Users")
        mAuth = FirebaseAuth.getInstance()


    }

    fun exitForm(view:View){
        val intent = Intent(this, SplashScreen::class.java)
        startActivity(intent)
    }

     fun saveForm(view: View) {
        firstName = etNome.text.toString()
        email = etEmail.text.toString()
        password = etSenha.text.toString()

        if (!TextUtils.isEmpty(firstName) && !TextUtils.isEmpty(lastName)
            && !TextUtils.isEmpty(email) && !TextUtils.isEmpty(password)) {
            Toast.makeText(this, "Informa;'oes preenchidas corretamente", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(this, "Enter all details", Toast.LENGTH_SHORT).show()
        }

        mProgressBar.setMessage("Registering User...")
        mProgressBar.show()

        mAuth
            .createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                mProgressBar.hide()
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information
                    Log.i(TAG, "createUserWithEmail:success")
                    val userId = mAuth.currentUser!!.uid
                    //Verify Email
                    verifyEmail()

                    //update user profile information
                    //add more plus information
                    val currentUserDb = mDataBaseReference.child(userId)
                    currentUserDb.child("firstName").setValue(firstName)
                    currentUserDb.child("lastName").setValue(lastName)
                    updateUserInfoAndUI()
                    DB_Controller.addUser(email,firstName)
                    val intent = Intent(this, PetFinder::class.java)
                    startActivity(intent)
                } else {
                    // If sign in fails, display a message to the user.
                    Log.i(TAG, "createUserWithEmail:failure", task.exception)
                    Toast.makeText(this@CreateAccount, "Authentication failed.",
                        Toast.LENGTH_SHORT).show()
                }
            }
    }

    private fun updateUserInfoAndUI() {
        //start next activity
        val intent = Intent(this@CreateAccount, SplashScreen::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        startActivity(intent)
    }

    private fun verifyEmail() {
        val mUser = mAuth.currentUser
        mUser!!.sendEmailVerification()
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    Toast.makeText(this@CreateAccount,
                        "Verification email sent to " + mUser.getEmail(),
                        Toast.LENGTH_SHORT).show()
                } else {
                    Log.e(TAG, "sendEmailVerification", task.exception)
                    Toast.makeText(this@CreateAccount,
                        "Failed to send verification email.",
                        Toast.LENGTH_SHORT).show()
                }
            }
    }







}
