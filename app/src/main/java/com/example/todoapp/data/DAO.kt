package com.example.todoapp.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.todoapp.data.ToDoData
import kotlinx.coroutines.flow.Flow


@Dao
abstract class DAO {
//Crud
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    abstract suspend fun addTOdo(ToDoDataEntity: ToDoData)

    @Query("Select * from `todo-table`")
    abstract fun getTOdolist(): Flow<List<ToDoData>>

    @Update
    abstract suspend fun updateTOdo(ToDoDataEntity: ToDoData)

    @Delete
    abstract suspend fun Deletetodo(toDoData: ToDoData)


    @Query("Select * from `todo-table` where id =:id")
    abstract fun getTOdolistbyID(id:Int): Flow<ToDoData>

}