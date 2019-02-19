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
        mDatabase.insert(DBOpenHelper.TABLE_PATIENT,null,values);
        return item;

    }

    public List<DataItem> getAllItems(){
        List<DataItem> dataItems = new ArrayList<>();
        Cursor cursor = mDatabase.query(DBOpenHelper.TABLE_PATIENT,DBOpenHelper.ALL_COLUMNS,null,null,null,null,null);

        while (cursor.moveToNext()){
            DataItem item = new DataItem();
            item.setEmail(cursor.getString(cursor.getColumnIndex(DBOpenHelper.PATIENT_FN)));
            item.setEmail(cursor.getString(cursor.getColumnIndex(DBOpenHelper.PATIENT_LN)));
            item.setEmail(cursor.getString(cursor.getColumnIndex(DBOpenHelper.PATIENT_EMAIL)));
            item.setEmail(cursor.getString(cursor.getColumnIndex(DBOpenHelper.PATIENT_PASSWORD)));
        }
        return dataItems;
    }
}
