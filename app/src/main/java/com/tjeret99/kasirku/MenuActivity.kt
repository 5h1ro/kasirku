package com.tjeret99.kasirku

import android.content.Intent
import android.graphics.Typeface
import android.os.Bundle
import android.util.Log
import android.util.TypedValue
import android.view.Gravity
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import org.json.JSONException
import org.json.JSONObject
import java.util.*
import kotlin.collections.ArrayList


class MenuActivity : AppCompatActivity() {


    lateinit var layout: LinearLayout
    public lateinit var priceAPI: String
    public lateinit var nameAPI: String
    public lateinit var hasil: String
    var listName = ArrayList<String>()
    var listPrice = ArrayList<String>()
    public lateinit var mQueue: RequestQueue
//    val url = "http://192.168.9.111:8000/api/product"
    val url = "https://pajuts.000webhostapp.com/produk.php"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        layout = findViewById(R.id.parent)

        mQueue = Volley.newRequestQueue(this)
        jsonParse()

    }


    fun jsonParse() {
        val request = StringRequest(Request.Method.GET, url, { response ->
            try {
                val jsonObject = JSONObject(response)
                val a = jsonObject.getJSONArray("data")
                for (i in 0 until a.length()) {
                    val c = a.getJSONObject(i)

                    nameAPI = c.getString("name")
                    priceAPI = c.getString("price")

                    listName.add(nameAPI)
                    listPrice.add(priceAPI)

                }
                produk("test")
            } catch (e: JSONException) {
                e.printStackTrace()
            }
        }) { error ->
            Log.i("LOG", "Volley Error : " + error.message)
            error.printStackTrace() }
        mQueue.add(request)
    }

    fun success() {
        if (hasil == "Berhasil Login") {
            Toast.makeText(this, "Success", Toast.LENGTH_LONG).show()
        }
    }

    fun error() {
        if (hasil == "Email atau Password Salah") {
            Toast.makeText(this, "NPM atau Password anda salah", Toast.LENGTH_LONG).show()
        }
    }

    fun produk(textName: String) {


        for (i in 0 until listName.size){
            val parent = LinearLayout(this)
            val linear_parent = LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT)
            parent.gravity = Gravity.CENTER
            linear_parent.gravity = Gravity.CENTER
            parent.setLayoutParams(linear_parent)
            parent.orientation = LinearLayout.HORIZONTAL
            parent.setLayoutParams(linear_parent)
            parent.setOnClickListener {
                val intent = Intent(this, BuyActivity::class.java)
                intent.putExtra("name", listName[i])
                intent.putExtra("price", listPrice[i])
                startActivity(intent)
            }

            val product_pack = LinearLayout(this)
            val linear_product_pack = LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT)
            product_pack.gravity = Gravity.CENTER
            linear_product_pack.gravity = Gravity.CENTER
            product_pack.orientation = LinearLayout.HORIZONTAL
            product_pack.setLayoutParams(linear_product_pack)

            parent.addView(product_pack)


            val product1 = LinearLayout(this)
            val linear_product1 = LinearLayout.LayoutParams(500, 500)
            linear_product1.setMargins(50, 50, 50, 50)
            product1.gravity = Gravity.CENTER
            product1.setBackgroundColor(getColor(R.color.colorSecondary))
            product1.orientation = LinearLayout.VERTICAL
            product1.setLayoutParams(linear_product1)

            product_pack.addView(product1)

            val tv_up = TextView(this)
            val linear_tv_up = LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT)
            linear_tv_up.setMargins(150, 0, 0, 20)
            tv_up.setText(listPrice[i])
            tv_up.gravity=Gravity.CENTER
            tv_up.typeface = resources.getFont(R.font.heycomic)
            tv_up.typeface = Typeface.DEFAULT_BOLD       //Bold Text
            tv_up.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 17F)
            tv_up.setTextColor(ContextCompat.getColor(applicationContext, R.color.colorPrimary))
            tv_up.setLayoutParams(linear_tv_up)

            val iv_product = ImageView(this)
            val linear_iv_product = LinearLayout.LayoutParams(300, 300)
            linear_iv_product.gravity = Gravity.CENTER
            iv_product.setImageResource(R.color.grey)
            iv_product.setLayoutParams(linear_iv_product)

            val tv_down = TextView(this)
            val linear_tv_down = LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT)
            linear_tv_down.gravity = Gravity.CENTER
            linear_tv_down.setMargins(0, 20, 0, 0)
            tv_down.gravity=Gravity.CENTER
            tv_down.typeface = resources.getFont(R.font.heycomic)
            tv_down.typeface = Typeface.DEFAULT_BOLD       //Bold Text
            tv_down.setText(listName[i])
            tv_down.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 23F)
            tv_down.setTextColor(ContextCompat.getColor(applicationContext, R.color.colorPrimary))
            tv_down.setLayoutParams(linear_tv_down)

            product1.removeAllViews()
            product1.addView(tv_up)
            product1.addView(iv_product)
            product1.addView(tv_down)


            layout.addView(parent)
        }


    }

}