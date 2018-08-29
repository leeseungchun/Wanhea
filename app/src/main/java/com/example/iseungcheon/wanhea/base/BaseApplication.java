package com.example.iseungcheon.wanhea.base;

import android.app.Application;
import android.content.Intent;
import android.view.View;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class BaseApplication extends Application {

    public static String URL_ADDRESS = "http://192.168.1.16:8080/"; // 192.168.1.27는 연결된 ip주소
    public static String URL_STORE = "http://192.168.1.16:8080/server/a/store"; // 192.168.1.27는 연결된 ip주소
    public static RestApi restApi; // 통신 객체

    @Override
    public void onCreate() {
        super.onCreate();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.1.16:8080/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        restApi = retrofit.create(RestApi.class);
        System.out.println("hello application");
    }

}
