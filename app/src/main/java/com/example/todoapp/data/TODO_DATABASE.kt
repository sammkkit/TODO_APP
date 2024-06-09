package com.example.todoapp.data

import androidx.room.Database
import androidx.room.RoomDatabase


@Database(
    entities = [ToDoData::class],
    version = 1,
    exportSchema = false
)
abstract class TODO_DATABASE: RoomDatabase() {

    companion object{
        const val name = "TODO-DB"
    }
    abstract fun getTododao(): DAO
}