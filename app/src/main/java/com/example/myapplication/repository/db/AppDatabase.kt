package com.example.myapplication.repository.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.myapplication.repository.db.login.LoginDao
import com.example.myapplication.repository.model.login.Login




/**
 * App Database
 * Define all entities and access doa's here/ Each entity is a table.
 */
@Database(entities = [Login::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun loginDao(): LoginDao


}