package com.example.petchild3.Model

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.petchild3.Database.DB_Controller

class PetViewModel : ViewModel() {

    var breeds = DB_Controller.getBreeds()
    var searchParams: SearchParams? = null

    init {
        Log.i("BREED_VM", "Iniciou")
    }

}