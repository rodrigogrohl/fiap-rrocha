package br.com.rodrigorocha.livrariasqlite;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import br.com.rodrigorocha.livrariasqlite.dao.BookDAO;
import br.com.rodrigorocha.livrariasqlite.model.Book;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        testDB();
    }

    private void testDB() {
        BookDAO dao = new BookDAO(this);

        SharedPreferences sp = getSharedPreferences("LIVRARIA", MODE_PRIVATE);
        if( sp.getBoolean("inserted", false) ) {
           dao.add(new Book("Android in Action", "Ricardo Lechetta"));
            dao.add(new Book("Crepúsculo", "Stephenie Meyer"));
            dao.add(new Book("50 Tons de Cinza", "E. L. James"));

            SharedPreferences.Editor editor = sp.edit();
            editor.putBoolean("inserted", true);
            editor.commit();
        }
    }
}
