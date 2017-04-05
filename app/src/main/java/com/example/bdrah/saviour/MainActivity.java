package com.example.bdrah.saviour;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
   Button loginB, infoB;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loginB =(Button)findViewById(R.id.button5);
        infoB =(Button)findViewById(R.id.button6);

        loginB.setOnClickListener(this);
        infoB.setOnClickListener(this);

    }

    @Override
    public void onClick(View v){
        switch (v.getId()) {
            case R.id.button5:
                startActivity(new Intent(this, login.class));
                break;

            case R.id.button6:
                startActivity(new Intent(this, AppInfo.class));
                break;

        }

    }
}
