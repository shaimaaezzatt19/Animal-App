package com.khatab.animalapp.data.rest;

import com.khatab.animalapp.data.model.CancleOrder.CancleOrder;
import com.khatab.animalapp.data.model.Code.Code;
import com.khatab.animalapp.data.model.SaveOrder.SaveOrder;
import com.khatab.animalapp.data.model.ShowProducts.ShowProducts;
import com.khatab.animalapp.data.model.Services.Services;

import com.khatab.animalapp.data.model.ShowService.ShowService;
import com.khatab.animalapp.data.model.contact.Contact;
import com.khatab.animalapp.data.model.orders.Orders;

import retrofit2.Call;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Query;

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

//    @GET("services" + "/{id}")
    @GET("services")
    Call<ShowService> getservicesDeatils(@Query("id") Long id);


//Delete


    @GET("products")
    Call<ShowProducts> getProductsDeatils(@Query("id") Long id);


    @DELETE("orders")
    Call<CancleOrder> MakeCancle(@Query("id") Long id);


    //Cheack ???
    @Multipart
    @POST("orders")
    @FormUrlEncoded
    Call<SaveOrder> SendAllDetailsToSaveOrder(@Field("phone") String phone,
                                              @Field("address") String address,
                                              @Field("name") String name,
                                              @Field("products[0][quantity]") String products_quantity,
                                              @Field("products[0][product_id]") String products_product_id,
                                              @Field("products[0][packing]") String products_packing,
                                              @Field("products[0][cut]") String products_cut,
                                              @Field("products[1][quantity]") String products_quantity2,
                                              @Field("products[1][product_id]") String products_product_id2,
                                              @Field("products[1][packing]") String products_packing2,
                                              @Field("products[1][cut]") String products_cut2,
                                              @Field("code") String code);


}
