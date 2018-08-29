package com.example.iseungcheon.wanhea.base;

import com.example.iseungcheon.wanhea.DTO.Item;
import com.example.iseungcheon.wanhea.DTO.Review;
import com.example.iseungcheon.wanhea.DTO.Store;
import com.example.iseungcheon.wanhea.DTO.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface RestApi {

//    @GET("a")
//    Call<List<User>> usr();

    @GET("a/home/{category_uid}")
    Call<List<Item>> home(@Path("category_uid")int category_uid);

    @GET("a/store")
    Call<Store> str();

    @GET("a/usr")
    Call<User> usr();

    @GET("a/review")
    Call<Review> review();

    @GET("a/item")
    Call<List<Item>> item();

    @GET("a/search/{word}")
    Call<List<Item>> search(@Path("word")String word);


}

