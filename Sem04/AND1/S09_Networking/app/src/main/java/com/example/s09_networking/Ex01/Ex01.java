package com.example.s09_networking.Ex01;

import androidx.appcompat.app.AppCompatActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.app.Service;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.s09_networking.R;

import java.util.List;

public class Ex01 extends AppCompatActivity {

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ex01);

        textView = findViewById(R.id.textView);
        getAllProducts();
    }

    private void getAllProducts() {
        ProductsApi productsApi = ServiceGenerator.getProductsApi();
        Call<List<ProductsResponse>> call = productsApi.getProducts();

        call.enqueue(new Callback<List<ProductsResponse>>() {
            @Override
            public void onResponse(Call<List<ProductsResponse>> call, Response<List<ProductsResponse>> response) {
                displayAllProducts(response.body().get(0).getProducts());
            }

            @Override
            public void onFailure(Call<List<ProductsResponse>> call, Throwable t) {
                Log.i("Retrofit", "Call didn't work");
            }
        });
    }

    private void displayAllProducts(List<Product> products) {
        String s = "";

        for (Product product : products) {
            s += product.getName() + " \n";
        }
        textView.setText(s);
    }
}