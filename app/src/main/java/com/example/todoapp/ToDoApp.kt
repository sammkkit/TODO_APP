package com.example.todoapp

import android.widget.Toast
import androidx.compose.runtime.collectAsState

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
//import androidx.compose.foundation.layout.FlowColumnScopeInstance.weight
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.style.TextAlign
import com.example.todoapp.data.ToDoData

@Composable
fun ToDoApp(viewModel: TodoViewModel){
    val keyboardController = LocalSoftwareKeyboardController.current
    val todolist by viewModel.TodoList.collectAsState(initial = emptyList())
    var inputext by remember {
        mutableStateOf("")
    }
    val context = LocalContext.current
    Column(
        modifier = Modifier
            .fillMaxHeight()
            .padding(8.dp)
    ){
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(1.dp)
                ,
            horizontalArrangement = Arrangement.SpaceEvenly
        ){
            OutlinedTextField(value = inputext, onValueChange ={
                inputext=it
            } ,modifier = Modifier.weight(1f).padding(4.dp),
                placeholder ={
                    Text("Enter Task")
                }

                )
            Button(onClick = {
                if(inputext.isNotEmpty()){
                    viewModel.addTODO(inputext)
                    inputext=""
                    keyboardController?.hide()
                }else{
                    Toast.makeText(context, "Task is Empty!!", Toast.LENGTH_LONG).show()
                }


            }) {
                Text("Add")
            }
        }
        if(todolist.isEmpty()){
            Text(
                text = "Nothing To See Here",
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center
            )
        }else{
            LazyColumn{
                items(todolist){
                        item ->
                    ToDoElement(item = item,{
                        viewModel.deletTODO(item)
                    })
                }
            }

        }

    }
}

@Composable
fun ToDoElement(item: ToDoData
,onDelet: ()->Unit
){
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clip(RoundedCornerShape(16.dp))
            .background(MaterialTheme.colorScheme.primary)

        , horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(modifier = Modifier
            .weight(1f)
            .padding(16.dp)) {
            Text(text = item.Title, fontSize = 15.sp, fontWeight = FontWeight.Bold, color = Color.LightGray);
        }
        IconButton(onClick = { onDelet() }) {
            Icon(imageVector = Icons.Default.Delete, contentDescription = null)
        }
    }
}