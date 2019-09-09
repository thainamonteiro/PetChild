package com.example.petchild3.Database

import android.util.Log
import androidx.constraintlayout.widget.Constraints.TAG
import com.example.petchild3.Model.Breed
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.QuerySnapshot


object DB_Controller {

    val db = FirebaseFirestore.getInstance()

    fun getPets(){

        db.collection("Breed")
            .get()
            .addOnCompleteListener(OnCompleteListener<QuerySnapshot> { task ->
                if (task.isSuccessful) {
                    for (document in task.result!!) {
                        //val breed = document.toObject(Breed::class.java)
                        Log.d(TAG, document.id + " => " + document.data)
                    }
                } else {
                    Log.d(TAG, "Error getting documents: ", task.exception)
                }
            })
    }
}