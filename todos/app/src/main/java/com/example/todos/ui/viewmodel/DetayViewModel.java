package com.example.todos.ui.viewmodel;

import androidx.lifecycle.ViewModel;

import com.example.todos.data.repo.TodosDaoRepository;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public class DetayViewModel extends ViewModel {
    public TodosDaoRepository trepo;

    @Inject
    public DetayViewModel(TodosDaoRepository trepo) { this.trepo = trepo; }

    public void guncelle(int id,String name) {
        trepo.guncelle(id, name);
    }

}
