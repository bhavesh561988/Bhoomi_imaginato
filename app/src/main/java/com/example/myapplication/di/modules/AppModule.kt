package com.example.myapplication.di.modules

import android.content.Context
import android.content.res.Resources
import androidx.room.Room
import com.example.myapplication.app.App
import com.example.myapplication.repository.api.ApiServices
import com.example.myapplication.repository.api.network.LiveDataCallAdapterFactoryForRetrofit
import com.example.myapplication.repository.db.AppDatabase
import com.example.myapplication.repository.db.login.LoginDao
import com.kotlin.mvvm.di.modules.PreferencesModule
import com.kotlin.mvvm.di.modules.ViewModelModule
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton



@Module(includes = [PreferencesModule::class, ActivityModule::class, ViewModelModule::class])
class AppModule {

    /**
     * Static variables to hold base url's etc.
     */
    companion object {
        private const val BASE_URL = "http://private-222d3-homework5.apiary-mock.com/"
    }


    /**
     * Provides ApiServices client for Retrofit
     */
    @Singleton
    @Provides
    fun provideNewsService(): ApiServices {
       /* val logging = HttpLoggingInterceptor()
        // set your desired log level
        logging.setLevel(HttpLoggingInterceptor.Level.BODY)

        val httpClient = OkHttpClient.Builder()


        // add session headers interceptor
        httpClient.addInterceptor(logging);

        // add logging as last interceptor

        // add logging as last interceptor*/
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(LiveDataCallAdapterFactoryForRetrofit())

            .build()
            .create(ApiServices::class.java)
    }


    /**
     * Provides app AppDatabase
     */
    @Singleton
    @Provides
    fun provideDb(context: Context): AppDatabase =
        Room.databaseBuilder(context, AppDatabase::class.java, "test-db")
            .fallbackToDestructiveMigration().build()


    @Singleton
    @Provides
    fun provideLoginDao(db: AppDatabase): LoginDao = db.loginDao()


    /**
     * Application application level context.
     */
    @Singleton
    @Provides
    fun provideContext(application: App): Context = application.applicationContext


    /**
     * Application resource provider, so that we can get the Drawable, Color, String etc at runtime
     */
    @Provides
    @Singleton
    fun providesResources(application: App): Resources = application.resources
}
