package com.aeq.vaccinelog.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.aeq.vaccinelog.model.DataItem;

import java.util.ArrayList;
import java.util.List;

public class DataSource {
    private Context mContext;

    private SQLiteDatabase mDatabase;
    SQLiteOpenHelper mDbHelper;

    public DataSource(Context context){

        this.mContext = context;
        mDbHelper = new DBOpenHelper(mContext);
        mDatabase = mDbHelper.getWritableDatabase();
    }

    public void open(){
        mDatabase = mDbHelper.getWritableDatabase();
    }

    public void close(){
        mDbHelper.close();
    }

    public DataItem createItem(DataItem item){
        ContentValues values = item.toValues();
//        mDatabase.insert(DBOpenHelper.TABLE_PATIENT,null,values);
        mDatabase.insert(Tables.TABLE_PATIENT,null,values);
        return item;

    }

    public List<DataItem> getAllItems(String email){
        List<DataItem> dataItems = new ArrayList<>();
        
        
        String emailArr[] = {email};
//        Cursor cursor = mDatabase.query(DBOpenHelper.TABLE_PATIENT,DBOpenHelper.ALL_COLUMNS,DBOpenHelper.PATIENT_EMAIL + "=?",emailArr,null,null,null);
        Cursor cursor = mDatabase.query(Tables.TABLE_PATIENT,Tables.ALL_COLUMNS,Tables.PATIENT_EMAIL + "=?",emailArr,null,null,null);

        while (cursor.moveToNext()){
            DataItem item = new DataItem();
            item.setFirstName(cursor.getString(cursor.getColumnIndex(Tables.PATIENT_FN)));
            item.setLastName(cursor.getString(cursor.getColumnIndex(Tables.PATIENT_LN)));
            item.setEmail(cursor.getString(cursor.getColumnIndex(Tables.PATIENT_EMAIL)));
            item.setPassword(cursor.getString(cursor.getColumnIndex(Tables.PATIENT_PASSWORD)));
        }
        cursor.close();
        return dataItems;
    }

    public DataItem getUser(String email){

        String userEmails[] = {email};

        Cursor cursor = mDatabase.query(Tables.TABLE_PATIENT,Tables.ALL_COLUMNS,Tables.PATIENT_EMAIL + "=?",userEmails,null,null,null);

        DataItem item = null;
        while (cursor.moveToNext()){
            item = new DataItem();
            item.setFirstName(cursor.getString(cursor.getColumnIndex(Tables.PATIENT_FN)));
            item.setLastName(cursor.getString(cursor.getColumnIndex(Tables.PATIENT_LN)));
            item.setEmail(cursor.getString(cursor.getColumnIndex(Tables.PATIENT_EMAIL)));
            item.setPassword(cursor.getString(cursor.getColumnIndex(Tables.PATIENT_PASSWORD)));
        }
        cursor.close();
        return item;
    }
}
