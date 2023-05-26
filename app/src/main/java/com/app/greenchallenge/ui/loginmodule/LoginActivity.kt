package com.app.greenchallenge.ui.loginmodule

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.app.greenchallenge.R
import com.app.greenchallenge.databinding.ActivityLoginBinding
import com.app.greenchallenge.ui.common.dialog.GenerateDialogGeneric
import com.app.greenchallenge.ui.menumodule.MenuActivity

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        with(binding) {
            btnLogin.setOnClickListener {
                if (email.text.toString() == "jasantiagos@ufpso.edu.co" || email.text.toString()
                        .isEmpty() || password.text.toString().isEmpty()
                ) {
                    Toast.makeText(
                        this@LoginActivity,
                        "Datos incorrectos, verifique la informacion por favor.",
                        Toast.LENGTH_LONG
                    ).show()
                } else {
                    startActivity(Intent(this@LoginActivity, MenuActivity::class.java))
                    this@LoginActivity.finish()
                }
            }
            textForgotPassword.setOnClickListener {
                GenerateDialogGeneric.showDialogGeneric(
                    this@LoginActivity,
                    "",
                    R.string.forgot_password.toString(),
                    null
                )
            }
            textRegister.setOnClickListener {
                GenerateDialogGeneric.showDialogGeneric(
                    this@LoginActivity,
                    "", R.string.register.toString(), null
                )
            }
            btnGoogle.setOnClickListener {
                GenerateDialogGeneric.showDialogGeneric(
                    this@LoginActivity,
                    this@LoginActivity.getString(R.string.no_implement),
                    R.string.no_implement.toString(),
                    null
                )
            }
            btnFacebook.setOnClickListener {
                GenerateDialogGeneric.showDialogGeneric(
                    this@LoginActivity,
                    this@LoginActivity.getString(R.string.no_implement),
                    R.string.no_implement.toString(),
                    null
                )
            }
        }
    }


}
