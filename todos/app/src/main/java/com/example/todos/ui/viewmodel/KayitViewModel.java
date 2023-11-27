package com.example.todos.ui.viewmodel;

import androidx.lifecycle.ViewModel;

import com.example.todos.data.repo.TodosDaoRepository;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public class KayitViewModel extends ViewModel {
    public TodosDaoRepository trepo;

    @Inject
    public KayitViewModel(TodosDaoRepository trepo) { this.trepo = trepo; }

    public void kaydet(String name) {trepo.kaydet(name);}

}
