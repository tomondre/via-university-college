package com.example.s07_networking.Ex02;

import android.app.Application;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

public class TodoViewModel extends AndroidViewModel {

    private TodoDao todoDao;
    private final ExecutorService executorService;
    private LiveData<List<Todo>> allTodos;

    public TodoViewModel(Application app) {
        super(app);
        TodoDatabase instance = TodoDatabase.getInstance(app);
        todoDao = instance.todoDao();
        executorService = Executors.newFixedThreadPool(2);
        allTodos = todoDao.getAllTodos();
    }

    public LiveData<List<Todo>> getAllTodos() {
        return allTodos;
    }

    public void insertTodo(Todo todo) {
        executorService.execute(() -> todoDao.insert(todo));
    }

}
