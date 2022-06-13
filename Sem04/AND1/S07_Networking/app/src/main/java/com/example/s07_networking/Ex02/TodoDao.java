package com.example.s07_networking.Ex02;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

@Dao
public interface TodoDao {

    @Insert
    void insert(Todo todo);

    @Update
    void update(Todo todo);

    @Delete
    void delete(Todo todo);

    @Query("DELETE FROM todos")
    void deleteAllTodos();

    @Query("SELECT * FROM todos ORDER BY createdOn DESC")
    LiveData<List<Todo>> getAllTodos();
}
