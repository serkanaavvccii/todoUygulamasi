package com.example.todos.data.repo;

import androidx.lifecycle.MutableLiveData;

import com.example.todos.data.entity.Todos;
import com.example.todos.room.TodosDao;

import java.util.List;

import io.reactivex.CompletableObserver;
import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class TodosDaoRepository {

    public MutableLiveData<List<Todos>> todoListesi = new MutableLiveData<>();

    private TodosDao tdao;

    public TodosDaoRepository(TodosDao tdao){this.tdao = tdao ;}

    public void kaydet(String name){
        Todos yeniTodo = new Todos(0,name);
        tdao.kaydet(yeniTodo).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new CompletableObserver() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onComplete() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }
                });

    }
    public void guncelle(int id, String name){
        Todos guncellenenTodo = new Todos(id,name);
        tdao.guncelle(guncellenenTodo).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new CompletableObserver() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onComplete() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }
                });
    }
    public void ara(String aramaKelimesi) {
        tdao.ara(aramaKelimesi).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleObserver<List<Todos>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onSuccess(List<Todos> todos) {
                        todoListesi.setValue(todos);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }
                });
    }
    public void sil(int id) {
        Todos silinenTodo = new Todos(id,"");
        tdao.sil(silinenTodo).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new CompletableObserver() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onComplete() {
                        todoYukle();
                    }

                    @Override
                    public void onError(Throwable e) {

                    }
                });
    }
    public void todoYukle(){
        tdao.todoYukle().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleObserver<List<Todos>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onSuccess(List<Todos> todos) {

                        todoListesi.setValue(todos);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }
                });
    }

}
