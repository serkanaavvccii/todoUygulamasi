package com.example.todos.room;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.todos.data.entity.Todos;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Single;

@Dao
public interface TodosDao {
    @Query("SELECT * FROM aaa")
    Single<List<Todos>> todoYukle();

    @Insert
    Completable kaydet(Todos todo);

    @Update
    Completable guncelle(Todos todo);

    @Delete
    Completable sil(Todos todo);

    @Query("SELECT * FROM aaa WHERE name like '%' || :aramaKelimesi || '%'")
    Single<List<Todos>> ara(String aramaKelimesi);
}
