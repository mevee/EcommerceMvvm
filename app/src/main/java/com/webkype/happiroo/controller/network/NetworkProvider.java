package com.webkype.happiroo.controller.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NetworkProvider {
    static Retrofit retrofit = null;
    public static AppApi instance() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl("https://happiroo.in/webservices/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        AppApi mClapApi = retrofit.create(AppApi.class);
        return mClapApi;
    }
}
