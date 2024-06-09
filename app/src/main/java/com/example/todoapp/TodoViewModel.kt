package com.example.todoapp

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.todoapp.data.MainApplication
import com.example.todoapp.data.Repository
import com.example.todoapp.data.ToDoData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class TodoViewModel : ViewModel(){
    private val repository = Repository(MainApplication.todoDatabase.getTododao())
    val TodoList: Flow<List<ToDoData>> = repository.getitems()

    fun addTODO(title: String) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.additem(ToDoData(Title = title))
        }
    }

    fun deletTODO(item: ToDoData) {
        viewModelScope.launch (Dispatchers.IO){
            repository.deletitem(item)
        }
    }
}