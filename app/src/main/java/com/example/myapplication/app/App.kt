package com.example.myapplication.app

import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication
import com.kotlin.mvvm.di.components.DaggerAppComponent

class App : DaggerApplication() {

    private val applicationInjector = DaggerAppComponent.builder().application(this).build()

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> = applicationInjector

}