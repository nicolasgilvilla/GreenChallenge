package com.app.greenchallenge.common.dialog

import android.content.Context
import androidx.appcompat.app.AlertDialog

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
        this.addAlert(dialog)
    }

    private fun addAlert(alert: AlertDialog) {
        this.alertsCollection.add(alert)
    }
}