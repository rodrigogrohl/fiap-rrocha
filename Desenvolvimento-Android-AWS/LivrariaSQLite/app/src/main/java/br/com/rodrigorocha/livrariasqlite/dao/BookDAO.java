package br.com.rodrigorocha.livrariasqlite.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import br.com.rodrigorocha.livrariasqlite.model.Book;

/**
 * Created by rm48236 on 05/09/2016.
 */
public class BookDAO {

    private static final String TABLE_BOOK = "book";
    static final String ID = "id";
    static final String AUTHOR = "author";
    static final String TITLE = "title";

    static final String[] COLUMNS = {ID, AUTHOR, TITLE};

    private MySQLiteHelper dbHelper;

    public BookDAO(Context context) {
        dbHelper = new MySQLiteHelper(context);

    }

    public void add(Book book) {

        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(AUTHOR, book.getAuthor());
        values.put(TITLE, book.getTitle());

        db.insert(TABLE_BOOK, null, values);
        db.close();
    }

    public void get(int id) {
        Book book = new Book();

        SQLiteDatabase database = dbHelper.getReadableDatabase();
        Cursor cursor = database.query(TABLE_BOOK, COLUMNS,
                "id = ?", new String[]{String.valueOf(id)},
                null, // group by
                null, // having
                null, // order by
                null  // limit
        );

        if(cursor != null) {
            cursor.moveToFirst();
            book.setId(cursor.getInt(0));
            book.setAuthor(cursor.getString(1));
            book.setTitle(cursor.getString(2));
        }
    }

    public List<Book> list() {
        List<Book> books = new ArrayList<Book>();

        SQLiteDatabase database = dbHelper.getReadableDatabase();
        String query = "SELECT * FROM " + TABLE_BOOK;
        Cursor cursor = database.rawQuery(query, null);

        if(cursor.moveToFirst()) {
            do {
                Book book = new Book();
                book.setId(cursor.getInt(cursor.getColumnIndex(ID)));
                book.setAuthor(cursor.getString(cursor.getColumnIndex(AUTHOR)));
                book.setTitle(cursor.getString(cursor.getColumnIndex(TITLE)));
                books.add(book);
            } while (cursor.moveToNext());
        }

        return books;
    }

    public void update(Book book){
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(AUTHOR, book.getAuthor());
        values.put(TITLE, book.getTitle());

        db.update(TABLE_BOOK,
                values,
                ID + " = ? ",
                new String[]{String.valueOf(book.getId())}
        );

        db.close();
    }

    public void delete(Book book) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(AUTHOR, book.getAuthor());
        values.put(TITLE, book.getTitle());

        db.delete(TABLE_BOOK,
                ID + " = ? ",
                new String[]{String.valueOf(book.getId())}
        );

        db.close();
    }
}
