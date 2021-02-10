package com.tjeret99.kasirku

import android.graphics.Typeface
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.TypedValue
import android.view.Gravity
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_checkout.*


class CheckoutActivity : AppCompatActivity(){



    var checkoutName = ArrayList<String>()
    var checkoutPrice = ArrayList<String>()
    var arrayPrice = ArrayList<String>()
    lateinit var btn_total : Button
    lateinit var tv_total : TextView
    var abc = ArrayList<Int>()

    lateinit var layoutCheckout: LinearLayout
    public lateinit var total : TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_checkout)

        layoutCheckout = findViewById(R.id.parentOrder)

        val bundle = intent.extras
        val nameArray = bundle!!.getStringArrayList("nameArray")
        val priceArray = bundle!!.getStringArrayList("priceArray")


        total = findViewById(R.id.total)

        for (i in 0 until nameArray!!.size) {

            checkoutName.add(nameArray!![i])
            checkoutPrice.add(priceArray!![i])
            arrayPrice.add(priceArray!![i].replace("[^0-9]".toRegex(), ""))

        }

        checkout("test")


    }



    fun checkout(textName: String) {


        for (i in 0 until checkoutName.size){
            val parent = LinearLayout(this)
            val linear_parent = LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
            )
            parent.gravity = Gravity.CENTER
            linear_parent.gravity = Gravity.CENTER
            parent.setLayoutParams(linear_parent)
            parent.orientation = LinearLayout.HORIZONTAL
            parent.setLayoutParams(linear_parent)


            val parentfor = LinearLayout(this)
            val linear_parentfor = LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
            )
            parentfor.gravity = Gravity.CENTER
            linear_parentfor.gravity = Gravity.CENTER
            parentfor.orientation = LinearLayout.HORIZONTAL
            parentfor.setLayoutParams(linear_parentfor)
            parent.addView(parentfor)


            val product1 = LinearLayout(this)
            val linear_product1 = LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
            )
            product1.orientation = LinearLayout.VERTICAL
            product1.setBackgroundColor(getColor(R.color.colorSecondary))
            product1.setLayoutParams(linear_product1)
            parentfor.addView(product1)

            val txtName = TextView(this)
            val linear_txtname = LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
            )
            linear_txtname.setMargins(0, 0, 0, 0)
            txtName.setText(checkoutName[i])
            txtName.setBackgroundColor(getColor(R.color.white))
            txtName.gravity= Gravity.CENTER
            txtName.typeface = resources.getFont(R.font.nillandblack)
            txtName.typeface = Typeface.DEFAULT_BOLD       //Bold Text
            txtName.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 15F)
            txtName.setLayoutParams(linear_txtname)

            val txtPrice = TextView(this)
            val linear_txtprice = LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
            )

            txtPrice.id = R.id.tv_total
            linear_txtprice.setMargins(0, 0, 100, 0)
            txtPrice.setText(checkoutPrice[i])
            txtPrice.typeface = resources.getFont(R.font.nillandblack)
            txtPrice.setLayoutParams(linear_txtname)

            product1.removeAllViews()
            product1.addView(txtName)
            product1.addView(txtPrice)

            val txtCount = EditText(this)
            val linear_txtcount = LinearLayout.LayoutParams(200, LinearLayout.LayoutParams.WRAP_CONTENT)
            linear_txtcount.setMargins(200, 0, 0, 0)

            txtCount.id = R.id.et_jumlah+i
            Toast.makeText(this, txtCount.id.toString(), Toast.LENGTH_LONG).show()
            txtCount.typeface = resources.getFont(R.font.nillandblack)
            txtCount.textAlignment = View.TEXT_ALIGNMENT_VIEW_END
            txtCount.setLayoutParams(linear_txtcount)




            parentfor.addView(txtCount)




            layoutCheckout.addView(parent)
        }

        btn_total = findViewById(R.id.btn_total)
        tv_total = findViewById(R.id.total)
        btn_total.setOnClickListener {
            abc.removeAll(abc)

            for (i in 0 until checkoutPrice.size){
                var asd : EditText = findViewById(R.id.et_jumlah+i)
                var total : Int = asd.text.toString().toInt() * arrayPrice[i].toInt()
                abc.add(total)



            }


            var sum = 0
            for (element in abc) {
                sum += element

            }

            tv_total.setText(sum.toString())
            Toast.makeText(this, sum.toString()   , Toast.LENGTH_LONG).show()

        }

    }


}