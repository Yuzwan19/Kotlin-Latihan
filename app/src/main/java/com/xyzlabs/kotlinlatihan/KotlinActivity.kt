package com.xyzlabs.kotlinlatihan

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_kotlin.*

class KotlinActivity : AppCompatActivity() {

    var qty = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kotlin)

        btn_order.setOnClickListener { view ->
            val nama = field_nama.text.toString()
            if (nama.isEmpty() || qty == 0) {
                Toast.makeText(this, "Please fill your order !", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Thanks for your order, $nama", Toast.LENGTH_LONG).show()
                orderC(qty, 5, nama)
            }
        }

        btn_plus.setOnClickListener { view ->
            increment()
        }

        btn_minus.setOnClickListener { view ->
            decrement()
        }
    }

    private fun increment() {
        if (qty == 10) {
            return
        }
        qty = qty + 1
        txt_quantity.text = "" + qty
    }

    private fun decrement() {
        if (qty == 0) {
            return
        }
        qty = qty - 1
        txt_quantity.text = "" + qty
    }

    private fun orderC(q: Int, price: Int, name: String): String {
        val Person = "Name : $name"
        val Quantity = "\nQuantity : " + q
        val total = "\nPrice : " + price * q + " $"
        val order = Person + Quantity + total
        txt_order.text = order

        return "No order"
    }
}
