package com.example.petchild3.UI

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.example.petchild3.Database.DB_Controller
import com.example.petchild3.Model.Breed
import com.example.petchild3.Model.PetViewModel
import com.example.petchild3.Model.SearchParams
import com.example.petchild3.R
import com.twitter.sdk.android.core.models.Search

class PetFinder_Result : AppCompatActivity() {

    private var model = PetViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pet_finder__result)

        model = ViewModelProviders.of(this).get(PetViewModel::class.java)


    }

    fun findPets(){
        val searchParams = model.searchParams.value
        val breeds = model.breeds.value
        val result = mutableListOf<Breed>()

        if(searchParams!!.allergic){
            breeds!!.filter { it.Hypoallergenic }
            if(searchParams!!.children || searchParams!!.pets){
                result.forEach(){
                    it.Aggressiviness = it.Aggressiviness!!*2
                }
                if(searchParams!!.deficience)
                    result.forEach(){
                        it.Aggressiviness = it.Aggressiviness!!*2
                        it.Behavior = it.Behavior!!*2
                    }
            }
        }
    }
}
