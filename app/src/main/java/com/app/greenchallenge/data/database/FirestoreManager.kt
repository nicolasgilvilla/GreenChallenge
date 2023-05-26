package com.app.greenchallenge.data.database

import com.data.datasource.FirestoreCallback
import com.google.firebase.firestore.FirebaseFirestore

class FirestoreManager {

    private val db = FirebaseFirestore.getInstance()
    private val collectionRef = db.collection("test")

    fun getDocuments(callback: FirestoreCallback, id: String) {
        val newColl = collectionRef.document(id)
        newColl.get()
            .addOnSuccessListener { querySnapshot ->
                callback.onSuccess(querySnapshot)
            }
            .addOnFailureListener { exception ->
                callback.onFailure(exception)
            }
    }
}