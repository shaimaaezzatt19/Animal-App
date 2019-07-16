package com.khatab.animalapp.data.rest;

import com.khatab.animalapp.data.model.CancleOrder.CancleOrder;
import com.khatab.animalapp.data.model.Code.Code;
import com.khatab.animalapp.data.model.SaveOrder.SaveOrder;
import com.khatab.animalapp.data.model.ShowProducts.Products;
import com.khatab.animalapp.data.model.Services.Services;

import com.khatab.animalapp.data.model.ShowService.ShowService;
import com.khatab.animalapp.data.model.contact.Contact;
import com.khatab.animalapp.data.model.orders.Orders;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Path;

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

    @GET("services" + "/{id}")
    Call<ShowService> getservicesDeatils(@Path("id") Integer id);


//Delete


    @GET("products/1")
    Call<Products> getProductsDeatils();


    @DELETE("orders/14")
    Call<CancleOrder> MakeCancle();


    //Cheack ???
    @Multipart
    @POST("orders")
    @FormUrlEncoded
    Call<SaveOrder> SendAllDetailsToSaveOrder(@Field("phone") String phone,
                                              @Field("address") String address,
                                              @Field("name") String name,
                                              @Field("products[0][quantity]") RequestBody products_quantity,
                                              @Field("products[0][product_id]") RequestBody products_product_id,
                                              @Field("products[0][packing]") RequestBody products_packing,
                                              @Field("products[0][cut]") RequestBody products_cut,
                                              @Field("products[1][quantity]") RequestBody products_quantity2,
                                              @Field("products[1][product_id]") RequestBody products_product_id2,
                                              @Field("products[1][packing]") RequestBody products_packing2,
                                              @Field("products[1][cut]") RequestBody products_cut2,
                                              @Field("code") String code);


}
