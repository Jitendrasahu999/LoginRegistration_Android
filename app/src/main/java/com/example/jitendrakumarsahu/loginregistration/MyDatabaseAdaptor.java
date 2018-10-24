package com.example.jitendrakumarsahu.loginregistration;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;

public class MyDatabaseAdaptor
{
    MyDatabaseHelper myDatabaseHelper;



    public MyDatabaseAdaptor(Context context)  //Creating a Constructor.
    {
        Log.d("Context: ", context == null ? "is null": "is not null");
        myDatabaseHelper = new MyDatabaseHelper(context);     //make a object of database helper.
    }

    public long insertData(String name,String age, String salary)
    {
        SQLiteDatabase sqLiteDatabase = myDatabaseHelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(myDatabaseHelper.NAME, name);
        contentValues.put(myDatabaseHelper.EMAIL, age);
        contentValues.put(myDatabaseHelper.PASSWORD, salary);

        long id = sqLiteDatabase.insert(myDatabaseHelper.TABLE_NAME, null, contentValues);
        return id;
    }


    public boolean getData(String editTextEmailText, String passwordget)
    {
        boolean val=false;
        SQLiteDatabase sqLiteDatabase = myDatabaseHelper.getWritableDatabase();
        String [] collumn = {myDatabaseHelper.ID, myDatabaseHelper.NAME, myDatabaseHelper.EMAIL, myDatabaseHelper.PASSWORD};
        Cursor cursor = sqLiteDatabase.query(myDatabaseHelper.TABLE_NAME,collumn,null, null, null, null,null);

        ArrayList<Employee> employees = new ArrayList<Employee>();


        while (cursor.moveToNext())
        {
            int id = cursor.getInt(cursor.getColumnIndex(myDatabaseHelper.ID));
            String name = cursor.getString(cursor.getColumnIndex(myDatabaseHelper.NAME));
            String email = cursor.getString(cursor.getColumnIndex(myDatabaseHelper.EMAIL));
            String password = cursor.getString(cursor.getColumnIndex(myDatabaseHelper.PASSWORD));
//            employees.add(new Employee(id, name, email, password));
//                if (email == editTextEmailText && password == passwordget){
//                    val=true;
//                }
        }
        return val;
    }

    public boolean checkUser(String email, String password)
    {
        SQLiteDatabase sqLiteDatabase = myDatabaseHelper.getWritableDatabase();
        String [] collomn = {myDatabaseHelper.ID};
        String selection = myDatabaseHelper.EMAIL + "=?" + " AND " + myDatabaseHelper.PASSWORD + "=?";
        String [] selectionArgs = {email , password};

        Cursor cursor = sqLiteDatabase.query(myDatabaseHelper.TABLE_NAME , collomn, selection, selectionArgs, null, null, null);

        int cursorCount = cursor.getCount();
        cursor.close();
        sqLiteDatabase.close();

        if(cursorCount > 0)
        {
            return true;
        }
        return  false;
    }
}
