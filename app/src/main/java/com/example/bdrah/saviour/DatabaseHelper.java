package com.example.bdrah.saviour;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.EditText;

/**
 * Created by RHF on 02/03/2017.
 */

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME="saviourr.db";

    private static final String TABLE_REGISTER="register_table";
    private static final String ID="ID";
    private static final String EMAIL="email";
    private static final String PASSWORD="password";
    private static final String NAME="name";
    private static final String PHONE="phone";
    private static final String CITY="city";

    private static final String TABLE_FOSTER="foster_table";
    private static final String F_ID="ID";
    private static final String PIC="pic";
    private static final String TYPE="type";
    private static final String FNAME="animal_name";
    private static final String F_PHONE="phone";
    private static final String LOCATION="location";
    private static final String DESCRIPTION="description";
    private static final String NEED_RATE="need_rate";
    private static final String REG_F_ID="user_ID";



    private static final String TABLE_DONATE="donate_table";
    private static final String D_ID="ID";
    private static final String REG_D_ID="user_ID";
    private static final String FOSTER_D_ID="foster_ID";

    private static final String TABLE_ADOPT="adopt_table";
    private static final String A_ID="ID";
    private static final String ANAME="animal_name";
    private static final String A_EMAIL="email";
    private static final String NUM_OF_PET="number_of_pets";
    private static final String REG_A_ID="user_ID";
    private static final String FOSTER_A_ID="user_ID";


    SQLiteDatabase db;

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
        SQLiteDatabase db = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // NOT NULL still!
        String createReg ="CREATE TABLE"+TABLE_REGISTER+" ("+
                F_ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "+
                EMAIL+" TEXT, "+
                PASSWORD+" TEXT, "+
                NAME+" TEXT, "+
                PHONE+" TEXT, "+
                CITY+" TEXT "+" );";

        String createFoster ="CREATE TABLE"+TABLE_FOSTER+" ("+
                F_ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "+
                TYPE+" TEXT, "+
                FNAME+" TEXT, "+
                PIC+" TEXT, "+
                F_PHONE+" TEXT, "+
                LOCATION+" TEXT, "+
                DESCRIPTION+" TEXT, "+
                NEED_RATE+" TEXT, "+
                " FOREIGN KEY("+REG_F_ID+") REFERENCES "+TABLE_REGISTER+"("+ID+") );";

        String createAdopt ="CREATE TABLE"+TABLE_ADOPT+" ("+
                A_ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "+
                ANAME+" TEXT, "+
                A_EMAIL+" TEXT, "+
                NUM_OF_PET+" TEXT, "+
                FOSTER_A_ID+" INTEGER NOT NULL, "+
                " FOREIGN KEY("+FOSTER_A_ID+") REFERENCES "+TABLE_FOSTER+"("+F_ID+")"+
                " FOREIGN KEY("+REG_A_ID+") REFERENCES "+TABLE_REGISTER+"("+ID+") );";


        String createDonate ="CREATE TABLE"+TABLE_DONATE+" ("+D_ID+" INTEGER PRIMARY KEY AUTOINCREMENT, " +
                REG_D_ID+" INTEGER NOT NULL, "+
                " FOREIGN KEY("+FOSTER_D_ID+") REFERENCES "+TABLE_FOSTER+"("+F_ID+")"+
                " FOREIGN KEY("+REG_D_ID+") REFERENCES "+TABLE_REGISTER+"("+ID+") );";


        db.execSQL(createReg);
        db.execSQL(createFoster);
        db.execSQL(createAdopt);
        db.execSQL(createDonate);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_REGISTER);
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_FOSTER);
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_DONATE);
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_ADOPT);
        db.execSQL("PRAGMA foreign_keys = ON;");
        onCreate(db);
    }

    //INSERT METHODS

    public void insert(Register register){
        //create contact values
        //SIMILAR TO HASHMAP
       db = this.getWritableDatabase();
        ContentValues cv= new ContentValues();
        cv.put(EMAIL, register.getEmail());
        cv.put(PASSWORD, register.getPassword());
        cv.put(NAME, register.getName());
        cv.put(PHONE, register.getPhone());
        cv.put(CITY, register.getCity());
        //save ID 
       long ID = db.insert(TABLE_REGISTER, null, cv);
        register.setID(ID);
        db.close();

    }
    public void insert(AdoptDB adoptDB){
        //create contact values
        //SIMILAR TO HASHMAP
        db = this.getWritableDatabase();
        ContentValues cv= new ContentValues();
        cv.put(ANAME, adoptDB.getAName());
        cv.put(A_EMAIL, adoptDB.getAEmail());
        cv.put(NUM_OF_PET, adoptDB.getNumberOfP());
        //save ID
        long ID = db.insert(TABLE_ADOPT, null, cv);
        adoptDB.setAID(ID);
        db.close();

    }
    public void insert(FosterDB fosterDB, Register register){
        //create contact values
        //SIMILAR TO HASHMAP
        db = this.getWritableDatabase();
        ContentValues cv= new ContentValues();
        cv.put(FNAME, fosterDB.getpName());
        cv.put(PIC, fosterDB.getPic());
        cv.put(F_PHONE, fosterDB.getFPhone());
        cv.put(LOCATION, fosterDB.getLocation());
        cv.put(TYPE, fosterDB.getType());
        cv.put(DESCRIPTION, fosterDB.getDescription());
        cv.put(NEED_RATE, fosterDB.getNeedRate());
        //save ID
        long ID = db.insert(TABLE_FOSTER, null, cv);
        fosterDB.setFID(ID);
        fosterDB.setREG_F_ID(register);
        db.close();

    }

    public void insert(DonateDB donateDB, FosterDB fosterDB, Register register){
        //create contact values
        //SIMILAR TO HASHMAP
        db = this.getWritableDatabase();
        ContentValues cv= new ContentValues();
        //save ID
        long ID = db.insert(TABLE_DONATE, null, cv);
        donateDB.setDID(ID);
        donateDB.setREG_D_ID(register);
        donateDB.setFOST_D_ID(fosterDB);
        db.close();

    }

    public void insert(AdoptDB adoptDB, FosterDB fosterDB, Register register){
        //create contact values
        //SIMILAR TO HASHMAP
        db = this.getWritableDatabase();
        ContentValues cv= new ContentValues();
        //save ID
        long ID = db.insert(TABLE_DONATE, null, cv);
        adoptDB.setAID(ID);
        adoptDB.setREG_A_ID(register);
        adoptDB.setFOST_A_ID(fosterDB);
        db.close();

    }


    public  boolean CheckEmailIsDataAlreadyInDBorNot(EditText entEmail) {
        String Query = "Select email from " + TABLE_REGISTER + " where " + entEmail+ " = " + EMAIL;
        Cursor cursor = db.rawQuery(Query, null);
        if(cursor.getCount() <= 0){
            cursor.close();
            return false;
        }
        cursor.close();
        return true;
    }

    public  boolean CheckPassIsDataAlreadyInDBorNot(EditText entPass) {
        String Query = "Select password from " + TABLE_REGISTER + " where " + entPass+ " = " + PASSWORD;
        Cursor cursor = db.rawQuery(Query, null);
        if(cursor.getCount() <= 0){
            cursor.close();
            return false;
        }
        cursor.close();
        return true;
    }

}
