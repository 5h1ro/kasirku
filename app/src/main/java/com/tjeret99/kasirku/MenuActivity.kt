package com.tjeret99.kasirku

import android.graphics.Typeface
import android.os.Bundle
import android.print.PrintAttributes
import android.util.TypedValue
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.marginLeft
import androidx.core.view.marginStart
import androidx.core.view.marginTop


class MenuActivity : AppCompatActivity() {


    lateinit var layout: LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        layout = findViewById(R.id.parent)
        produk("test")

    }

    fun produk(textName:String) {
        val parent = LinearLayout(this)
        val linear_parent = LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT)
        parent.setLayoutParams(linear_parent)
        parent.orientation = LinearLayout.VERTICAL
        parent.gravity= Gravity.CENTER
        for (i in 0 until 3) {
            val product_pack = LinearLayout(this)
            val linear_product_pack = LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT)

            product_pack.setBackgroundColor(getColor(R.color.grey))
//        linear_product_pack.setMargins(20,20,20,0)
            product_pack.setLayoutParams(linear_product_pack)
            product_pack.layoutParams = LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT)
            product_pack.orientation = LinearLayout.HORIZONTAL

            parent.addView(product_pack)

            for (i in 0 until 4) {
                val product1 = LinearLayout(this)
                val linear_product1 = LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT)
                product1.setBackgroundColor(getColor(R.color.colorSecondary))
//            linear_product1.setMargins(50,0,50,0)
//        linear_product1.gravity= Gravity.CENTER
                product1.setLayoutParams(linear_product1)
                product1.layoutParams = LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT)
                product1.orientation = LinearLayout.VERTICAL
                product1.getLayoutParams().height = 500
                product1.getLayoutParams().width = 500

                product_pack.addView(product1)

                val tv_up = TextView(this)
                val linear_tv_up = LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT)
                linear_tv_up.setMargins(340, 30, 0, 0)
                tv_up.setLayoutParams(linear_tv_up)
                tv_up.setText("Rp. 7500")
                tv_up.typeface = Typeface.DEFAULT_BOLD       //Bold Text
                tv_up.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 17F)
                tv_up.setTextColor(ContextCompat.getColor(applicationContext, R.color.colorPrimary))

                val iv_product = ImageView(this)
                val linear_iv_product = LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT)
                linear_iv_product.setMargins(110, 15, 0, 0)
                iv_product.setImageResource(R.color.grey)
                iv_product.setLayoutParams(linear_iv_product)
                iv_product.getLayoutParams().height = 300
                iv_product.getLayoutParams().width = 300

                val tv_down = TextView(this)
                val linear_tv_down = LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT)
                linear_tv_down.setMargins(105, 15, 0, 0)
                tv_down.setLayoutParams(linear_tv_down)
                tv_down.typeface = Typeface.DEFAULT_BOLD       //Bold Text
                tv_down.setText("Bluder Original")
                tv_down.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 23F)
                tv_down.setTextColor(ContextCompat.getColor(applicationContext, R.color.colorPrimary))

                product1.removeAllViews()
                product1.addView(tv_up)
                product1.addView(iv_product)
                product1.addView(tv_down)
            }
        }

        layout.addView(parent)
    }
}