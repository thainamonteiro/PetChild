package com.example.petchild3

import android.app.ProgressDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.google.firebase.database.DatabaseReference


import kotlinx.android.synthetic.main.activity_create_account.*
import com.google.firebase.auth.FirebaseAuth
import androidx.core.app.ComponentActivity
import androidx.core.app.ComponentActivity.ExtraData
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import android.text.TextUtils
import android.util.Log
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.database.FirebaseDatabase


class CreateAccountActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var mEditTextFirstName: EditText
    private lateinit var mEditTextLastName: EditText
    private lateinit var mEditTextFormTelephone: EditText
    private lateinit var mEditTextFormEmail: EditText
    private lateinit var mEditTextFormSenha: EditText
    private lateinit var mEditTextConfirmarSenha: EditText

    private lateinit var mProgressBar: ProgressDialog


    private lateinit var mDataBaseReference:DatabaseReference
    private lateinit var mDatabase: FirebaseDatabase
    private lateinit var mAuth: FirebaseAuth



    private val TAG = "CreateAccountActivity"


    //global variables
    private lateinit var firstName: String
    private lateinit var lastName: String
    private lateinit var email: String
    private lateinit var password: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_account)


        initialise()
        // Buttons
        setUpListener()


    }

    private fun initialise() {
        mEditTextFirstName = findViewById(R.id.editTextFormFirstName)
        mEditTextLastName = findViewById(R.id.editTextFormLastName)
        mEditTextFormTelephone = findViewById(R.id.editTextFormTelephone)
        mEditTextFormEmail = findViewById(R.id.editTextFormEmail)
        mEditTextFormSenha = findViewById(R.id.editTextFormSenha)
        mEditTextConfirmarSenha = findViewById(R.id.editTextConfirmarSenha)
        mProgressBar = ProgressDialog(this)

        mDatabase = FirebaseDatabase.getInstance()

        mDataBaseReference = mDatabase.reference.child("Users")
        mAuth = FirebaseAuth.getInstance()

        btnEnviarForm.setOnClickListener {
            createNewAccount()
        }
    }

    private fun createNewAccount() {
        firstName = mEditTextFirstName.text.toString()
        lastName = mEditTextLastName.text.toString()
        email = mEditTextFormEmail.text.toString()
        password = mEditTextFormSenha.text.toString()

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
                    Log.d(TAG, "createUserWithEmail:success")
                    val userId = mAuth.currentUser!!.uid
                    //Verify Email
                    verifyEmail()

                    //update user profile information
                    //add more plus information
                    val currentUserDb = mDataBaseReference.child(userId)
                    currentUserDb.child("firstName").setValue(firstName)
                    currentUserDb.child("lastName").setValue(lastName)
                    updateUserInfoAndUI()
                } else {
                    // If sign in fails, display a message to the user.
                    Log.w(TAG, "createUserWithEmail:failure", task.exception)
                    Toast.makeText(this@CreateAccountActivity, "Authentication failed.",
                        Toast.LENGTH_SHORT).show()
                }
            }
    }

    private fun updateUserInfoAndUI() {
        //start next activity
        val intent = Intent(this@CreateAccountActivity, MainActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        startActivity(intent)
    }

    private fun verifyEmail() {
        val mUser = mAuth.currentUser
        mUser!!.sendEmailVerification()
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    Toast.makeText(this@CreateAccountActivity,
                        "Verification email sent to " + mUser.getEmail(),
                        Toast.LENGTH_SHORT).show()
                } else {
                    Log.e(TAG, "sendEmailVerification", task.exception)
                    Toast.makeText(this@CreateAccountActivity,
                        "Failed to send verification email.",
                        Toast.LENGTH_SHORT).show()
                }
            }
    }


    private fun setUpListener() {

        btn_Cancelar.setOnClickListener(this)
        btnEnviarForm.setOnClickListener(this)
    }

    override fun onClick(view: View?) {
        when (view) {
            btnEnviarForm -> {

            }
            btn_Cancelar -> {
                val intent = Intent(this, RegisterActivity::class.java)
                startActivity(intent)
            }

        }
    }


}
