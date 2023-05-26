package com.app.greenchallenge.desordenado.common.dialog

import android.content.Context
import androidx.appcompat.app.AlertDialog
import com.domain.DialogModel

object GenerateDialogGeneric {
    private val alertsCollection = arrayListOf<AlertDialog>()

    fun showDialogGeneric(
        context: Context,
        message: String,
        type: String,
        positiveOnClick: (() -> Unit)?
    ) {
        val dataDialog = DialogModel(type = type, message = message)
        val dialog =
            ShowDialogGeneric.createDialog(context, dataDialog, positiveOnClick)
        dialog.show()
        addAlert(dialog)
    }

    private fun addAlert(alert: AlertDialog) {
        alertsCollection.add(alert)
    }
}