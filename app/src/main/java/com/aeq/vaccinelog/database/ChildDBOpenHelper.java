package com.aeq.vaccinelog.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;

public class ChildDBOpenHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME="child.db";
    private static final int DATABASE_VERSION = 1;

    public ChildDBOpenHelper(@Nullable Context context){
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(Tables.CHILD_TABLE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(Tables.SQL_DELETE_TABLE_CHILD);
        onCreate(db);

    }
}
