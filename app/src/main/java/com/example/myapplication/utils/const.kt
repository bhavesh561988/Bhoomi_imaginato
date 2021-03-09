package com.example.myapplication.utils

object const {

    lateinit var headers: String

    fun setValue(value: String) {
        headers = value
    }
    fun getValue()= headers


}