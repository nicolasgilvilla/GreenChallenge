package com.app.greenchallenge.common.dialog

import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.Window
import android.view.WindowManager
import androidx.appcompat.app.AlertDialog
import androidx.databinding.DataBindingUtil
import com.app.greenchallenge.R
import com.app.greenchallenge.databinding.DialogGenericBinding

object ShowDialogGeneric {

    fun createDialog(
        context: Context, data: DialogModel,
        positiveOnClick: (() -> Unit)?
    ): AlertDialog {
        val binding: DialogGenericBinding = DataBindingUtil.inflate(
            LayoutInflater.from(context), R.layout.dialog_generic, null,
            false
        )
        val alertDialog: AlertDialog = data.let {
            val builder = AlertDialog.Builder(context)
            builder.setView(binding.root)
            with(binding) {
                when (data.type) {
                    R.string.forgot_password.toString() -> {
                        title = context.getString(R.string.title_dialog_forgot)
                        tilUser.visibility = GONE
                        tilPassword.visibility = GONE
                        textViewTextInfo.visibility = GONE
                        textButton = context.getString(R.string.text_button_send)
                    }
                    R.string.register.toString() -> {
                        title = context.getString(R.string.title_dialog_register)
                        textViewTextInfo.visibility = GONE
                        textButton = context.getString(R.string.text_button_register)
                    }
                    R.string.text_btn_benefits.toString() -> {
                        title = context.getString(R.string.title_dialog_benefits)
                        textViewTextInfo.visibility = VISIBLE
                        textInfo = data.message
                        tilUser.visibility = GONE
                        tilPassword.visibility = GONE
                        tilEmail.visibility = GONE
                        textButton = context.getString(R.string.text_button_continue)
                    }
                    R.string.view_more.toString() -> {
                        title = context.getString(R.string.title_dialog_why)
                        textViewTextInfo.visibility = VISIBLE
                        textInfo = data.message
                        tilUser.visibility = GONE
                        tilPassword.visibility = GONE
                        tilEmail.visibility = GONE
                        textButton = context.getString(R.string.text_button_continue)
                    }
                    else -> {
                        title = context.getString(R.string.title_dialog_unknown)
                        textViewTextInfo.visibility = GONE
                        tilUser.visibility = GONE
                        tilPassword.visibility = GONE
                        tilEmail.visibility = GONE
                        textButton = context.getString(R.string.text_button_continue)
                    }
                }
            }
            builder.create()
        }

        val window: Window? = alertDialog.window

        window?.setGravity(Gravity.CENTER)
        window?.setLayout(
            WindowManager.LayoutParams.MATCH_PARENT,
            WindowManager.LayoutParams.MATCH_PARENT
        )
        window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        alertDialog.setCanceledOnTouchOutside(false)
        alertDialog.window?.attributes?.windowAnimations = R.style.PopDialogAnimation

        binding.btnDialog.setOnClickListener {
            alertDialog.dismiss()
            if (positiveOnClick != null) {
                positiveOnClick()
            }
        }

        binding.appCompatImageViewClose.setOnClickListener {
            alertDialog.dismiss()
            if (positiveOnClick != null) {
                positiveOnClick()
            }
        }

        return alertDialog
    }
}