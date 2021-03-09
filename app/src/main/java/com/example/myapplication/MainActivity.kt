package com.example.myapplication

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.myapplication.databinding.ActivityMainBinding
import com.example.myapplication.request.LoginRequest
import com.example.myapplication.ui.BaseActivity
import com.example.myapplication.ui.Login.LoginViewModel
import com.example.myapplication.utils.LogUtil

/**
 * Created by Bhoomi Shah
 */
class MainActivity : BaseActivity() {


    lateinit var loginViewModel: LoginViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        loginViewModel =
            ViewModelProviders.of(this, viewModelFactory).get(LoginViewModel::class.java)
        val binding: ActivityMainBinding = DataBindingUtil.setContentView(
            this, R.layout.activity_main
        )
        binding.user =
            LoginRequest(binding.edtUsername.text.toString(), binding.edtPassword.text.toString())

        binding.btnlogin.setOnClickListener(View.OnClickListener {


            if (binding.edtUsername.text.toString().trim().length == 0) {
                Toast.makeText(this, getString(R.string.please_enter_username), Toast.LENGTH_LONG)
                    .show()

            } else if (binding.edtPassword.text.toString().trim().length == 0) {
                Toast.makeText(this, getString(R.string.please_enter_password), Toast.LENGTH_LONG)
                    .show()

            } else {
                var loginRequest = LoginRequest(
                    binding.edtUsername.text.toString(),
                    binding.edtPassword.text.toString()
                )
                onLoginClick(loginRequest)

            }

        })
    }

    fun onLoginClick(loginRequest: LoginRequest) {
        loginViewModel.getloginDetails(loginRequest).observe(this, Observer {
            when {
                it.status.isLoading() -> {
                    // news_list.showProgressView()
                }
                it.status.isSuccessful() -> {
                    if (it?.data!!.size > 0) {
                        Toast.makeText(this, it?.data!!.get(0).userId, Toast.LENGTH_LONG).show()
                    }
                }
                it.status.isError() -> {
                    if (it.errorMessage != null)
                        LogUtil.error("Error", it.errorMessage.toString())
                    Toast.makeText(this, it.errorMessage, Toast.LENGTH_LONG).show()
                }
            }
        })

    }
}