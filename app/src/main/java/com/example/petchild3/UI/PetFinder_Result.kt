package com.example.petchild3.UI

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.example.petchild3.Database.DB_Controller
import com.example.petchild3.Model.Breed
import com.example.petchild3.Model.PetViewModel
import com.example.petchild3.Model.SearchParams
import com.example.petchild3.R
import com.google.gson.Gson
import com.twitter.sdk.android.core.models.Search

class PetFinder_Result : AppCompatActivity() {

    private lateinit var model: PetViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pet_finder__result)

        model = ViewModelProviders.of(this).get(PetViewModel::class.java)

        findPets()
    }

    private fun findPets(){
        val searchParams = model.searchParams!!
        var breeds: List<Breed> = model.breeds


        breeds.forEach { b ->
            Log.d("BREED", b.Name+"\t"+b.Resume)
        }

        if(searchParams.allergic){
            breeds = breeds.filter { it.Hypoallergenic }
            calculateScore(breeds, searchParams)
        }else{
            calculateScore(breeds, searchParams)
        }
    }

    private fun calculateScore(breeds: List<Breed>, params: SearchParams) {
        var w = 2

        if(params.pets) w += 1
        if(params.children) w += 1
        if(params.deficience) w += 1

        breeds.forEach(){
            it.Score = ((it.MaxHeight!! * ((it.Aggressiviness!!*w) + (it.Behavior!!*w)))/5) - (params.time!! * params.area!!)
        }
    }
}
