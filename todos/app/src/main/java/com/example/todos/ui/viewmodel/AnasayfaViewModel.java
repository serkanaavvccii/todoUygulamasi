package com.example.todos.ui.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.todos.data.entity.Todos;
import com.example.todos.data.repo.TodosDaoRepository;

import java.util.List;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public class AnasayfaViewModel extends ViewModel {
    public TodosDaoRepository trepo;
    public MutableLiveData<List<Todos>> todoListesi;

    @Inject
    public AnasayfaViewModel(TodosDaoRepository trepo){
        this.trepo = trepo;
        todosYukle();
        todoListesi = trepo.todoListesi;
    }

    public void ara(String aramaKelimesi) { trepo.ara(aramaKelimesi); }

    public void sil(int id){
        trepo.sil(id);
    }

    public void todosYukle(){
        trepo.todoYukle();
    }
}
