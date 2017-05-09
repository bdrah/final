package com.example.bdrah.saviour;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.EditText;

/**
 * Created by Bdrahّ on 4/2/2017.
 */

public class DBH extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "Register.db";
    private static final String TABLE_NAME = "Register";
    private static final String COLUMN_NAME = "name";
    private static final String COLUMN_EMAIL = "email";
    private static final String COLUMN_password = "password";
    private static final String COLUMN_PHONE = "phone";
    private static final String COLUMN_CITY = "city";
    //private static final String CREATE_QUERY =
           // "CREATE TABLE "+TABLE_NAME+"("+COLUMN_NAME+" TEXT,"+COLUMN_EMAIL+" TEXT,"+COLUMN_password+" TEXT,"+COLUMN_PHONE+" TEXT,"
                   // +COLUMN_CITY+" TEXT);";


    static SQLiteDatabase db;
    private static final String TABLE_CREATE = "create table login(name text not null, email text primary key not null, password text not null, phone text, city text);";


    public DBH(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        Log.d("Database operation", "database created");

    }

    @Override
    public void onCreate(SQLiteDatabase db){
        db.execSQL(TABLE_CREATE);
        this.db = db;
        Log.d("Database operation", "table created");
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        String query = "DROP TABLE IF EXISTS"+TABLE_NAME;
        db.execSQL(query);
        this.onCreate(db);

    }

    public  boolean CheckEmailIsDataAlreadyInDBorNot(EditText entEmail) {
        String Query = "Select email from " + TABLE_NAME + " where " + entEmail+ " = " + "email";
        Cursor cursor = db.rawQuery(Query, null);
        if(cursor.getCount() <= 0){
            cursor.close();
            return false;
        }
        cursor.close();
        return true;
    }

    public  boolean CheckPassIsDataAlreadyInDBorNot(EditText entPass) {
        String Query = "Select password from " + TABLE_NAME + " where " + entPass+ " = " + "password";
        Cursor cursor = db.rawQuery(Query, null);
        if(cursor.getCount() <= 0){
            cursor.close();
            return false;
        }
        cursor.close();
        return true;
    }


}
