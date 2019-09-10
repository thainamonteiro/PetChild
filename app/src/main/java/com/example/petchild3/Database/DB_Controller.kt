package com.example.petchild3.Database

import android.util.Log
import androidx.constraintlayout.widget.Constraints.TAG
import com.example.petchild3.Model.Breed
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.QuerySnapshot


object DB_Controller {

    val db = FirebaseFirestore.getInstance()

    fun getBreeds(): MutableList<Breed> {

        val breeds = mutableListOf<Breed>()

        db.collection("Breed")
            .get()
            .addOnCompleteListener(OnCompleteListener<QuerySnapshot> { task ->
                if (task.isSuccessful) {
                    for (document in task.result!!) {
                        val breed = document.toObject(Breed::class.java)
                        breeds.add(breed)
                        Log.d(TAG, document.id + " => " + breed)
                        //Log.d(TAG, document.id + " => " + document.data)
                    }
                } else {
                    Log.d(TAG, "Error getting documents: ", task.exception)
                }
            })

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