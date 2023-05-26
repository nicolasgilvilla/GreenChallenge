package com.app.greenchallenge.ui.menumodule.treemodule

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.app.greenchallenge.databinding.ActivityPaymentBinding

class PaymentActivity : AppCompatActivity() {

    private lateinit var mBinding: ActivityPaymentBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityPaymentBinding.inflate(layoutInflater)
        setContentView(mBinding.root)

        mBinding.btnPago.setOnClickListener {
            if (mBinding.ccv.text == null || mBinding.fecha.text == null || mBinding.numerotarjeta.text == null) {
                Toast.makeText(this, "Llenar todos los campos por favor.", Toast.LENGTH_SHORT)
                    .show()
            }
            mBinding.progress.visibility = View.VISIBLE
            Thread.sleep(5000)
            mBinding.progress.visibility = View.GONE
            Toast.makeText(this, "¡Pago exitoso!", Toast.LENGTH_SHORT).show()
            Thread.sleep(1000)
            startActivity(Intent(this, TreeActivity::class.java))
            finish()
        }
    }
}