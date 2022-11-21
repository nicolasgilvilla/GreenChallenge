package com.app.greenchallenge.loginmodule

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.app.greenchallenge.databinding.ActivityLoginBinding
import com.app.greenchallenge.menumodule.MenuActivity

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        with(binding) {
            btnLogin.setOnClickListener {
                if (name.text.toString() == "nicolas" && password.text.toString() == "123") {
                    startActivity(Intent(this@LoginActivity, MenuActivity::class.java))
                    this@LoginActivity.finish()
                } else {
                    Toast.makeText(
                        this@LoginActivity,
                        "Datos incorrectos, verifique la informacion por favor.",
                        Toast.LENGTH_LONG
                    ).show()
                }
            }
        }
    }
}
