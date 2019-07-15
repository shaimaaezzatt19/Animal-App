package com.khatab.animalapp.data.rest;

import com.khatab.animalapp.data.model.CancleOrder.CancleOrder;
import com.khatab.animalapp.data.model.Code.Code;
import com.khatab.animalapp.data.model.SaveOrder.SaveOrder;
import com.khatab.animalapp.data.model.ShowProducts.Products;
import com.khatab.animalapp.data.model.Services.Services;

import com.khatab.animalapp.data.model.contact.Contact;
import com.khatab.animalapp.data.model.orders.Orders;

import retrofit2.Call;
import retrofit2.http.DELETE;
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

//    @GET("services" + "/{id}")
//    Call<ServicesData> getservicesDeatils(@Path("id") Integer id);


//Delete


    @GET("products/1")
    Call<Products> getProductsDeatils();


    @DELETE("orders/14")
    Call<CancleOrder> MakeCancle();


//    @POST("orders")
//    @FormUrlEncoded
//    Call<SaveOrder> SendContact(@Field("phone") String phone,
//                                @Field("address") String address,
//                                @Field("name") String name,
//                                @Field("products[0][quantity]")String  products[0][quantity],
//                                @Field( "products[0][product_id]" String products[0][product_id] ,
//                                @Field( "products[0][packing]" String products[0][packing],
//                                @Field( "products[0][cut]"String products[0][cut],
//                                @Field( "products[1][quantity]"String products[1][quantity] ,
//                                @Field( "products[1][product_id]" String products[1][product_id] ,
//                                @Field( "products[1][packing]" String products[1][packing] ,
//                                @Field( "products[1][cut]"  String products[1][cut]),
//                                        @Field( "code"String code ));






}
