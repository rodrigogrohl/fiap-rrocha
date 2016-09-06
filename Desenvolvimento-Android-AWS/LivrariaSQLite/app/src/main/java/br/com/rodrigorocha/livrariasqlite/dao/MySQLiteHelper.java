package br.com.rodrigorocha.livrariasqlite.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by rm48236 on 05/09/2016.
 */
public class MySQLiteHelper extends SQLiteOpenHelper {

    public MySQLiteHelper(Context context) {
        super(context, "livros", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String createTableBooks = "CREATE TABLE book (" +
                BookDAO.ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "title TEXT, " +
                "author TEXT)";

        db.execSQL(createTableBooks);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS book");
        this.onCreate(db);
    }
}
