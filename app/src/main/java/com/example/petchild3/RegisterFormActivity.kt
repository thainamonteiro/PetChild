package com.example.petchild3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser


import kotlinx.android.synthetic.main.activity_register_form.*

class RegisterFormActivity : AppCompatActivity(), View.OnClickListener {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register_form)

        // Buttons
        setUpListener()




    }


    // [START on_start_check_user]
    public override fun onStart() {
        super.onStart()
        // Check if user is signed in (non-null) and update UI accordingly.

    }
    // [END on_start_check_user]



    private fun setUpListener() {

        btn_Cancelar.setOnClickListener(this)
        btnEnviarForm.setOnClickListener(this)
    }

    override fun onClick(view: View?) {
        when(view){
            btnEnviarForm ->{

            }
            btn_Cancelar ->{
                val intent = Intent(this, RegisterActivity::class.java)
                startActivity(intent)
            }

        }
    }




}
