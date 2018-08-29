//package com.example.iseungcheon.wanhea.base;
//
//import android.support.v7.app.AppCompatActivity;
//import android.os.Bundle;
//import android.widget.TextView;
//import android.widget.Toast;
//
//import com.example.iseungcheon.wanhea.DTO.User;
//import com.example.iseungcheon.wanhea.R;
//
//import java.util.List;
//
//import retrofit2.Call;
//import retrofit2.Callback;
//import retrofit2.Response;
//import retrofit2.Retrofit;
//import retrofit2.converter.gson.GsonConverterFactory;
//
//import static com.example.iseungcheon.wanhea.base.BaseApplication.URL_ADDRESS;
//
//public class RetrofitActivity extends AppCompatActivity {
//    private Retrofit retrofit;
//    private TextView textView;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_retrofit);
//        init();
//
//        RestApi restApi = retrofit.create(RestApi.class);
//        Call<List<User>> call = restApi.usr();
//
//        call.enqueue(new Callback<List<User>>() {
//            @Override
//            public void onResponse(Call<List<User>> call, Response<List<User>> response) {
//                List<User> users = response.body();
//                for(User u : users){
//                    textView.append(u.getAddress());
//                    textView.append(u.getName());
//                    textView.append(u.getAge());
//                }
//            }
//
//            @Override
//            public void onFailure(Call<List<User>> call, Throwable t) {
//                Toast.makeText(RetrofitActivity.this, "정보받아오기 실패", Toast.LENGTH_LONG)
//                        .show();
//
//            }
//        });
//    }
//
//    public void init(){
//        textView = (TextView)findViewById(R.id.textView);
//
//        retrofit = new Retrofit.Builder()
//                .baseUrl("http://172.20.10.2:8080/server/")
//                .addConverterFactory(GsonConverterFactory.create())
//                .build();
//    }
//}
