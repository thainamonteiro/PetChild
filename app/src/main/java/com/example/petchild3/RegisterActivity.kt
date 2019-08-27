package com.example.petchild3

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.Window
import android.view.WindowManager
import androidx.annotation.RequiresApi
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : AppCompatActivity(), View.OnClickListener {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP)
            window.setStartusBarColorTo(R.color.Background_Apk)

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
               val intent = Intent(this, CreateAccountActivity::class.java)
               startActivity(intent)

           }

       }
    }

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    fun Window.setStartusBarColorTo(color:Int){
        this.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
        this.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
        this.statusBarColor = ContextCompat.getColor(baseContext,color)

    }
}
