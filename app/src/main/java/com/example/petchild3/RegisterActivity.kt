package com.example.petchild3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_register.*
import kotlinx.android.synthetic.main.activity_tela__login.*

class RegisterActivity : AppCompatActivity(), View.OnClickListener {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)


        setUpListener()
    }



    private fun setUpListener() {

        btn_login_cadastrar.setOnClickListener(this)
    }

    override fun onClick(view: View?) {
       when(view){
           btn_logInTo ->{

           }
           btn_login_cadastrar ->{
               val intent = Intent(this, RegisterFormActivity::class.java)
               startActivity(intent)

           }

       }
    }
}
