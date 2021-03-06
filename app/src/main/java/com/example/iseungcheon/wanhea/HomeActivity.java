package com.example.iseungcheon.wanhea;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;

import com.example.iseungcheon.wanhea.DTO.Item;
import com.example.iseungcheon.wanhea.base.BaseApplication;
import com.example.iseungcheon.wanhea.databinding.ActivityHomeBinding;
//import com.example.iseungcheon.wanhea.databinding.ContentHomeBinding;

import java.io.Serializable;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

//    ContentHomeBinding homeBinding;
        ActivityHomeBinding Binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        Binding = DataBindingUtil.setContentView(this, R.layout.activity_home);
        Binding.setHomeActivity(this);

        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_home);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
//    ---------------------------------------------------------------


    }

    public void onButtonClick(View view){
        System.out.println("확인");

        int id = view.getId();
        if(id == R.id.magnifier){
            EditText et = (EditText) findViewById(R.id.search);
            System.out.println("들어옴");
            System.out.println(et.getText());
            Call<List<Item>> call = BaseApplication.restApi.search(et.getText().toString());
            call.enqueue(new Callback<List<Item>>() {
                @Override
                public void onResponse(Call<List<Item>> call, Response<List<Item>> response) {
                    System.out.println("통신성공 ");
                    List<Item> items = (List<Item>) response.body();
                    System.out.println("검색 결과 : "+ items.get(0).getName());

                }

                @Override
                public void onFailure(Call<List<Item>> call, Throwable t) {
                    System.out.println(t);

                }
            });
            return;
        }

        Button b =  (Button)findViewById(id);
        final String title = b.getText().toString();
        int uid = Integer.parseInt(b.getTag().toString());


        Call<List<Item>> call = BaseApplication.restApi.home(uid);
        call.enqueue(new Callback<List<Item>>() {
            @Override
            public void onResponse(Call<List<Item>> call, Response<List<Item>> response) {
                System.out.println("통신성공 ");
                List<Item> items = (List<Item>) response.body();
                Intent intent = new Intent(getApplicationContext(), ItemActivity.class);
                intent.putExtra("items",(Serializable) items);
                intent.putExtra("title",title);
                startActivity(intent);
            }

            @Override
            public void onFailure(Call<List<Item>> call, Throwable t) {
                System.out.println(t);

            }
        });
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
