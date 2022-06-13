package com.example.s07_networking.Ex02;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.s07_networking.R;

import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.ExecutorService;

public class Ex02 extends AppCompatActivity {

    private TodoViewModel viewModel;
    private Button button;
    private EditText editText;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ex02);

        viewModel = new ViewModelProvider(this).get(TodoViewModel.class);

        bindViews();
        createListeners();
        createObservers();
    }

    private void createObservers() {
        viewModel.getAllTodos().observe(this, todos -> {
            String s = "";
            for (Todo todo : todos) {
                s += todo.getText() + " \n";
            }
            textView.setText(s);
        });
    }

    private void bindViews() {
        button = findViewById(R.id.button2);
        editText = findViewById(R.id.editTextTextPersonName2);
        textView = findViewById(R.id.textView2);
    }

    private void createListeners() {
        button.setOnClickListener(view -> {
            String s = editText.getText().toString();
            Todo todo = new Todo(s, LocalDateTime.now().toString(), false);
            viewModel.insertTodo(todo);
        });
    }


}