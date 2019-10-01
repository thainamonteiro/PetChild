package com.example.petchild3.Database

import android.annotation.SuppressLint
import android.util.Log
import androidx.constraintlayout.widget.Constraints.TAG
import androidx.lifecycle.MutableLiveData
import com.example.petchild3.Model.Breed
import com.google.firebase.firestore.FirebaseFirestore


object DB_Controller {

    @SuppressLint("StaticFieldLeak")
    private val db = FirebaseFirestore.getInstance()

    fun getBreeds(): MutableList<Breed> {

        val breeds = mutableListOf<Breed>()
        val vmBreeds = MutableLiveData<List<Breed>>()

        db.collection("Breed")
            .get()
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    for (document in task.result!!) {
                        val breed = document.toObject(Breed::class.java)
                        Log.d(TAG, document.id + " => " + breed)
                        breeds.add(breed)
                    }
                    //vmBreeds.value = breeds
                } else {
                    Log.d(TAG, "Error getting documents: ", task.exception)
                }
            }
        return breeds
    }


    fun addUser(login:String, name: String){

        val users = db.collection("Users")
        val user = hashMapOf(
            "Name" to name,
            "Login" to login
        )
        users.add(user as Map<String, Any>)
            .addOnSuccessListener { documentReference ->
                Log.d(TAG, "DocumentSnapshot added with ID: ${documentReference.id}")
            }
            .addOnFailureListener { e ->
                Log.w(TAG, "Error adding document", e)
            }
    }
}