package com.example.iseungcheon.wanhea;

import android.content.Intent;
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
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;

import com.example.iseungcheon.wanhea.DTO.Item;
import com.example.iseungcheon.wanhea.DTO.Store;
import com.example.iseungcheon.wanhea.base.BaseApplication;

import java.io.Serializable;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ItemActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        System.out.println("~~~~~~~~~~~~~~~~드루와 ");

        Intent intent = getIntent();

        TextView title = (TextView) findViewById(R.id.title_item);
        title.setText(intent.getStringExtra("title"));
        final List<Item> items = (List<Item>) intent.getSerializableExtra("items");

        ItemAdapter adapter = new ItemAdapter(getApplicationContext(), R.layout.item_member, items);
        GridView gridView = (GridView) findViewById(R.id.itemContainer);
        gridView.setAdapter(adapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                System.out.println("position : "+ position);
                Intent intent = new Intent(getApplicationContext(),ItemInforActivity.class);
                intent.putExtra("item_infor", (Serializable) items.get(position));
                startActivity(intent);
            }
        });

//        Call<List<Item>> call = BaseApplication.restApi.item();
//        System.out.println("통신직전");
//        call.enqueue(new Callback<List<Item>>(){
//            @Override
//            public void onResponse(Call<List<Item>> call, Response<List<Item>> response) {
//                System.out.println("통신성공 ");
//                final List<Item> items = (List<Item>)response.body();
//
//                System.out.println("통신성공 " + items.get(0).getMaterial());
//
//                ItemAdapter adapter = new ItemAdapter(getApplicationContext(), R.layout.item_member, items);
//                GridView gridView = (GridView) findViewById(R.id.itemContainer);
//                gridView.setAdapter(adapter);
//                gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//                    @Override
//                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                        System.out.println("position : "+ position);
//                        Intent intent = new Intent(getApplicationContext(),ItemInforActivity.class);
//                        intent.putExtra("item_infor", (Serializable) items.get(position));
//                        startActivity(intent);
//                    }
//                });
//
//            }
//            @Override
//            public void onFailure(Call<List<Item>> call, Throwable t) {
//                System.out.println(t);
//            }
//        });
//
//        System.out.println("확인");

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
        getMenuInflater().inflate(R.menu.item, menu);
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
