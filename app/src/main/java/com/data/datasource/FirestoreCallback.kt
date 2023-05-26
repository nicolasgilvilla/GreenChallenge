package com.data.datasource

import com.google.firebase.firestore.DocumentSnapshot

interface FirestoreCallback {
    fun onFailure(exception: Exception)
    fun onSuccess(documents: DocumentSnapshot)
}