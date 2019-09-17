package com.example.petchild3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.constraintlayout.widget.Constraints
import androidx.core.view.get
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.lifecycle.ViewModelStore
import com.example.petchild3.Database.DB_Controller
import com.example.petchild3.Model.Breed
import com.example.petchild3.Model.PetViewModel
import com.example.petchild3.R
import kotlinx.android.synthetic.main.activity_pet_finder.*

class PetFinder : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pet_finder)

        val model = ViewModelProviders.of(this).get(PetViewModel::class.java)
    }

    fun getSerchParams(){
        val age = ageEditText.text.toString()
    }
}