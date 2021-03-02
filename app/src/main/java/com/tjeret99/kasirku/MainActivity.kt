package com.tjeret99.kasirku


import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.util.Patterns
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import butterknife.BindView
import butterknife.ButterKnife
import butterknife.OnClick
import com.basgeekball.awesomevalidation.AwesomeValidation
import com.basgeekball.awesomevalidation.ValidationStyle
import com.basgeekball.awesomevalidation.utility.RegexTemplate
import com.google.android.material.textfield.TextInputLayout
import com.tjeret99.kasirku.entities.AccessToken
import com.tjeret99.kasirku.entities.ApiError
import com.tjeret99.kasirku.network.ApiService
import com.tjeret99.kasirku.network.RetrofitBuilder
import kotlinx.android.synthetic.main.activity_main.*
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity() {

    private val TAG = "MainActivity"

    private lateinit var button: Button

    @BindView(R.id.Username)
    var tilUsername: TextInputLayout? = null

    @BindView(R.id.Password)

    var tilPassword: TextInputLayout? = null

    lateinit var service: ApiService
    lateinit var tokenManager: TokenManager
    lateinit var validator: AwesomeValidation
    var call: Call<AccessToken>? = null
//    var service: ApiService = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        ButterKnife.bind(this);
        val retrofitBuilder = RetrofitBuilder()
        val tManager = TokenManager()
        service = retrofitBuilder.createService<ApiService>(ApiService::class.java)
        tokenManager = tManager.getInstance(getSharedPreferences("prefs", MODE_PRIVATE))!!
        validator = AwesomeValidation(ValidationStyle.TEXT_INPUT_LAYOUT)


        button = findViewById(R.id.LoginButton)
        button.setOnClickListener {

//            login()
            intent = Intent(this, MenuActivity::class.java)
            startActivity(intent)
        }


    }

//    fun login() {
//
//        var username: String = tilUsername?.getEditText()?.getText().toString();
//        var password: String = tilPassword?.getEditText()?.getText().toString();
//
//        tilUsername?.setError(null);
//        tilPassword?.setError(null);
//
//        validator.clear();
//
//        if (validator.validate()){
//            call = service.login(username, password);
//            call?.enqueue(object : Callback<AccessToken> {
//                override fun onResponse(call: Call<AccessToken?>, response: Response<AccessToken?>) {
//                    Log.w(TAG, "onResponse: $response")
//                    if (response.isSuccessful) {
//                        tokenManager.saveToken(response.body()!!)
//                        startActivity(Intent(this@MainActivity, MenuActivity::class.java))
//                        finish()
//                    } else {
//                        if (response.code() == 422) {
//                            handleErrors(response.errorBody())
//                        }
//                        if (response.code() == 401) {
//
//                            val utils = Utils()
//                            val apiError: ApiError? = utils.converErrors(response.errorBody())
//                            Toast.makeText(this@MainActivity, apiError?.getMessage(), Toast.LENGTH_LONG).show()
//                        }
////                        showForm()
//                    }
//                }
//
//                override fun onFailure(call: Call<AccessToken?>, t: Throwable) {
//                    Log.w(TAG, "onFailure: " + t.message)
////                    showForm()
//                }
//            })
//        }
//
//
//
//    }
//
//    private fun handleErrors(response: ResponseBody?) {
//
//
//        val utils = Utils()
//        val apiError: ApiError? = utils.converErrors(response)
//        for ((key, value) in apiError!!.getErrors()!!.entrySet()) {
//            if (key == "username") {
//                tilUsername?.error = value?.get(0)
//            }
//            if (key == "password") {
//                tilPassword?.error = value?.get(0)
//            }
//        }
//    }
//
//    fun setupRules() {
//        validator.addValidation(this, R.id.Username, Patterns.EMAIL_ADDRESS, R.string.err_email)
//        validator.addValidation(this, R.id.Password, RegexTemplate.NOT_EMPTY, R.string.err_password)
//    }
//
//    override fun onDestroy() {
//        super.onDestroy()
//        if (call != null) {
//            call!!.cancel()
//            call = null
//        }
//    }
}