package com.aeq.vaccinelog.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.aeq.vaccinelog.model.DataItemPractitioner;

import java.util.ArrayList;
import java.util.List;

public class DataSourcePractitioner {
    private Context mContext;

    private SQLiteDatabase mDatabase;
    SQLiteOpenHelper mDbHelper;

    public DataSourcePractitioner(Context context){

        this.mContext = context;
        mDbHelper = new PractitionerDBOpenHelper(mContext);
        mDatabase = mDbHelper.getWritableDatabase();
    }

    public void open(){
        mDatabase = mDbHelper.getWritableDatabase();
    }

    public void close(){
        mDbHelper.close();
    }

    public DataItemPractitioner createItem(DataItemPractitioner item){
        ContentValues values = item.toValues();
        mDatabase.insert(Tables.TABLE_PRACTITIONER,null,values);
        return item;

    }

    public int deleteItem(String email){
        String emailArr [] = {email};
        int rowsDeleted = mDatabase.delete(Tables.TABLE_PRACTITIONER,Tables.PRACTITIONER_EMAIL + "=?",emailArr);
        return rowsDeleted;
    }

    public List<DataItemPractitioner> getAllItems(){
        List<DataItemPractitioner> dataItemsPractitioner = new ArrayList<>();

        Cursor cursor = mDatabase.query(Tables.TABLE_PRACTITIONER,Tables.ALL_COLUMNS_PRACTITIONER,null,null,null,null,null);

        while (cursor.moveToNext()){
            DataItemPractitioner item = new DataItemPractitioner();

            item.setGuardian_id(cursor.getString(cursor.getColumnIndex(Tables.PRACTITIONER_GUARDIAN_ID)));
            item.setFirstName(cursor.getString(cursor.getColumnIndex(Tables.PRACTITIONER_FIRST_NAME)));
            item.setLastName(cursor.getString(cursor.getColumnIndex(Tables.PRACTITIONER_LAST_NAME)));
            item.setEmail(cursor.getString(cursor.getColumnIndex(Tables.PRACTITIONER_EMAIL)));
            item.setPassword(cursor.getString(cursor.getColumnIndex(Tables.PRACTITIONER_PASSWORD)));
            item.setDateOfBirth(cursor.getString(cursor.getColumnIndex(Tables.PRACTITIONER_DOB)));
            item.setAddress(cursor.getString(cursor.getColumnIndex(Tables.PRACTITIONER_ADDRESS)));
            item.setRegistration(cursor.getString(cursor.getColumnIndex(Tables.PRACTITIONER_REGISTRATION)));
            dataItemsPractitioner.add(item);
        }
        cursor.close();
        return dataItemsPractitioner;
    }

    public DataItemPractitioner getPractitioner(String email){

        String emailArr[] = {email};

        Cursor cursor = mDatabase.query(Tables.TABLE_PRACTITIONER,Tables.ALL_COLUMNS_PRACTITIONER,Tables.PRACTITIONER_EMAIL + "=?",emailArr,null,null,null);

        DataItemPractitioner item = null;
        while (cursor.moveToNext()){
            item = new DataItemPractitioner();

            item.setGuardian_id(cursor.getString(cursor.getColumnIndex(Tables.PRACTITIONER_GUARDIAN_ID)));
            item.setFirstName(cursor.getString(cursor.getColumnIndex(Tables.PRACTITIONER_FIRST_NAME)));
            item.setLastName(cursor.getString(cursor.getColumnIndex(Tables.PRACTITIONER_LAST_NAME)));
            item.setEmail(cursor.getString(cursor.getColumnIndex(Tables.PRACTITIONER_EMAIL)));
            item.setPassword(cursor.getString(cursor.getColumnIndex(Tables.PRACTITIONER_PASSWORD)));
            item.setDateOfBirth(cursor.getString(cursor.getColumnIndex(Tables.PRACTITIONER_DOB)));
            item.setAddress(cursor.getString(cursor.getColumnIndex(Tables.PRACTITIONER_ADDRESS)));
            item.setRegistration(cursor.getString(cursor.getColumnIndex(Tables.PRACTITIONER_REGISTRATION)));
        }
        cursor.close();
        return item;
    }
}
