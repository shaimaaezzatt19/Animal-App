package com.khatab.animalapp.data.rest;

import com.khatab.animalapp.data.model.Code.Code;
import com.khatab.animalapp.data.model.ServicesNumber.Services;
import com.khatab.animalapp.data.model.ServicesNumber.ServicesData;
import com.khatab.animalapp.data.model.ShowProducts.Products;
import com.khatab.animalapp.data.model.contact.Contact;
import com.khatab.animalapp.data.model.orders.Orders;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiServices {


    @POST("contact")
    @FormUrlEncoded
    Call<Contact> SendContact(@Field("name") String name,
                              @Field("phone") String phone,
                              @Field("message") String m);

    @GET("services")
    Call<Services> getservices();

    @POST("orders")
    Call<Orders> Sendorders();

    @GET("code")
    Call<Code> getCode();

    @GET("services/1")
    Call<ServicesData> getservicesDeatils();

//Delete


    @GET("products/1")
    Call<Products> getProductsDeatils();


}
