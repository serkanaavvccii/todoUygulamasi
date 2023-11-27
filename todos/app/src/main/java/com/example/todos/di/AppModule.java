package com.example.todos.di;

import android.content.Context;

import androidx.room.Room;

import com.example.todos.data.repo.TodosDaoRepository;
import com.example.todos.room.TodosDao;
import com.example.todos.room.Veritabani;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.qualifiers.ApplicationContext;
import dagger.hilt.components.SingletonComponent;

@Module
@InstallIn(SingletonComponent.class)
public class AppModule {

    @Provides
    @Singleton
    public TodosDaoRepository provideTodosDaoRepository(TodosDao tdao){

        return new TodosDaoRepository(tdao);
    }

    @Provides
    @Singleton
    public TodosDao provideTodosDao(@ApplicationContext Context context){
        Veritabani vt = Room.databaseBuilder(context,Veritabani.class, "aaa.sqlite")
                .createFromAsset("aaa.sqlite").build();
        return vt.getTodosDao();
    }
}
