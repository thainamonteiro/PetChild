package com.example.petchild3

import android.app.ProgressDialog
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.view.View
import android.view.Window
import android.view.WindowManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.core.content.ContextCompat
import com.google.android.gms.common.api.GoogleApiClient
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_register.*
import kotlinx.android.synthetic.main.activity_tela__login.*

class RegisterActivity : AppCompatActivity(), View.OnClickListener {


    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        setUpListener()
    }

    private fun setUpListener() {
        btn_login_cadastrar.setOnClickListener(this)
    }

    override fun onClick(view: View?) {
        when (view) {
            btn_login_cadastrar -> {
                val intent = Intent(this, CreateAccountActivity::class.java)
                startActivity(intent)
            }

        }
    }


}

