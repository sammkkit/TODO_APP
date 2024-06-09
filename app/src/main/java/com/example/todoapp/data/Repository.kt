package com.example.todoapp.data

import kotlinx.coroutines.flow.Flow

class Repository(private val TODOdao : DAO) {
    suspend fun additem(item: ToDoData){
        TODOdao.addTOdo(item)
    }
    suspend fun updateitem(item: ToDoData){
        TODOdao.updateTOdo(item)
    }

    suspend fun deletitem(item: ToDoData){
        TODOdao.Deletetodo(item)
    }
    fun getitems(): Flow<List<ToDoData>> = TODOdao.getTOdolist()


    fun getitembyID(id:Int): Flow<ToDoData>{
        return TODOdao.getTOdolistbyID(id)
    }
}