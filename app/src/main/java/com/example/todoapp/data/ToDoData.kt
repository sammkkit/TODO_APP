package com.example.todoapp.data

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date
import java.time.Instant

@Entity(tableName = "Todo-table")
data class ToDoData(
    @PrimaryKey(autoGenerate = true)
    val id:Int=0,
    @ColumnInfo(name = "todo-title")
    val Title:String,
)

