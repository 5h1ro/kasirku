package com.tjeret99.kasirku

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.text.NumberFormat
import java.util.*

class BuyActivity : AppCompatActivity() {


    public lateinit var nameProduct : TextView
    public lateinit var priceProduct : TextView
    public lateinit var jumlah : TextView
    public lateinit var pesanan : EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_buy)

        nameProduct = findViewById(R.id.nameProduct)
        priceProduct = findViewById(R.id.priceProduct)
        jumlah = findViewById(R.id.jumlah)
        pesanan = findViewById(R.id.pesanan)
//        priceProduct = findViewById(R.id.priceProduct)


        val extras = intent.extras
        val name = extras!!.getString("name")
        val price = extras!!.getString("price")
        val localeID = Locale("in", "ID")
        val format: NumberFormat = NumberFormat.getCurrencyInstance(localeID)

        pesanan.addTextChangedListener(object : TextWatcher {

            override fun afterTextChanged(s: Editable) {}

            override fun beforeTextChanged(
                    s: CharSequence, start: Int,
                    count: Int, after: Int,
            ) {
            }

            override fun onTextChanged(
                    s: CharSequence, start: Int,
                    before: Int, count: Int,
            ) {

                var res = price!!.replace("[^0-9]".toRegex(), "")
                val number: Int = s.toString().toInt() * res.toInt()

                jumlah.setText(format.format(number).toString())
            }
        })


        nameProduct.setText(name)
        priceProduct.setText(price)


//        val bundle = intent.extras
//        if(intent.extras != null)
//        {
//
//            nameProduct.setText(bundle?.getString("nameProduct"))
////            priceProduct.setText(bundle?.getString("priceProduct"))
//        }else{
//            nameProduct.setText(intent.getStringExtra("nameProduct"))
////            priceProduct.setText(intent.getStringExtra("priceProduct"))
//        }


    }
}