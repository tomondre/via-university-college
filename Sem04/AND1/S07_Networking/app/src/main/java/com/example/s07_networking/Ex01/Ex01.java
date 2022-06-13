package com.example.s07_networking.Ex01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.s07_networking.R;

public class Ex01 extends AppCompatActivity {

    public static String preferencesKey = "HalabalaKey";

    private Button button;
    private EditText editText;
    private TextView textView;
    private SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ex01);

        preferences = getSharedPreferences("MyPrefs", MODE_PRIVATE);

        bindViews();

        fetchSavedItem();
        createListeners();
    }

    private void createListeners() {
        button.setOnClickListener(view -> {
            String s = editText.getText().toString();

            textView.setText(s);
            preferences.edit().putString(preferencesKey, s).apply();
        });
    }

    private void fetchSavedItem() {
        String string = preferences.getString(preferencesKey, "");
        textView.setText(string);
    }

    private void bindViews() {
        button = findViewById(R.id.button);
        editText = findViewById(R.id.editTextTextPersonName);
        textView = findViewById(R.id.textView);
    }
}