package br.com.rodrigorocha.livrariasqlite;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    private EditText etUsername;
    private EditText etPassword;
    private CheckBox cbStayLogged;

    private static final String PREF_NAME = "livraria";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etUsername = (EditText) findViewById(R.id.etUsername);
        etPassword = (EditText) findViewById(R.id.etPassword);
        cbStayLogged = (CheckBox) findViewById(R.id.cbStayLogged);

        SharedPreferences sp  = getSharedPreferences(PREF_NAME, MODE_PRIVATE);
        if(sp.getBoolean("stay_logged", false)){
            goToMainActivity(sp.getString("username", null));
        }
    }

    public void doLogin(View view) {
        String username = etUsername.getText().toString();
        String password = etPassword.getText().toString();
        if(username.equals("fiap") && password.equals("123")) {

            SharedPreferences sp  = getSharedPreferences(PREF_NAME, MODE_PRIVATE);
            SharedPreferences.Editor editor = sp.edit();
            editor.putBoolean("stay_logged", cbStayLogged.isChecked());
            editor.putString("username", username);
            editor.putString("password", password);
            editor.commit();

            goToMainActivity(username);
        } else {
            Toast.makeText(this, "Usuário ou Senha Inválido", Toast.LENGTH_LONG).show();
        }
    }

    private void goToMainActivity(String username) {
        Intent mainIntent =  new Intent(this, MainActivity.class);
        mainIntent.putExtra("username", username);
        startActivity(mainIntent);
    }

}
