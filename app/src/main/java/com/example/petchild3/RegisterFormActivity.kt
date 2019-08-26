package com.example.petchild3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_register.*
import kotlinx.android.synthetic.main.activity_register_form.*

class RegisterFormActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register_form)

        setUpListener()
    }



    private fun setUpListener() {

        btn_Cancelar.setOnClickListener(this)
    }

    override fun onClick(view: View?) {
        when(view){
            btn_logInTo ->{

            }
            btn_Cancelar ->{
                val intent = Intent(this, RegisterActivity::class.java)
                startActivity(intent)

            }

        }
    }
}
