package com.example.myapplication.di.modules

import com.example.myapplication.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector



/**
 * All your Activities participating in DI would be listed here.
 */
@Module
abstract class ActivityModule {
    @ContributesAndroidInjector
    abstract fun contributeMainActivity(): MainActivity

}
