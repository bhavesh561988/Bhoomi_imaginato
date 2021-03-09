package com.example.myapplication.repository.db.login

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.myapplication.repository.model.login.Login

@Dao
interface LoginDao {

    /**
     * Insert articles into the database
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertUsers(articles: List<Login>): List<Long>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertUser(login:Login): Long

    /**
     * Get all the articles from database
     */
    @Query("SELECT * FROM user_table ")
    fun getUsers(): LiveData<List<Login>>

    @Query("SELECT * FROM user_table where userId=11111")
    fun getUser(): LiveData<Login>

    @Query("DELETE FROM user_table")
    abstract fun deleteUsers()
}