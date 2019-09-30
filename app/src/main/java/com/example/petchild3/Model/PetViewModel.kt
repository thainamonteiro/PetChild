package com.example.petchild3.Model

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.petchild3.Database.DB_Controller
import java.util.*

class PetViewModel : ViewModel() {

    val breeds = MutableLiveData<List<Breed>>().apply {
        DB_Controller.getBreeds()
    }

    val postages = MutableLiveData<List<Postage>>().apply {
        DB_Controller.getPostages()
    }

    val searchParams = MutableLiveData<SearchParams>()


}