package com.aeq.vaccinelog;

import android.app.LoaderManager;
import android.content.ContentValues;
import android.content.CursorLoader;
import android.content.Loader;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.CursorAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

public class MainActivity extends AppCompatActivity  implements LoaderManager.LoaderCallbacks<Cursor> {

    private CursorAdapter cursorAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        insertPatient("Ahmad","Ahmadi");

        String[] from = {DBOpenHelper.PATIENT_FN,DBOpenHelper.PATIENT_LN};
        int[] to = {android.R.id.text1};
        cursorAdapter = new SimpleCursorAdapter(this,android.R.layout.simple_list_item_1,null,from,to,0);
        ListView listView = (ListView) findViewById(android.R.id.list);
        listView.setAdapter(cursorAdapter);

        getLoaderManager().initLoader(0, null, this);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    private void insertPatient(String fn,String ln) {
        ContentValues values = new ContentValues();
        values.put(DBOpenHelper.PATIENT_FN,fn);
        values.put(DBOpenHelper.PATIENT_LN,ln);
        Uri patientUri = getContentResolver().insert(PatientsProvider.CONTENT_URI,values);
        Log.d("MainActivity", "Inserted patient " + patientUri.getLastPathSegment());
    }


    @Override
    public Loader<Cursor> onCreateLoader(int i, Bundle bundle) {
        return new CursorLoader(this, PatientsProvider.CONTENT_URI, null, null, null,null);
    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor cursor) {

        cursorAdapter.swapCursor(cursor);
    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {

        cursorAdapter.swapCursor(null);
    }
}
