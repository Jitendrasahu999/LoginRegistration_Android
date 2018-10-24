package com.example.jitendrakumarsahu.loginregistration;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

class MyDatabaseHelper extends SQLiteOpenHelper
{
    public static final String DATABASE_NAME = "employeeDatabase";
    public static final String DATABASE_VERSION = "1";
    public static final String TABLE_NAME = "employeeLogin";

    public static final String ID = "id";
    public static final String NAME = "name";
    public static final String EMAIL = "email";
    public static final String PASSWORD = "password";

    public static final String CREATE_TABLE = "CREATE TABLE "+TABLE_NAME+" ("+ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "+NAME+" VARCHAR(20),"+EMAIL+" VARCHAR(50), "+PASSWORD+" VARCHAR(20));";
    public static final String DROP_TABLE = "DROP TABLE IF EXISTS " +TABLE_NAME;
    private Context context;

    public MyDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, Integer.parseInt(DATABASE_VERSION));
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase)
    {
        try
        {
            sqLiteDatabase.execSQL(CREATE_TABLE);
        }
        catch (Exception e)
        {
            System.out.println("Error in onCreate method");
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1)
    {
        try
        {
            sqLiteDatabase.execSQL(DROP_TABLE);
        }
        catch (Exception e)
        {
            System.out.println("Error in onUpgrade method");
        }
    }
}
