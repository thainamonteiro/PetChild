package com.example.petchild3.Model

import com.google.firebase.firestore.DocumentReference

data class Breed (
    val Aggressiviness: Int? = null,
    val Behavior: Int? = null,
    val Hypoallergenic: Boolean = false,
    val Logevity: Int? = null,
    val Name: String? = null,
    val Postage: DocumentReference? = null,
    val Resume: String? = null
)