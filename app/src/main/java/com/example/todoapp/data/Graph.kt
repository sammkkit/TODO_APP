package com.example.todoapp.data

import android.app.Application
import androidx.room.Room

class MainApplication : Application(){
    companion object{
        lateinit var todoDatabase: TODO_DATABASE
    }

    override fun onCreate() {
        super.onCreate()
        todoDatabase = Room.databaseBuilder(applicationContext,
            TODO_DATABASE::class.java,
            TODO_DATABASE.name
        ).build()
    }
}