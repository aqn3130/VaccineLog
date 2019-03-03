package com.aeq.vaccinelog.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.aeq.vaccinelog.model.DataItemChild;
import java.util.ArrayList;
import java.util.List;

public class DataSourceChild {
    private Context mContext;

    private SQLiteDatabase mDatabase;
    SQLiteOpenHelper mDbHelper;

    public DataSourceChild(Context context){

        this.mContext = context;
        mDbHelper = new ChildDBOpenHelper(mContext);
        mDatabase = mDbHelper.getWritableDatabase();
    }

    public void open(){
        mDatabase = mDbHelper.getWritableDatabase();
    }

    public void close(){
        mDbHelper.close();
    }

    public DataItemChild createItem(DataItemChild item){
        ContentValues values = item.toValues();
        mDatabase.insert(Tables.TABLE_CHILD,null,values);
        return item;

    }

    public int deleteItem(String firstName){
        String nameArr [] = {firstName};
        int rowsDeleted = mDatabase.delete(Tables.TABLE_CHILD,Tables.FIRST_NAME + "=?",nameArr);
        return rowsDeleted;
    }

    public int updateItem(DataItemChild itemChild){
        ContentValues values = itemChild.toValues();
        int item = mDatabase.update(Tables.TABLE_CHILD,values,null,null);
        return item;
    }

    public int updateVaccine(ContentValues values,String vaccine){
        String vaccineArr [] = {vaccine};
        int item = mDatabase.update(Tables.TABLE_CHILD,values,Tables.VACCINES + "=?",vaccineArr);
        return item;
    }

    public int updateFirstName(ContentValues values, String fName){
        String fNameArr [] = {fName};
        int item = mDatabase.update(Tables.TABLE_CHILD,values,Tables.FIRST_NAME + "=?",fNameArr);
        return item;
    }

    public int updateLastName(ContentValues values, String lName){
        String lNameArr [] = {lName};
        int item = mDatabase.update(Tables.TABLE_CHILD,values,Tables.LAST_NAME + "=?",lNameArr);
        return item;
    }

    public int updateDOB(ContentValues values, String dob){
        String dobArr [] = {dob};
        int item = mDatabase.update(Tables.TABLE_CHILD,values,Tables.DOB + "=?",dobArr);
        return item;
    }

    public int updateFatherName(ContentValues values, String fatherName){
        String fatherNameArr [] = {fatherName};
        int item = mDatabase.update(Tables.TABLE_CHILD,values,Tables.FATHER_NAME + "=?",fatherNameArr);
        return item;
    }

    public int updateMotherName(ContentValues values, String motherName){
        String motherNameArr [] = {motherName};
        int item = mDatabase.update(Tables.TABLE_CHILD,values,Tables.MOTHER_NAME + "=?",motherNameArr);
        return item;
    }

    public List<DataItemChild> getAllItems(String guardianId){
        List<DataItemChild> dataItemsChild = new ArrayList<>();

        String guardianArr[] = {guardianId};
        Cursor cursor = mDatabase.query(Tables.TABLE_CHILD,Tables.ALL_COLUMNS_CHILD,Tables.GUARDIAN_ID + "=?",guardianArr,null,null,null);

        while (cursor.moveToNext()){
            DataItemChild item = new DataItemChild();

            item.setGuardian_id(cursor.getString(cursor.getColumnIndex(Tables.GUARDIAN_ID)));
            item.setFirstName(cursor.getString(cursor.getColumnIndex(Tables.FIRST_NAME)));
            item.setLastName(cursor.getString(cursor.getColumnIndex(Tables.LAST_NAME)));
            item.setDateOfBirth(cursor.getString(cursor.getColumnIndex(Tables.DOB)));
            item.setFatherName(cursor.getString(cursor.getColumnIndex(Tables.FATHER_NAME)));
            item.setMotherName(cursor.getString(cursor.getColumnIndex(Tables.MOTHER_NAME)));
            item.setVaccines(cursor.getString(cursor.getColumnIndex(Tables.VACCINES)));
            dataItemsChild.add(item);
        }
        cursor.close();
        return dataItemsChild;
    }

    public DataItemChild getChild(String guardianId){

        String guardianArr[] = {guardianId};

        Cursor cursor = mDatabase.query(Tables.TABLE_CHILD,Tables.ALL_COLUMNS_CHILD,Tables.GUARDIAN_ID + "=?",guardianArr,null,null,null);

        DataItemChild item = null;
        while (cursor.moveToNext()){
            item = new DataItemChild();
            
            item.setGuardian_id(cursor.getString(cursor.getColumnIndex(Tables.GUARDIAN_ID)));
            item.setFirstName(cursor.getString(cursor.getColumnIndex(Tables.FIRST_NAME)));
            item.setLastName(cursor.getString(cursor.getColumnIndex(Tables.LAST_NAME)));
            item.setDateOfBirth(cursor.getString(cursor.getColumnIndex(Tables.DOB)));
            item.setFatherName(cursor.getString(cursor.getColumnIndex(Tables.FATHER_NAME)));
            item.setMotherName(cursor.getString(cursor.getColumnIndex(Tables.MOTHER_NAME)));
            item.setVaccines(cursor.getString(cursor.getColumnIndex(Tables.VACCINES)));
        }
        cursor.close();
        return item;
    }

    public DataItemChild getChildByFirstName(String childFirstName){

        String firstNameArr[] = {childFirstName};

        Cursor cursor = mDatabase.query(Tables.TABLE_CHILD,Tables.ALL_COLUMNS_CHILD,Tables.FIRST_NAME + "=?",firstNameArr,null,null,null);

        DataItemChild item = null;
        while (cursor.moveToNext()){
            item = new DataItemChild();

            item.setGuardian_id(cursor.getString(cursor.getColumnIndex(Tables.GUARDIAN_ID)));
            item.setFirstName(cursor.getString(cursor.getColumnIndex(Tables.FIRST_NAME)));
            item.setLastName(cursor.getString(cursor.getColumnIndex(Tables.LAST_NAME)));
            item.setDateOfBirth(cursor.getString(cursor.getColumnIndex(Tables.DOB)));
            item.setFatherName(cursor.getString(cursor.getColumnIndex(Tables.FATHER_NAME)));
            item.setMotherName(cursor.getString(cursor.getColumnIndex(Tables.MOTHER_NAME)));
            item.setVaccines(cursor.getString(cursor.getColumnIndex(Tables.VACCINES)));
        }
        cursor.close();
        return item;
    }
}
