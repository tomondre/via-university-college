package com.example.s09_networking.Ex01;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ProductsApi {
    @GET("products")
    Call<List<ProductsResponse>> getProducts();
}
