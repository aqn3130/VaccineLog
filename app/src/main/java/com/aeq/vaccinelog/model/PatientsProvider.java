package com.aeq.vaccinelog.model;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.aeq.vaccinelog.database.DBOpenHelper;
import com.aeq.vaccinelog.database.DataSource;
import com.aeq.vaccinelog.database.Tables;

public class PatientsProvider extends ContentProvider {
    private static final String AUTHORITY = "com.aeq.vaccinelog.patientsprovider";
    private static final String BASE_PATH = "patients";
    public static final Uri CONTENT_URI = Uri.parse("content://" + AUTHORITY + "/" + BASE_PATH );

    // Constant to identify the requested operation
    private static final int PATIENTS = 1;
    private static final int PATIENTS_ID = 2;

    private static final UriMatcher uriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
    static {
        uriMatcher.addURI(AUTHORITY,BASE_PATH,PATIENTS);
        uriMatcher.addURI(AUTHORITY,BASE_PATH + "/#",PATIENTS_ID);
    }

    private SQLiteDatabase sqLiteDatabase;
    private DataSource dataSource;
    @Override
    public boolean onCreate() {


        DBOpenHelper openHelper = new DBOpenHelper(getContext());
        sqLiteDatabase = openHelper.getWritableDatabase();
//        dataSource = new DataSource(getContext());
//        dataSource.open();
        return true;
    }

    @Nullable
    @Override
    public Cursor query(@NonNull Uri uri, @Nullable String[] strings, @Nullable String s, @Nullable String[] strings1, @Nullable String s1) {
        return sqLiteDatabase.query(Tables.TABLE_PATIENT,Tables.ALL_COLUMNS,s,null,null,null,Tables.PATIENT_CREATED);

    }

    @Nullable
    @Override
    public String getType(@NonNull Uri uri) {
        return null;
    }

    @Nullable
    @Override
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues contentValues) {
        long id = sqLiteDatabase.insert(Tables.TABLE_PATIENT,null,contentValues);

        return Uri.parse(BASE_PATH + "/" + id);
    }

    @Override
    public int delete(@NonNull Uri uri, @Nullable String s, @Nullable String[] strings) {
        return sqLiteDatabase.delete(Tables.TABLE_PATIENT, s, strings);
    }

    @Override
    public int update(@NonNull Uri uri, @Nullable ContentValues contentValues, @Nullable String s, @Nullable String[] strings) {
        return sqLiteDatabase.update(Tables.TABLE_PATIENT,contentValues,s,strings);
    }
}
