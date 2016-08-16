package com.rodrigorocha.myapp;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class OrderActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        if(getIntent() != null) {

            Toast.makeText(
                    this,
                    getString(R.string.msg_welcome, getIntent().getStringExtra("username"),
                    Toast.LENGTH_LONG)).show();
        }
    }
}
