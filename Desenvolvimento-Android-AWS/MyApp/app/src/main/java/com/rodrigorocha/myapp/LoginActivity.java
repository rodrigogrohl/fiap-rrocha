package com.rodrigorocha.myapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    private EditText etUsername;
    private EditText etPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        etUsername = (EditText) findViewById(R.id.etUsername);
        etPassword = (EditText) findViewById(R.id.etPassword);

    }

    public void logon(View view) {
        if(etUsername.getText().toString().equals("rodrigo") &&
                etPassword.getText().toString().equals("123456")) {

            Intent intent = new Intent(this, OrderActivity.class);
            intent.putExtra("username", etUsername.getText().toString());
            startActivity(intent);
        } else {
            Toast.makeText(this, R.string.msg_invalid_login, Toast.LENGTH_LONG).show();
        }
    }
}
