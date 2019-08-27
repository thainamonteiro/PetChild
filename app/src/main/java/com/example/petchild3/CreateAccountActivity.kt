package com.example.petchild3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View


import kotlinx.android.synthetic.main.activity_create_account.*

class CreateAccountActivity : AppCompatActivity(), View.OnClickListener {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_account)

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
