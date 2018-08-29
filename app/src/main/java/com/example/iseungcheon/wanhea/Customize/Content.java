package com.example.iseungcheon.wanhea.Customize;

import android.app.Fragment;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.iseungcheon.wanhea.DTO.Review;
import com.example.iseungcheon.wanhea.DTO.Store;
import com.example.iseungcheon.wanhea.DTO.User;
import com.example.iseungcheon.wanhea.R;
import com.example.iseungcheon.wanhea.base.RestApi;
import com.example.iseungcheon.wanhea.base.SyncCallback;
import com.squareup.picasso.Picasso;
import com.example.iseungcheon.wanhea.base.BaseApplication;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


//데이터를 못가져오겠어

public class Content extends Fragment {

    View view;
    Store store = null;
    User usr = null;
    Review rev = null;
    List<Store> stores;



    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle saveInstanceState) {

       view = inflater.inflate(R.layout.content, container, false);

        final ImageView picassoImageView = (ImageView) view.findViewById(R.id.picIV);

         System.out.println("~~~~~~~~~~~~~~~~드루와 드루와 ");
        Call<Store> call = BaseApplication.restApi.str();
        call.enqueue(new Callback<Store>(){
            @Override
            public void onResponse(Call<Store> call, Response<Store> response) {
                System.out.println("~~~~~~~~~~~~~~~~드루와 ");
                store = (Store) response.body();
//                Picasso.with(getActivity())
//                        .load(stores.get(0).getImg_url())
//                        .into(picassoImageView);
//                이미지가 커서 뷰가 깨짐
                TextView storeName = view.findViewById(R.id.storeName);
                TextView storeInfor = view.findViewById(R.id.storeInfor);

                System.out.println("~~~~~~~~~~~~~~~~ " + store.getName());
            }
            @Override
            public void onFailure(Call<Store> call, Throwable t) {
            }
        });
 // store 파싱 확인

 /*       Call<User> call = BaseApplication.restApi.usr();
        call.enqueue(new Callback<User>(){
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                System.out.println("~~~~~~~~~~~~~~~~냄새나옴 ");
                usr = (User) response.body();
                System.out.println("~~~~~~~~~~~~~~~~ " + usr.getName());
            }
            @Override
            public void onFailure(Call<User> call, Throwable t) {
            }
        }); // user 파싱 확인*/

//        Call<Review> call = BaseApplication.restApi.review();
//        call.enqueue(new Callback<Review>(){
//            @Override
//            public void onResponse(Call<Review> call, Response<Review> response) {
//                System.out.println("~~~~~~~~~~~~~~~~드루와 ");
//                rev = (Review) response.body();
//                System.out.println("~~~~~~~~~~~~~~~~ " + rev.getContent());
//            }
//            @Override
//            public void onFailure(Call<Review> call, Throwable t) {
//            }
//        }); // user 파싱 확인





        return view;
    }



}
