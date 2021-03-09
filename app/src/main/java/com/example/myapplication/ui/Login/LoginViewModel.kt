package com.example.myapplication.ui.Login

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.myapplication.repository.model.login.Login
import com.example.myapplication.repository.repo.login.LoginRepository
import com.example.myapplication.request.LoginRequest
import com.kotlin.mvvm.repository.api.network.Resource
import javax.inject.Inject

class LoginViewModel @Inject constructor(
    private val loginRepository: LoginRepository
) : ViewModel() {

    private fun loginApply(loginRequest: LoginRequest): LiveData<Resource<List<Login>?>> =
        loginRepository.getloginDetails(loginRequest)

    fun getloginDetails(loginRequest: LoginRequest) = loginApply(loginRequest)

}