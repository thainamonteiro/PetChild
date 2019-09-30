package com.example.petchild3.UI

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.petchild3.R
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : AppCompatActivity(), View.OnClickListener {


    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        setUpListener()
    }

    private fun setUpListener() {
        btn_login_cadastrar.setOnClickListener(this)
        tv_forgot_password.setOnClickListener(this)
    }

    override fun onClick(view: View?) {
        when (view) {
            btn_login_cadastrar -> {
                val intent = Intent(this, CreateAccountActivity::class.java)
                startActivity(intent)
            }
            tv_forgot_password ->{
                val intent = Intent(this, ForgotPasswordActivity::class.java)
                startActivity(intent)
            }

        }
    }


}

