package com.example.iseungcheon.wanhea;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.iseungcheon.wanhea.Customize.Customize;
import com.example.iseungcheon.wanhea.DTO.BaseRequest;
import com.example.iseungcheon.wanhea.DTO.User;
import com.example.iseungcheon.wanhea.DTO.User;
import com.example.iseungcheon.wanhea.base.BaseApplication;
import com.example.iseungcheon.wanhea.databinding.ActivityMainBinding;
import com.google.gson.JsonObject;
import com.koushikdutta.async.future.Future;
import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.async.parser.AsyncParser;
import com.koushikdutta.ion.Ion;

import org.json.JSONObject;

import java.util.List;

//클래스에서 바로 db에 접근할려고 해서 error가 발생

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ActivityMainBinding b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        b = DataBindingUtil.setContentView(this, R.layout.activity_main);
        b.setOnClick(this);
        apiTest();
    }

    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()) {
            case R.id.customBtn:
                intent = new Intent(MainActivity.this, Customize.class);
                startActivity(intent);
                break;

//            case R.id.reviewBtn:
//                intent = new Intent(MainActivity.this, RetrofitActivity.class);
//                startActivity(intent);
//                break;

            case R.id.reviewBtn:
                intent = new Intent(MainActivity.this, ItemActivity.class);
                startActivity(intent);
                break;

            case R.id.dbBtn:
//                intent = new Intent(MainActivity.this, DB_Check.class);
                intent = new Intent(MainActivity.this, ItemActivity.class);
                startActivity(intent);
                break;

            default : break;
        }
    }

    private void apiTest() {

//        Future<JsonObject> userFuture = Ion.with(this)
//                .load(BaseApplication.URL_ADDRESS)
//                .asJsonObject()
//                .setCallback(new FutureCallback<JsonObject>() {
//                    @Override
//                    public void onCompleted(Exception e, JsonObject result) {
//                            System.out.print("Hi"+result);
//                    }
//
//                });

    }
}
