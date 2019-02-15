package com.aeq.vaccinelog;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;

public class DBOpenHelper extends SQLiteOpenHelper {

    //Constants for db name and version
    private static final String DATABASE_NAME = "patients.db";
    private static final int DATABASE_VERSION = 1;

    //Constants for identifying table and columns
    public static final String TABLE_PATIENT = "patients";
    public static final String PATIENT_ID = "_id";
    public static final String PATIENT_FN = "patientFirstName";
    public static final String PATIENT_LN = "patientLastName";
    public static final String PATIENT_CREATED = "patientCreated";

    //SQL to create table
    private static final String TABLE_CREATE =
            "CREATE TABLE " + TABLE_PATIENT + " (" +
                    PATIENT_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    PATIENT_FN + " TEXT, " +
                    PATIENT_LN + " TEXT, " +
                    PATIENT_CREATED + " TEXT default CURRENT_TIMESTAMP" +
                    ")";

    public static final String ALL_COLUMNS[] = {PATIENT_ID,PATIENT_FN,PATIENT_LN,PATIENT_CREATED};

    public DBOpenHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        sqLiteDatabase.execSQL(TABLE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_PATIENT);
        onCreate(sqLiteDatabase);
    }
}
