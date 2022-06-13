package com.example.s09_networking.Ex01;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ServiceGenerator {
    private static ProductsApi productsApi;

    public static ProductsApi getProductsApi() {
        if (productsApi == null) {
            productsApi = new Retrofit.Builder()
                    .baseUrl("https://lego-scraper.tomondre.com/themes/architecture/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                    .create(ProductsApi.class);
        }
        return productsApi;
    }
}
