package com.example.iseungcheon.wanhea;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class DB_Check extends AppCompatActivity {

    private ProgressDialog pDialog;
    private static final String URL_ADDRESS = "http://172.30.1.3:8080/server/a"; // 192.168.1.27는 연결된 ip주소
    private static final String URL_INFOR = "http://172.30.1.3:8080/server/a/infor"; // 192.168.1.27는 연결된 ip주소
    String LoadData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_db__check);
        getList a = new getList();
        a.execute();
    }

    class getList extends AsyncTask <Void, String, Void> {

        @Override
        protected void onPreExecute(){
            pDialog = new ProgressDialog(DB_Check.this);
            pDialog.setMessage("검색중입니다...");
            pDialog.setCancelable(false);
            pDialog.show();
            super.onPreExecute();
        }


        @Override
        protected Void doInBackground(Void... param) {


            Log.d("D: ","Doing!______________________---------------------------1");
            try {
                URL Url = new URL(URL_INFOR);
                HttpURLConnection conn = (HttpURLConnection) Url.openConnection();
                conn.setRequestMethod("POST");
                conn.setDoOutput(true);//쓰기모드
                conn.setDoInput(true);//읽기모드
                conn.setUseCaches(false); // 캐싱데이터 받을지 여부
                conn.setDefaultUseCaches(false); // 캐싱데이터 디폴트 값 설정

                Log.d("D: ","Doing!______________________---------------------------2");


                InputStream is = conn.getInputStream(); // input스트림 개방

                StringBuilder builder = new StringBuilder(); // 문자열 담기 위한 객체
                BufferedReader reader = new BufferedReader(new InputStreamReader(is,"UTF-8"));
                String line;
                Log.d("D: ","Doing!______________________---------------------------3");


                while((line = reader.readLine()) != null){
                    builder.append(line+"\n");
                }

                LoadData = builder.toString();
                Log.i("LoadData",LoadData);



            } catch (MalformedURLException e) {
                e.printStackTrace();
            }catch (IOException io){
                io.printStackTrace();
            }

            Log.d("D: ","Doing!______________________---------------------------4");


            return null;
        }


        @Override
        protected void onPostExecute(Void aVoid){
            pDialog.dismiss();
        }
    }
}
