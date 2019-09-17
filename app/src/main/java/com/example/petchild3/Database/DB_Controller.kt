package com.example.petchild3.Database

import android.annotation.SuppressLint
import android.util.Log
import androidx.constraintlayout.widget.Constraints.TAG
import androidx.lifecycle.MutableLiveData
import com.example.petchild3.Model.Breed
import com.example.petchild3.Model.PetViewModel
import com.example.petchild3.Model.Postage
import com.google.firebase.firestore.FirebaseFirestore
import java.util.jar.Attributes


object DB_Controller {

    @SuppressLint("StaticFieldLeak")
    private val db = FirebaseFirestore.getInstance()

    fun getBreeds() {

        val breeds = mutableListOf<Breed>()
        var vmBreeds = MutableLiveData<List<Breed>>()

        db.collection("Breed")
            .get()
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    for (document in task.result!!) {
                        val breed = document.toObject(Breed::class.java)
                        Log.d(TAG, document.id + " => " + breed)
                        breeds.add(breed)
                    }
                    vmBreeds.value = breeds
                } else {
                    Log.d(TAG, "Error getting documents: ", task.exception)
                }
            }
    }

    fun getPostages() {
        val postages = mutableListOf<Postage>()
        var vmPostage = MutableLiveData<List<Postage>>()

        db.collection("Postage")
            .get()
            .addOnCompleteListener { task ->
                if(task.isSuccessful){
                    for (document in task.result!!){
                        val postage = document.toObject(Postage::class.java)
                        postages.add(postage)
                        Log.d(TAG,document.id+" => "+postage)
                    }
                    vmPostage.value = postages
                }else{
                    Log.d(TAG, "Error getting documents: ", task.exception)
                }
            }
    }

    fun getPostageById(id: String?): Postage? {
        var postage: Postage? = null

        if (id != null) {
            db.collection("Postage")
                .document(id)
                .get()
                .addOnSuccessListener { document ->
                    if(document != null){
                        postage = document.toObject(Postage::class.java)!!
                        Log.d(TAG, document.id + " => " + postage)
                    }
                }
                .addOnFailureListener{exception ->
                    Log.w(TAG, "Error writing document", exception)
                }
        }

        return postage
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