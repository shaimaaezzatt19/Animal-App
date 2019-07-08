package com.khatab.animalapp.data.rest;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitGeneral {
    //اغير هنا ال url واحط اللينك الجديد
    public static final String BASE_URL = "http://ipda3.com/sofra/api/v1/";
    public static Retrofit retrofit = null;

    public static Retrofit getGeneral() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
