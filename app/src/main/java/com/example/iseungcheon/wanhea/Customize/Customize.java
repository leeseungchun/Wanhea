package com.example.iseungcheon.wanhea.Customize;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import com.example.iseungcheon.wanhea.R;

public class Customize extends AppCompatActivity implements View.OnClickListener {

    FragmentManager fm;
    FragmentTransaction tran;
    Content content ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_customize);
        Button acc_btn = (Button)findViewById(R.id.acc_btn);


        acc_btn.setOnClickListener(this);
        content = new Content();


    }


    @Override
    public void onClick(View v){

        switch (v.getId()){
            case R.id.acc_btn:
                setFrag(0);
                break;
            default: break;

        }

    }


    public void setFrag(int n){

        fm = getFragmentManager();
        tran = fm.beginTransaction();

        switch (n){
            case 0:
                tran.replace(R.id.frame, content);
                tran.commit();
                break;
             default: break;
        }
    }

}
