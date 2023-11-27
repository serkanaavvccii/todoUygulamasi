package com.example.todos.room;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.todos.data.entity.Todos;

@Database(entities = {Todos.class},version = 1)
public abstract class Veritabani extends RoomDatabase {
        public abstract TodosDao getTodosDao();
}
