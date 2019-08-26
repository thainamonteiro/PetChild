package com.example.petchild3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_tela__login.*

class TelaDeLogin : AppCompatActivity(), View.OnClickListener {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela__login)

        setUpListener()
    }


    private fun setUpListener() {
        btn_login_email.setOnClickListener(this)
    }

    override fun onClick(view: View?) {
        when(view){
            btn_login_email ->{
                val intent = Intent(this, RegisterActivity::class.java)
                startActivity(intent)
            }
        }
    }
}