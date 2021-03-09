package com.example.myapplication.repository.repo.login

import android.content.Context
import androidx.lifecycle.LiveData
import com.example.myapplication.app.AppExecutors
import com.example.myapplication.repository.api.ApiServices
import com.example.myapplication.repository.db.login.LoginDao
import com.example.myapplication.repository.model.login.Login
import com.example.myapplication.repository.model.login.LoginSource
import com.example.myapplication.request.LoginRequest
import com.example.myapplication.utils.ConnectivityUtil
import com.example.myapplication.utils.const
import com.kotlin.mvvm.repository.api.network.NetworkAndDBBoundResource
import com.kotlin.mvvm.repository.api.network.Resource
import javax.inject.Inject

class LoginRepository @Inject constructor(
    private val LoginDao: LoginDao,
    private val apiServices: ApiServices, private val context: Context,
    private val appExecutors: AppExecutors = AppExecutors()
) {

    fun getloginDetails(loginRequest: LoginRequest): LiveData<Resource<List<Login>?>> {
        return object : NetworkAndDBBoundResource<List<Login>, LoginSource>(appExecutors) {
            override fun saveCallResult(item: LoginSource) {
                var string=const.getValue()
                item.login.xaccheader=string
                LoginDao.insertUser(item.login)
            }

            override fun shouldFetch(data: List<Login>?): Boolean {
                //if internet is off, direct call loadFromDB()
                return   (ConnectivityUtil.isConnected(context))
            }

            override fun loadFromDb()=
                  LoginDao.getUsers()


            override fun createCall() =
                 apiServices.getApiLoginDetails(loginRequest)



        }.asLiveData()
    }
}